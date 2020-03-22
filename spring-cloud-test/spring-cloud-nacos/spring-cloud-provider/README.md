docker build -t spring-cloud-provider:1.0.0 .

docker tag spring-cloud-provider:1.0.0 jemgeek/spring-cloud-provider:1.0.0

docker tag spring-cloud-provider:1.0.0 jemgeek/spring-cloud-provider:latest

docker push jemgeek/spring-cloud-provider:1.0.0

docker push jemgeek/spring-cloud-provider:latest


上传完毕之后，在服务器端使用下面的命令运行

docker logs spring-cloud-provider

docker stop spring-cloud-provider

docker rm spring-cloud-provider

docker pull jemgeek/spring-cloud-provider:latest

docker run --name spring-cloud-provider -p 8870:8870 -d jemgeek/spring-cloud-provider:latest

docker pull jemgeek/spring-cloud-provider:1.0.0

docker run --name spring-cloud-provider -p 8870:8870 -d jemgeek/spring-cloud-provider:1.0.0

docker run --name spring-cloud-provider -p 8870:8870 -d spring-cloud-provider:1.0.0