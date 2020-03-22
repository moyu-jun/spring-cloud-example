docker build -t spring-cloud-nacos-dubbo-server:1.0.0 .

docker rmi -f spring-cloud-nacos-dubbo-server:1.0.0

docker tag spring-cloud-nacos-dubbo-server:1.0.0 jemgeek/spring-cloud-nacos-dubbo-server:1.0.0

docker tag spring-cloud-nacos-dubbo-server:1.0.0 jemgeek/spring-cloud-nacos-dubbo-server:latest

docker push jemgeek/spring-cloud-nacos-dubbo-server:1.0.0

docker push jemgeek/spring-cloud-nacos-dubbo-server:latest


上传完毕之后，在服务器端使用下面的命令运行

docker logs spring-cloud-nacos-dubbo-server

docker stop spring-cloud-nacos-dubbo-server

docker rm spring-cloud-nacos-dubbo-server

docker pull jemgeek/spring-cloud-nacos-dubbo-server:latest

docker run --name spring-cloud-nacos-dubbo-server -p 8840:8840 -d jemgeek/spring-cloud-nacos-dubbo-server:latest

docker pull jemgeek/spring-cloud-nacos-dubbo-server:1.0.0

docker run --name spring-cloud-nacos-dubbo-server -p 8840:8840 -d jemgeek/spring-cloud-nacos-dubbo-server:1.0.0

docker run --name spring-cloud-nacos-dubbo-server -p 8840:8840 -d spring-cloud-nacos-dubbo-server:1.0.0



# 重难点记录

1. 因 Docker 容器间通信问题，在部署到 Docker 时，不能将 Nacos 注册中心的地址写为本地，因为容器中的程序无法访问。

2. 在使用 application-dev 及 application-prod 多环境配置时，不能将 dubbo 属性拆分，否则将无法读取完全（之前是因文件名写错，此条暂未彻底验证）。