docker build -t spring-cloud-consumer:1.0.1 .

docker tag spring-cloud-consumer:1.0.1 jemgeek/spring-cloud-consumer:1.0.1

docker tag spring-cloud-consumer:1.0.1 jemgeek/spring-cloud-consumer:latest

docker push jemgeek/spring-cloud-consumer:1.0.1

docker push jemgeek/spring-cloud-consumer:latest


上传完毕之后，在服务器端使用下面的命令运行

docker logs spring-cloud-consumer

docker stop spring-cloud-consumer

docker rm spring-cloud-consumer

docker pull jemgeek/spring-cloud-consumer:latest

docker run --name spring-cloud-consumer -p 8871:8871 -d jemgeek/spring-cloud-consumer:latest

docker pull jemgeek/spring-cloud-consumer:1.0.1

docker run --name spring-cloud-consumer -p 8871:8871 -d jemgeek/spring-cloud-consumer:1.0.1

docker run --name spring-cloud-consumer -p 8871:8871 -d spring-cloud-consumer:1.0.1