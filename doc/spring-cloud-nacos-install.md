# Spring Cloud Alibaba：Nacos 安装及使用

`Nacos` 是什么？

> Nacos 致力于帮助开发者发现、配置和管理微服务。Nacos 提供了一组简单易用的特性集，帮助开发者快速实现动态服务发现、服务配置、服务元数据及流量管理。
>  
>  Nacos 帮助开发者更敏捷和容易地构建、交付和管理微服务平台。 Nacos 是构建以“服务”为中心的现代应用架构 (例如微服务范式、云原生范式) 的服务基础设施。

`Nacos` 主要包含两个部分，一个是配置中心，一个是服务注册与发现。本系列的文章将依次对其进行分享介绍。

本篇将着重介绍 `Nacos` 的单机与集群安装及一些基本的使用。

## 版本说明

* Windows: win 10 64位系统
* Linux: Centos 7 64位系统
* Nacos: 1.3.2 (当前最新稳定版本)

## Windows 单机安装

### 下载软件包

前往 [GitHub Nacos Release](https://github.com/alibaba/nacos/releases/tag/1.3.2) 下载 `nacos-server-1.3.2.zip` 软件包到本地。

本地解压，目录结构如下图所示。

![nacos-server-dir.png](https://i.loli.net/2020/09/29/d43bpXsuAI9PEQw.png)

```
bin    : 启动/关闭脚本
conf   : Nacos 的配置文件
data   : 未做持久化的时候数据会存储在此，比如配置数据(第一次运行后才会生成)
logs   : Nacos 日志(第一次运行后才会生成)
target : nacos-server.jar 运行文件
```

### 参数配置

打开文件 `conf/application.properties` 文件，对 nacos 进行配置。

```properties
### 配置网页端访问端口
server.port=8848

### 配置数据持久化的数据库，这里使用 mysql
### 这里的配置默认是注释掉的，需要手动去除注释
### 如果需要启用数据库的话，需要导入 conf/nacos-mysql.sql 脚本
### 如果不启用数据库，则数据将持久化到本地 data/ 目录下
### If use MySQL as datasource:
spring.datasource.platform=mysql

### Count of DB:
db.num=1

### 数据库可以有多个，db.url.0=xxx db.url.1=xxx db.url.2=xxx
### 此处仅使用一个
### Connect URL of DB:
db.url.0=jdbc:mysql://127.0.0.1:3306/nacos?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC
db.user=username
db.password=password

### 打开认证授权系统，默认为 false 
### 此项配置并不会影响网页端的登录，设置为 true 或是 false 网页端访问时均需要登录
### 此项配置开启的话，在代码中需要配置 nacos 的用户名及密码
### 即 spring.cloud.nacos.username 和 spring.cloud.nacos.password 两个参数，对应的是网页端登录的用户名密码
### If turn on auth system:
nacos.core.auth.enabled=true

### 其他配置根据自己的需求配置即可
```

> 注意: 
>
>   * 如需启用数据库，需要导入 conf/nacos-mysql.sql 脚本！
>   * 如需开启认证授权，需要在项目代码中配置用户名密码，否则会访问失败！

### 启动

启动脚本在 `bin/` 目录下，windows 下使用 `shutdown.cmd` 与 `startup.cmd` 两个脚本。

`nacos 1.3.2` 的脚本有个小改动，默认启动模式为 `cluster` 集群模式，所以要单机启动的话，有两种方案。

1. 带参数运行

创建脚本文件 `startup-standalone.cmd`，添加以下代码到文件中。

```shell
startup.cmd -m standalone
```

然后双击启动 `startup-standalone.cmd` 脚本即可。或者每次启动时使用 `startup.cmd -m standalone` 命令启动。

个人认为写个 `startup-standalone.cmd` 脚本更方便。

2. 修改原有的脚本

使用编辑器打开脚本文件 `bin/startup.cmd`，找到大概 27 行，按照下方代码编辑。

```shell
## 原本的代码
set MODE="cluster"

## 修改后的代码
set MODE="standalone"
```

修改后保存，然后直接运行 `bin/startup.cmd` 脚本即可。

### 验证

双击 `bin/startup.cmd` 或 `bin/startup-standalone.cmd` 脚本，单机运行，运行成功则如下图所示。

![nacos-server-startup.png](https://i.loli.net/2020/09/29/xAaSQb7dCZ5WV3s.png)

可以看到启动的端口号，以及启动模式为 `stand alone mode` 单机模式，使用了外部存储（mysql）。

浏览器中打开链接: [http://localhost:8848/nacos](http://localhost:8848/nacos) 访问 Nacos。

输入用户名（默认为nacos）密码（默认为nacos），进入首页如下图所示。

![nacos-web-index.png](https://i.loli.net/2020/09/29/1fU4xwnzeMCKBWt.png)

具体的使用下章细说。注意登录成功后要修改密码，不要使用默认密码。

## Linux 单机安装

### 下载软件包

前往 [GitHub Nacos Release](https://github.com/alibaba/nacos/releases/tag/1.3.2) 下载 `nacos-server-1.3.2.tar.gz` 软件包到本地。

然后使用命令解压。

```shell
# 下载软件包
# 如果使用 wget 下载的比较慢的话，可以在 windows 下载，然后传输到 linux 上。
# 而且 .zip 和 .tar.gz 两个包仅是压缩方式不同，里面的文件是一样的，两个包都可以使用。
wget https://github.com/alibaba/nacos/releases/download/1.3.2/nacos-server-1.3.2.tar.gz

# 解压
# 建议自己创建一个 nacos 应用目录，解压到 nacos 应用目录中，方便管理
tar -xvf nacos-server-1.3.2.tar.gz
```

目录结构与 windows 中的一致，不再赘述。

### 参数配置

参数配置也与 windows 中的一致，不再赘述。

### 启动

启动模式也基本与 windows 一致，只是需要使用 `shutdown.sh` 与 `startup.sh` 脚本。命令如下：

```shell
# 启动命令 - Linux 自动后台运行
sh startup.sh -m standalone

# 关闭命令
sh shutdown.sh
```

同样，可以创建一个 `startup-standalone.sh` 脚本来直接启动。具体参考 windows 对应章节，不再赘述。

Linux 下启动会自动后台运行，运行成功后，如下图所示。

![nacos-server-startup-linux.png](https://i.loli.net/2020/09/29/iGvBKMHRaUCtJOp.png)

如需查看启动日志，可以使用下面的命令，日志的结果与 windows 几乎一致。

```shell
# 日志所在路径，如上图最后一句打印日志所示
# nacos is starting，you can check the /root/soft/nacos/nacos/logs/start.out
tail -300f /root/soft/nacos/nacos/logs/start.out
```

### 验证

Linux 系统需要注意防火墙是否开启，是否开启了 `8848` 端口或是自定义的端口。如果是阿里云或其他云服务器，同样需要记得开启端口，否则无法访问。

其他均与 windows 相同，不再赘述。

## Docker 单机安装

> 阅读此章节，默认已了解 `Docker ` 的基础知识，不了解请先学习一下 `Docker `的基本知识。

Docker 下的安装有两种，一种是官方的 [nacos-docker](https://github.com/nacos-group/nacos-docker) 仓库示例。一种自己编写 `docker-compose` 进行自定义部署。

###  [nacos-docker](https://github.com/nacos-group/nacos-docker) 官方示例

按照下面的命令进行部署。

```shell
# 克隆项目
# --depth 1 表示只克隆最近的一次 commit，这样下载的数据量最小
git clone --depth 1 https://github.com/nacos-group/nacos-docker.git
cd nacos-docker

# 单机 MySQL 模式
docker-compose -f example/standalone-mysql.yaml up -d

# 集群模式
docker-compose -f example/cluster-hostname.yaml up -d
```

此种方式，单机模式，将创建四个容器 `nacos-server`、`mysql`、`prometheus`和`grafana`。

 对于我个人而言，我有自己的数据库，没必要再额外创建一个 mysql，另外 `prometheus` 和 `grafana` 的监控我也咱不需要。使用这种方式，比较占用服务器的资源。

 对于仅需要 nacos 功能的用户来说，自定义部署可能更加方便。如果想要懒人部署，或者有监控需要，可以使用这种部署方式。另外，官方的部署文件及配置很有参考价值。

### 自定义部署

创建一个 `docker-compose.yaml` 文件，将下列配置添加到文件中。

```yaml
version: '3'
services:
  nacos-server:
    image: nacos/nacos-server:1.3.2
    container_name: nacos-server
    hostname: nacos-server
    restart: always
    ports:
      - 8848:8848
    networks:
      - dev
    volumes:
      - ./logs/:/home/nacos/logs
      - ./conf/custom.properties:/home/nacos/init.d/custom.properties
    environment:
      - "MODE=standalone"
      - "SPRING_DATASOURCE_PLATFORM=mysql"
      # 使用你自己的数据库连接信息
      - "MYSQL_SERVICE_HOST=127.0.0.1"
      - "MYSQL_SERVICE_PORT=3306"
      - "MYSQL_SERVICE_USER=username"
      - "MYSQL_SERVICE_PASSWORD=password"
      - "MYSQL_SERVICE_DB_NAME=nacos"
      # 开启认证系统
      - "NACOS_AUTH_ENABLE=true"

# 自定义网络
networks:
  dev:
    external: true
```

Nacos Docker 环境变量：

| 名称                            | 描述                                                         | 选项                                                         |
| ------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| MODE                            | cluster/standalone                                           | cluster/standalone default **cluster**                       |
| NACOS_SERVERS                   | nacos cluster address                                        | eg. ip1:port1 ip2:port2 ip3:port3                            |
| PREFER_HOST_MODE                | 是否支持 hostname                                            | hostname/ip default **ip**                                   |
| NACOS_APPLICATION_PORT          | nacos server port                                            | default **8848**                                             |
| NACOS_SERVER_IP                 | 当有多网络的时候自定义nacos server ip                        |                                                              |
| SPRING_DATASOURCE_PLATFORM      | standalone support mysql                                     | mysql / empty default empty                                  |
| MYSQL_SERVICE_HOST              | mysql host                                                   |                                                              |
| MYSQL_SERVICE_PORT              | mysql database port                                          | default : **3306**                                           |
| MYSQL_SERVICE_DB_NAME           | mysql database name                                          |                                                              |
| MYSQL_SERVICE_USER              | username of database                                         |                                                              |
| MYSQL_SERVICE_PASSWORD          | password of database                                         |                                                              |
| MYSQL_SSL_ENABLE                | use ssl                                                      | default : false                                              |
| MYSQL_DATABASE_NUM              | 指定数据库的数量                                             | default :**1**                                               |
| JVM_XMS                         | -Xms                                                         | default :2g                                                  |
| JVM_XMX                         | -Xmx                                                         | default :2g                                                  |
| JVM_XMN                         | -Xmn                                                         | default :1g                                                  |
| JVM_MS                          | -XX:MetaspaceSize                                            | default :128m                                                |
| JVM_MMS                         | -XX:MaxMetaspaceSize                                         | default :320m                                                |
| NACOS_DEBUG                     | enable remote debug                                          | y/n default :n                                               |
| TOMCAT_ACCESSLOG_ENABLED        | server.tomcat.accesslog.enabled                              | default :false                                               |
| NACOS_AUTH_SYSTEM_TYPE          | 认证系统类型，目前仅支持`nacos`                              | default :nacos                                               |
| NACOS_AUTH_ENABLE               | 是否开启认证系统                                             | default :false                                               |
| NACOS_AUTH_TOKEN_EXPIRE_SECONDS | token 过期时间（以秒为单位）                                 | default :18000                                               |
| NACOS_AUTH_TOKEN                | 默认 token                                                   | default :SecretKey012345678901234567890123456789012345678901234567890123456789 |
| NACOS_AUTH_CACHE_ENABLE         | 打开/关闭身份验证信息的缓存。通过打开此开关，认证信息的更新将有15秒的延迟。 | default : false                                              |
| MEMBER_LIST                     | 使用配置文件或命令行参数设置集群列表                         | eg:192.168.16.101:8847?raft_port=8807,192.168.16.101?raft_port=8808,192.168.16.101:8849?raft_port=8809 |
| EMBEDDED_STORAGE                | 集群模式下没有mysql的时候使用 `embedded` 存储                        | `embedded` default : none                                    |

创建 `./conf/custom.properties` 文件，并添加以下内容：

```properties
#spring.security.enabled=false
#management.security=false
#security.basic.enabled=false
#nacos.security.ignore.urls=/**
#management.metrics.export.elastic.host=http://localhost:9200
# metrics for prometheus
#management.endpoints.web.exposure.include=*

# metrics for elastic search
#management.metrics.export.elastic.enabled=false
#management.metrics.export.elastic.host=http://localhost:9200

# metrics for influx
#management.metrics.export.influx.enabled=false
#management.metrics.export.influx.db=springboot
#management.metrics.export.influx.uri=http://localhost:8086
#management.metrics.export.influx.auto-create-db=true
#management.metrics.export.influx.consistency=one
#management.metrics.export.influx.compressed=true
```

`custom.properties` 这个文件一般可能没用，如果你需要上述的参数，可以去到注释并进行设置。

完成之后，使用下面的命令启动/关闭 `nacos-server`:

```shell
# 后台启动
docker-compose up -d

# 关闭
docker-compose down

# 查看日志, 也可以直接查看 logs 中的日志
docker logs nacos-server

# 进入 Nacos 容器
docker exec -it nacos-server bash
```

### 验证

注意开启端口的访问权限。

浏览器中打开链接: [http://localhost:8848/nacos](http://localhost:8848/nacos) 访问 Nacos 进行验证。

## 集群安装

集群的安装建立在单机安装的基础上，且 Windows 机器和 Linux 机器并没有什么不同，甚至一部分 Nacos 部署在 Windows 上，一部分部署在 Linux 都可以。

本节讨论的是如何部署一个生产可用的 Nacos 集群，并使用 MySQL 做数据持久化。

### Nacos 集群部署架构图

![nacos-cluster-example.jpg](https://i.loli.net/2020/09/29/6cdz3nxAgQoUEpv.jpg)

### 数据库准备

如果是生产环境的话，建议搭建一个高可用的数据库，用来存储 Nacos 的持久化数据。具体搭建步骤不在本章的讨论范畴，不再赘述。

按照之前单机安装的步骤，创建一个名为 `nacos` 的数据库，并导入 conf/nacos-mysql.sql 脚本生成必要的数据表和数据。

### 集群部署规划

集群部署，其实就是在不同的机器上，每个机器都部署一份 `nacos-server`，然后编辑 `./conf/cluster.conf`集群配置文件，把这些机器汇总进去。然后 nacos 会自动选举出 Leader 及 Follower，完成集群的搭建。

节点分配如下：

| 实例            | IP           | 端口 |
| --------------- | ------------ | ---- |
| nacos-server-01 | 192.168.9.11 | 8848 |
| nacos-server-02 | 192.168.9.12 | 8848 |
| nacos-server-03 | 192.168.9.13 | 8848 |

> 需要注意的是，如果是多台机器部署的话，需要保证这几台机器可以相互通信，且端口需要开启。

### 参数配置

首先需要准备一份 `nacos-server` 安装包，解压，然后编辑 `./conf/application.properties` ，配置内容与 **Windows 单机安装** - **参数配置** 小节中完全一样。其中数据库修改为上一步准备的数据库即可。

然后需要复制 `./conf/cluster.conf.example` 文件并重命名为 `cluster.conf` ，这个文件就是集群的配置文件了，以后如果需要修改集群节点信息，也是编辑这个文件，比如增减节点等。

编辑完成后的 `cluster.conf` 内容对应上面的节点分配，如下所示：

```properties
# 多台机器部署集群
# 各节点的 IP 与端口

192.168.9.11:8848
192.168.9.12:8848
192.168.9.13:8848
```

注意，如果你只是想在一台机器上模拟集群环境的话，那么此文件的配置仅需要修改下 IP 和端口即可。如下所示：

```properties
# 单台机器部署集群
# 各节点的 IP 与端口
# IP 相同，端口不同即可

192.168.9.10:8846
192.168.9.10:8847
192.168.9.10:8848
```

### 启动

编辑好之后，将 `nacos-server` 安装包，复制三份，分别上传到三台机器上。然后各自执行命令启动。

```shell
# 启动命令，因为 1.3.2 版本默认集群启动，所以可以直接运行。
sh startup.sh

# 如果要带参数运行也可以，只要是以集群模式启动即可。
sh startup.sh -m cluster 

# 关闭 nacos-server
sh shutdown.sh
```

### 验证

三台机器全部启动完成之后，随便访问哪一台机器上的 nacos 均可。

浏览器打开链接 [http://192.168.9.11:8848/nacos](http://192.168.9.11:8848/nacos) 访问 nacos。可以通过 **集群管理** - **节点列表** 来查看集群的情况。如下图所示：

![nacos-cluster-result.jpg](https://i.loli.net/2020/09/29/E9pKgDmwuCWb1li.jpg)

同时可以点击右侧的 **节点元数据** 查看节点的详细信息。节点元数据如下：

```json
{
    "adWeight": "0",
    "lastRefreshTime": 1601363785570,
    "naming": {
        "voteFor": "192.168.9.17:8846",
        "ip": "192.168.9.17:8846",
        "heartbeatDueMs": 4500,
        "term": 1,
        "leaderDueMs": 19701,
        "state": "LEADER"
    },
    "raftPort": "7846",
    "site": "unknow",
    "version": "1.3.2",
    "weight": "1"
}
```

`naming.state` 节点参数，指明了此节点为 Leader 节点，其他两个节点为 Follower。

### Nginx 反向代理与负载均衡

Nginx 的安装不在本章节的讨论范畴内，请自行查阅学习相关的信息。

打开 Nginx 的配置文件 `conf/nginx.conf` ，并在 `http{}` 节点下添加以下内容：

```properties
upstream nacos {
      server 192.168.9.11:8848;
      server 192.168.9.12:8848;
      server 192.168.9.13:8848;
}

server {
	  # 访问端口
      listen 80;
      # 自定义域名或者 IP
      # server_name nacos.com;
      server_name 192.168.9.10;

      location /nacos/ {
            proxy_pass http://nacos/nacos/;
      }
}
```

配置完成后，重新加载 Nginx 配置即可。

### 验证 Nginx

浏览器打开链接 [http://192.168.9.10/nacos](http://192.168.9.10/nacos) 访问 nacos。如果正常访问即通过验证。