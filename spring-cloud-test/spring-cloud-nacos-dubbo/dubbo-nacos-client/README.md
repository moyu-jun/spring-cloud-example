docker build -t spring-cloud-nacos-dubbo-client:1.0.0 .

docker rmi -f spring-cloud-nacos-dubbo-client:1.0.0

docker tag spring-cloud-nacos-dubbo-client:1.0.0 jemgeek/spring-cloud-nacos-dubbo-client:1.0.0

docker tag spring-cloud-nacos-dubbo-client:1.0.0 jemgeek/spring-cloud-nacos-dubbo-client:latest

docker push jemgeek/spring-cloud-nacos-dubbo-client:1.0.0

docker push jemgeek/spring-cloud-nacos-dubbo-client:latest


上传完毕之后，在服务器端使用下面的命令运行

docker logs spring-cloud-nacos-dubbo-client

docker stop spring-cloud-nacos-dubbo-client

docker rm spring-cloud-nacos-dubbo-client

docker pull jemgeek/spring-cloud-nacos-dubbo-client:latest

docker run --name spring-cloud-nacos-dubbo-client -p 8841:8841 -d jemgeek/spring-cloud-nacos-dubbo-client:latest

docker pull jemgeek/spring-cloud-nacos-dubbo-client:1.0.0

docker run --name spring-cloud-nacos-dubbo-client -p 8841:8841 -d jemgeek/spring-cloud-nacos-dubbo-client:1.0.0

docker run --name spring-cloud-nacos-dubbo-client -p 8841:8841 -d spring-cloud-nacos-dubbo-client:1.0.0