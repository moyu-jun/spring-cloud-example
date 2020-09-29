# Spring Cloud Alibaba：Nacos Config 配置中心

`Nacos Config` 是什么？

> Nacos 提供用于存储配置和其他元数据的 key/value 存储，为分布式系统中的外部化配置提供服务器端和客户端支持。使用 Spring Cloud Alibaba Nacos Config，您可以在 Nacos Server 集中管理你 Spring Cloud 应用的外部属性配置。
>
>  Spring Cloud Alibaba Nacos Config 是 Config Server 和 Client 的替代方案，客户端和服务器上的概念与 Spring Environment 和 PropertySource 有着一致的抽象，在特殊的 bootstrap 阶段，配置被加载到 Spring 环境中。当应用程序通过部署管道从开发到测试再到生产时，您可以管理这些环境之间的配置，并确保应用程序具有迁移时需要运行的所有内容。

在了解 `Nacos Config` 之前，如有需要可以先看下上一篇文章: [Spring Cloud Alibaba：Nacos 安装及使用](http://jemgeek.com/archives/2020/spring-cloud-nacos-install.html)。

本篇将详细介绍 `Nacos Config` 配置中心的一些技术实践。

## 快速接入

**1. Nacos 服务端添加配置**

先安装好 Nacos Server ，然后启动。安装方式可以参考 [Spring Cloud Alibaba：Nacos 安装及使用](http://jemgeek.com/archives/2020/spring-cloud-nacos-install.html)。

在 **配置管理** - **配置列表** 中添加一个配置。如下图所示：

![nacos-config-base-yaml.jpg](https://i.loli.net/2020/09/29/TEyY87BkrXqtbeH.jpg)

编辑好之后点击发布即可。

* Data ID : 一般为应用名称，对应 Spring Boot 项目中的 `spring.application.name` 参数
* Group : 组，一般用来区分项目，此处直接用默认的公共组，后续会详细说明
* 配置格式: 一般默认为 **Properties** 格式，你可以根据自己的喜好去切换。

**2. 客户端使用**

以 Spring Boot 项目为例。先添加依赖：

```xml
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
</dependency>
```

在 `resource` 文件夹中创建配置文件 `bootstrap.yml` 来配置 Nacos Server 相关的参数，如下所示：

```yaml
spring:
  application:
    name: nacos-config-base
  main:
    allow-bean-definition-overriding: true
  cloud:
    nacos:
      # 权限认证，nacos.core.auth.enabled=true 时需要添加
      username: nacos
      password: James2020+
      config:
        # nacos config 的开关
#        enabled: false
        prefix: nacos-config-base
        file-extension: yaml
        group: DEFAULT_GROUP
```
创建启动类 `NacosConfigBaseApplication` ，代码如下所示：

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class NacosConfigBaseApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(NacosConfigBaseApplication.class, args);
        while (true) {
            // 当动态配置刷新时，会更新到 Enviroment 中，因此这里每隔一秒中从 Enviroment 中获取配置
            String userName = applicationContext.getEnvironment().getProperty("base.name");
            String userAge = applicationContext.getEnvironment().getProperty("base.age");
            System.err.println("name :" + userName + "; age: " + userAge);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

上面的代码是每隔一秒，获取一次 `base.name` 与 `base.age` 参数并打印。

 `applicationContext.getEnvironment().getProperty("base.age");` 这是获取参数的一种方式。还可以用过注解来获取。

将启动类的代码注释掉，创建一个 `TestController ` 类，添加如下代码：

```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

    @Value("${base.name}")
    String name;

    @Value("${base.age}")
    String age;

    @GetMapping("/name")
    public String getName() {
        return name;
    }

    @GetMapping("/age")
    public String getAge() {
        return age;
    }
}
```

我们可以把 Nacos Config 中配置的参数，当成本地参数一样，使用 `@Value("${}")`注解来获取。同时加上 `@RefreshScope` 注解以保证可以实时更新。

## 多环境隔离

日常开发中，我们常常会有开发环境，测试环境，预发布环境，生产环境等等。为了更好的区别这些环境，且防止配置混乱。官方及我个人都非常推荐使用 namespace 进行环境隔离。

> 注：Nacos Config 支持 profile 粒度的环境区分，但个人不建议这么使用。使用 namespace 做环境隔离更彻底更安全，也更易于管理。

### namespace 概念

这里引用官方的概念说明：

> 用于进行租户粒度的配置隔离。不同的命名空间下，可以存在相同的 Group 或 Data ID 的配置。Namespace 的常用场景之一是不同环境的配置的区分隔离，例如开发测试环境和生产环境的资源（如配置、服务）隔离等。

### namaspace 创建

打开 Nacos 控制台，在 **命名空间** 中可以对其进行管理，如下图所示。

![nacos-namespace-web.jpg](https://i.loli.net/2020/09/29/hfGVX5Sn9FaueK2.jpg)

要注意的是，在项目中如果要指定命名空间，是通过 `命名空间ID`的，而不是通过名称。

配置好了命名空间后，再打开配置列表，则可以在上方看到目前所有的命名空间。不同的命名空间可以允许存在相同 Data ID 的配置。

![nacos-namespace-show.jpg](https://i.loli.net/2020/09/29/i4WzafxEIw2egNj.jpg)

namespace 在代码中的配置如下：

```yaml
spring:
  cloud:
    nacos:
      config:
      	# 这里使用的是命名空间 ID 
        namespace: 904174a3-d51f-43ed-a456-c4fd7386ecb3
```

### 自定义 Group

一般我们会使用 namespace 区分环境，使用 Group 来区分项目，使用 Data ID 区分配置。以此来管理多项目，多环境下的配置文件。

Group 一般没有指定的话，默认为 DEFAULT_GROUP 。如果需要自定义的话，在 Nacos 控制台，创建配置文件的时候自定义即可。在代码中写法如下：

```yaml
spring:
  cloud:
    nacos:
      config:
        group: SPRING_CLOUD_EXAMPLE_GROUP
```

### 项目配置实践

在项目实际配置中，个人建议如下按照如下方式进行配置。

首先，配置文件要按照如下方式建立：

* application.yml          : 存储一些不需要放在 Nacos Config 的配置
* bootstrap.yml            : 基础配置，配置 Nacos Config 的基础配置
* bootstrap-dev.yml     : 环境参数，开发环境
* bootstrap-test.yml     : 环境参数，测试环境
* bootstrap-prod.yml   : 环境参数，线上环境

配置内容分别如下：

**bootstrap-dev.yml**

```yaml
nacos:
  server-addr: 127.0.0.1:8848
  username: username
  password: password
  # 开发环境的 namespace ID
  namespace: 904174a3-d51f-43ed-a456-c4fd7386ecb3
```

**bootstrap-test.yml**

```yaml
nacos:
  server-addr: 192.168.9.10:8848
  username: username
  password: password
  # 测试环境的 namespace ID
  namespace: a463038a-525b-4ad0-988e-ec71ff043c22
```

**bootstrap-prod.yml**

```yaml
nacos:
  server-addr: 100.100.10.1:8848
  username: username
  password: password
  # 生产环境的 namespace ID
  namespace: 0d84f533-74ca-4ca5-9dd8-01e8866cd0c4
```

**bootstrap.yml**

```yaml
spring:
  profiles:
    active: dev
  application:
    name: nacos-config-advanced
  main:
    allow-bean-definition-overriding: true
  cloud:
    nacos:
      # 权限认证，nacos.core.auth.enabled=true 时需要添加
      username: ${nacos.username}
      password: ${nacos.password}
        config:
          server-addr: ${nacos.server-addr}
          namespace: ${nacos.namespace}
          prefix: nacos-config-base
          file-extension: yaml
          group: SPRING_CLOUD_EXAMPLE_GROUP
```

## 共享配置 & 多配置文件

日常开发中，多个模块可能会有很多共用的配置，比如数据库连接信息，Redis 连接信息，RabbitMQ 连接信息，监控配置等等。

那么此时，我们就希望可以加载多个配置，多个项目共享同一个配置之类等功能。Nacos Config 也确实支持。

我们可以使用 `spring.cloud.nacos.config.shared-configs` 和 `spring.cloud.nacos.config.extension-configs` 两个参数节点来配置。

配置实例如下：

```yaml
spring:
  application:
    name: nacos-config-multi
  main:
    allow-bean-definition-overriding: true
  cloud:
    nacos:
      username: ${nacos.username}
      password: ${nacos.password}
      config:
        server-addr: ${nacos.server-addr}
        namespace: ${nacos.namespace}
        # 用于共享的配置文件
        shared-configs:
          - data-id: common-mysql.yaml
            group: SPRING_CLOUD_EXAMPLE_GROUP
            
          - data-id: common-redis.yaml
            group: SPRING_CLOUD_EXAMPLE_GROUP
            
          - data-id: common-base.yaml
            group: SPRING_CLOUD_EXAMPLE_GROUP

        # 常规配置文件
        # 优先级大于 shared-configs，在 shared-configs 之后加载
        extension-configs:
          - data-id: nacos-config-advanced.yaml
            group: SPRING_CLOUD_EXAMPLE_GROUP
            refresh: true

          - data-id: nacos-config-base.yaml
            group: SPRING_CLOUD_EXAMPLE_GROUP
            refresh: true
```

参数解析：

* data-id : Data Id
* group：自定义 Data Id 所在的组，不明确配置的话，默认是 DEFAULT_GROUP。
* refresh: 控制该 Data Id 在配置变更时，是否支持应用中可动态刷新， 感知到最新的配置值。默认是不支持的。

> 这里的Data ID 需要注意，后面是加 `.yaml` 后缀的，且不需要指定 `file-extension`。这个有一个小坑，那就是在 Nacos 控制台添加配置文件时，Data ID 的命名就要是 `common-mysql.yaml` 这种带后缀的。且后缀名要和配置类型想匹配，否则将会读取不到配置。

具体配置如下图所示，可与之前章节的配置对比下，之前章节的 Data ID 是没有带后缀的。

![nacos-config-multi-web.jpg](https://i.loli.net/2020/09/29/FIZ9EW12OaelJyv.jpg)

关于多配置文件的优先级问题：

1. 后加载的优先级高；
2. extension-configs 优先级大于 shared-configs，因为在 shared-configs 之后加载
3.  shared-configs 与 extension-configs 的配置列表中，在下面的配置优先级高。

## 项目源代码

[GitHub - spring-cloud-example](https://github.com/JemGeek/spring-cloud-example)