# Nacos Discovery 服务注册与发现


### 项目主要功能

1. 使用 namespace 实现环境隔离，使用 group 区分项目
2. 使用 `spring.cloud.nacos.discovery.metadata` 来自定义元数据, 可以此做灰度发布等，具体待预研
3. 定义提供者与消费者，以及两者之间的调用
4. 引入 Sentinel 做流量限流等
5. Sentinel Feign 结合，@SentinelResource 注解
    SentinelResource 注解提供了 defaultFallback 做统一回调
    BlockHandle 可以结合 ResponseResult 提示接口被限流等处理。
6. Sentinel 结合 Nacos Config 做持久化（据说阿里云服务器可以，害）
    目前可以更新 nacos 后立刻同步到 sentinel
    但是 sentinel dashboard 更新后无法同步到 nacos config，可以自己改造，后期再预研。
    参考文档：
    http://www.itmuch.com/spring-cloud-alibaba/sentinel-rules-persistence-push-mode-using-nacos/#%E5%9B%9B%E3%80%81Sentinel%E6%8E%A7%E5%88%B6%E5%8F%B0%E6%94%B9%E9%80%A0
    https://github.com/alibaba/Sentinel/wiki/%E5%9C%A8%E7%94%9F%E4%BA%A7%E7%8E%AF%E5%A2%83%E4%B8%AD%E4%BD%BF%E7%94%A8-Sentinel  
    https://github.com/alibaba/Sentinel/wiki/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%99%E6%89%A9%E5%B1%95
    
sentinel 参考文档：https://github.com/sentinel-group/sentinel-awesome

**spring-cloud-example-sentinel-rule**

```json
[
    {
        "resource": "/users/{id}",
        "limitApp": "default",
        "grade": 1,
        "count": 100,
        "strategy": 0,
        "controlBehavior": 0,
        "clusterMode": false
    },{
        "resource": "UserService.getUser",
        "limitApp": "default",
        "grade": 1,
        "count": 1,
        "strategy": 0,
        "controlBehavior": 0,
        "clusterMode": false
    }
]
```