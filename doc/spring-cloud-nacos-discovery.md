# Spring Cloud Alibaba：Nacos Discovery 服务注册与发现

`Nacos Discovery` 是什么？

> 服务发现是微服务架构体系中最关键的组件之一。
>
> 如果尝试着用手动的方式来给每一个客户端来配置所有服务提供者的服务列表是一件非常困难的事，而且也不利于服务的动态扩缩容。Nacos Discovery 可以帮助用户将服务自动注册到 Nacos 服务端并且能够动态感知和刷新某个服务实例的服务列表。
>
>除此之外，Nacos Discovery 也将服务实例自身的一些元数据信息，例如 host，port，健康检查URL，主页等-注册到 Nacos 。

关于 Nacos 的安装及启动请查看文章：[Spring Cloud Alibaba：Nacos 安装及使用](http://jemgeek.com/archives/2020/spring-cloud-nacos-install.html)

本篇将详细介绍 `Nacos Discovery` 服务注册与发现的一些技术实践。

## 快速接入

### 添加依赖

启动好 Nacos 服务端。然后在项目中添加依赖。

```xml
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
```

一个完整的 `pom.xml` 的配置如下：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.xingtuai.example</groupId>
    <artifactId>nacos-discovery-test</artifactId>
    <version>1.0-SNAPSHOT</version>
    <name>nacos-discovery-test</name>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>${spring.boot.version}</version>
        <relativePath/>
    </parent>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring.cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>com.alibaba.cloud</groupId>
                <artifactId>spring-cloud-alibaba-dependencies</artifactId>
                <version>${spring.cloud.alibaba.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>

        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```

> 注：在本项目的源代码中，依赖统一使用 `dependencies` 模块管理，且其中 `dependencyManagement` 节点也在  `dependencies` 模块中配置，上例仅演示必要的配置项，在项目源代码中有些许区别。

### 启动 Provider 服务提供者

Nacos Discovery 服务注册与发现中，一般有两个角色，一个是 Provider 服务提供者，一个是 Consumer 服务消费者。他们都需要将自身注册到 Naocs 中，这一步叫服务注册。服务提供者向外提供服务，服务消费者通过各种方式调用服务提供者完成业务功能。且一个服务，既可以作为提供者，同时也可以作为消费者。

**1. 配置 application.yml**

要使用 Nacos ，需要在 `application.yml` 或者 `bootstrap.yml` 中配置一些基本参数。如下所示：

```yaml
# Nacos 相关参数
nacos:
  server-addr: 192.168.9.17:8848
  username: nacos
  password: nacos
  # 命名空间，用作环境隔离
  namespace: 904174a3-d51f-43ed-a456-c4fd7386ecb3
  
spring:
  application:
    name: nacos-discovery-provider
  main:
    allow-bean-definition-overriding: true
  cloud:
    nacos:
      # 权限认证，nacos.core.auth.enabled=true 时需要添加
      username: ${nacos.username}
      password: ${nacos.password}
      discovery:
        server-addr: ${nacos.server-addr}
        # 命名空间，用作环境隔离
        namespace: ${nacos.namespace}
        # 分组，一般按照项目进行分组
        group: SPRING_CLOUD_EXAMPLE_GROUP
        # 自定义元数据
        metadata:
          # 版本
          version: 1.0
          # 地域
          region: hangzhou
```

上述配置比较完善，如果需要简化配置，则如下所示：

```yaml
spring:
  application:
    name: nacos-discovery-provider
  cloud:
    nacos:
      discovery:
        server-addr: 192.168.9.17:8848 
```

**2. 开启服务发现**

在项目启动类上添加注解 `@EnableDiscoveryClient` 即可。如下所示：

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosDiscoveryProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosDiscoveryProviderApplication.class, args);
    }
}

```

**3. 创建 REST 接口**

服务提供者需要提供接口以供消费者进行调用，一般使用 RESTful 风格的 HTTP 接口。如下所示：

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {

    @GetMapping("/echo/{message}")
    public String echo(@PathVariable String message) {
        return "Hello Nacos Discovery " + message;
    }
}
```

**4. 验证**

启动 Provider 服务提供者后，打开 Nacos 控制台，可以看到服务已经注册上去了，因为我使用的是 `dev` 开发环境的命名空间，所以服务注册在 `dev` 的命名空间内。

![nacos-discovery-provider.jpg](https://i.loli.net/2020/10/12/gr9CY7XKS83iJ1q.jpg)

### 启动 Consumer 服务消费者

Consumer 服务消费者的依赖的配置基本与 Provider 服务提供者相同，但是却要比它更复杂一点。因为在 Consumer 端需要去调用 Provider 端的 REST 服务。而调用方式也有很多种。

**1. RestTemplate 方式**

依赖、配置与 Provider 一致。

然后创建 `RestTemplate` 配置类。如下所示：

```java
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
```

然后调用 Provider 服务提供者。如下所示：

```java
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping
public class BaseTestController {

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Resource
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/echo")
    public String echoAppName() {
        // 使用 LoadBalanceClient 和 RestTemplate 结合的方式来访问
        // LoadBalanceClient 提供负载均衡的功能，并从 Nacos 中根据服务名获取服务实例
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-discovery-provider");
        String url = String.format("http://%s:%s/echo/%s", serviceInstance.getHost(), serviceInstance.getPort(), appName);

        log.info("request url: {}", url);
        return restTemplate.getForObject(url, String.class);
    }
}
```

启动项目后，打开浏览器请求：[http://localhost:8080/echo](http://localhost:8080/echo)

查看返回结果进行验证。

**2. Feign 方式**

首先需要添加 `Feign` 的依赖，如下所示：

```xml
<!-- Spring Cloud Feign -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```

添加完依赖以后，需要在项目启动类中添加 `@EnableFeignClients` 注解以开启功能。如下所示：

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosDiscoveryConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosDiscoveryConsumerApplication.class, args);
    }
}	
```

然后需要创建一个接口类 `FeignService`，在类中为 Provider 服务提供者提供的服务接口提供对应的访问方法。如下所示：

```java
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * nacos-discovery-provider 为服务提供者的服务名
 */
@FeignClient("nacos-discovery-provider")
public interface FeignService {

    /**
     * 接口定义
     * Provider 服务提供者对应的 REST 接口
     *
     * @param message
     * @return
     */
    @GetMapping("/echo/{message}")
    public String echo(@PathVariable String message);
}
```

在 Controller 中调用 `FeignService` 接口实现对 Provider 端的调用。代码如下：

```java
import com.xingtuai.cloud.nacos.discovery.service.FeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("feign")
public class FeignTestController {

    @Resource
    private FeignService feignService;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/echo")
    public String echoAppName() {
        return feignService.echo(appName);
    }
}
```

启动项目后，打开浏览器请求：[http://localhost:8080/feign/echo](http://localhost:8080/feign/echo)

查看返回结果进行验证。

## 多环境隔离

`Nacos Discovery` 与 `Nacos Config` 的环境隔离是一样的，都是通过命名空间 `namespace` 进行区分。

具体请参考之前的文章：[Spring Cloud Alibaba：Nacos Config 配置中心](http://jemgeek.com/archives/2020/spring-cloud-nacos-config.html)

在实际开发中，通过这种方式可以非常好的对各种环境进行隔离区分，避免服务管理的混乱。

## 结合 Sentinel 熔断

`Sentinel` 是阿里微服务生态中一个比较重要的组件，功能也比较多，在此仅简单介绍。后续会有专题对其进行详细的研究实践。

此处结合，主要是在 Feign 调用的时候，进行处理。在调用失败时，可以进行熔断。

首先需要添加依赖，如下所示：

```xml
<!-- Sentinel -->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
</dependency>
```

在 `application.yml` 中进行配置，如下所示：

```yaml
nacos:
  server-addr: 192.168.9.17:8848
  username: nacos
  password: nacos
  namespace: 904174a3-d51f-43ed-a456-c4fd7386ecb3
sentinel:
  dashboard: 192.168.9.17:8883
  
spring:
  application:
    name: nacos-discovery-sentinel
  main:
    allow-bean-definition-overriding: true
  cloud:
    nacos:
      # 权限认证，nacos.core.auth.enabled=true 时需要添加
      username: ${nacos.username}
      password: ${nacos.password}
      # Nacos 服务注册与发现
      discovery:
        server-addr: ${nacos.server-addr}
        namespace: ${nacos.namespace}
        group: SPRING_CLOUD_EXAMPLE_GROUP
    # Spring Cloud Alibaba Sentinel 配置
    sentinel:
      transport:
      	# Sentinel 控制台
        dashboard: ${sentinel.dashboard}

feign:
  # 开启 feign 对 sentinel 的支持
  sentinel:
    enabled: true
```

创建一个 `FeignService` 接口方法失败时的回调类 `FeignServiceFallback` ，代码如下：

```java
public class FeignServiceFallback implements FeignService {
    @Override
    public String echo(String message) {
        return "echo fallback, please try again.";
    }
}
```

当访问 `echo(String message)` 方法失败时，将会进入此回调，返回你需要的数据格式。

除此之外还需要创建一个配置类 `FeignConfig` ，代码如下：

```java
import com.xingtuai.cloud.nacos.discovery.service.fallback.FeignServiceFallback;
import org.springframework.context.annotation.Bean;

public class FeignConfig {

    @Bean
    public FeignServiceFallback feignServiceFallback() {
        return new FeignServiceFallback();
    }
}
```

然后需要改造一下 `FeignService` 接口，将 `FeignServiceFallback` 及 `FeignConfig` 设置在注解 `@FeignClient` 中，改造如下：

```java
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * nacos-discovery-provider 为服务提供者的服务名
 */
@FeignClient(name = "nacos-discovery-provider", fallback = FeignServiceFallback.class, configuration = FeignConfig.class)
public interface FeignService {

    /**
     * 接口定义
     * Provider 服务提供者对应的 REST 接口
     *
     * @param message
     * @return
     */
    @GetMapping("/echo/{message}")
    public String echo(@PathVariable String message);
}
```

正常访问时，接口将返回正常的数据，但是当接口出现异常，比如服务提供者下线了，访问失败的话。那么将会调用 `FeignServiceFallback` 中的 `echo(String message)` 方法并返回。这样就避免返回异常，而是返回一个可控的数据，可以用做服务熔断。

Sentinel 相关的知识与实践还有很多，后续会做专题分享，在此不再赘述。

## 项目源代码

[GitHub - spring-cloud-example](https://github.com/JemGeek/spring-cloud-example/tree/master/nacos/nacos-discovery)

