# Spring Cloud Alibaba Nacos Config Example

## 项目说明

本项目演示如何使用 Nacos Config Starter 完成 Spring Cloud 应用的配置管理。

Nacos 是阿里巴巴开源的一个更易于构建云原生应用的动态服务发现、配置管理和服务管理平台。

## 示例

### 如何接入

1. 首先，修改 pom.xml 文件，引入 Nacos Config Starter。

```maven
 <dependency>
     <groupId>com.alibaba.cloud</groupId>
     <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
 </dependency>
```

2. 在应用的 /src/main/resources/bootstrap.properties 配置文件中配置 Nacos Config 元数据。这里需要注意，参数需要写在 bootstrap 文件中，否则会加载失败

```yaml
server:
  port: 8081

spring:
  application:
    name: spring-cloud-nacos-config
  cloud:
    nacos:
      config:
        # Nacos 地址
        server-addr: 127.0.0.1:8848
        # 文件名，默认为 spring.application.name
        prefix: spring-cloud-nacos-config 
        # 文件格式，默认为 properties
        file-extension: yaml
```

3. 完成上述两步后，应用会从 Nacos Config 中获取相应的配置，并添加在 Spring Environment 的 PropertySources 中。这里我们使用 @Value 注解来将对应的配置注入到 SampleController 的 userName 和 age 字段，并添加 @RefreshScope 打开动态刷新功能

```java
@RestController
@RefreshScope   // 使配置内容支持动态刷新
public class TestController {

    @Value("${user.name}")
    String name;

    @RequestMapping("/name")
    public String getName() {
        return name;
    }
}
```


## 备注

**bootstrap 与 application 的加载顺序**

bootstrap.yml（bootstrap.properties）用来在程序引导时执行，应用于更加早期配置信息读取，如可以使用来配置application.yml中使用到参数等

application.yml（application.properties) 应用程序特有配置信息，可以用来配置后续各个模块中需使用的公共参数等。

bootstrap.yml 先于 application.yml 加载

## 参考资料

[官方文档](https://github.com/alibaba/spring-cloud-alibaba/blob/master/spring-cloud-alibaba-examples/nacos-example/nacos-config-example/readme-zh.md)

[Spring Boot 中application.yml与bootstrap.yml的区别](https://blog.csdn.net/jeikerxiao/article/details/78914132)
