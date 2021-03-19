# Spring Boot Kafka Web Socket Example Using Observer Pattern
> Spring Boot Kafka Web Socket Example
>
<img src="https://github.com/susimsek/spring-boot-kafka-websocket-example/blob/main/images/spring-boot-kafka-websocket-example.png" alt="Spring Boot Kafka Web Socket Example" width="100%" height="100%"/> 

## Prerequisites

* Java 11
* Maven 3.3+
* Docker 19.03+
* Docker Compose 1.25+

## Installation


```sh
./mvnw compile jib:dockerBuild
```


```sh
docker-compose up -d 
```

## Installation Using Vagrant

<img src="https://github.com/susimsek/spring-boot-kafka-websocket-example/blob/main/images/vagrant-installation.png" alt="Spring Boot Vagrant Installation" width="100%" height="100%"/> 

### Prerequisites

* Vagrant 2.2+
* Virtualbox or Hyperv

```sh
vagrant up
```

```sh
vagrant ssh
```

```sh
cd vagrant/setup
```

```sh
sudo chmod u+x *.sh
```

```sh
./install-prereqs.sh
```

```sh
exit
```

```sh
vagrant ssh
```

```sh
./mvnw compile jib:dockerBuild
```

```sh
docker-compose up -d
```

You can access the SpringDoc Openapi from the following url.

http://localhost:9090/api

You can access the Web client from the following url.

http://localhost:9090

You can access the Kafdrop from the following url.

http://localhost:9000

## Used Technologies

* Spring Boot 2.4.3
* Postgresql
* H2  
* Kafka
* Kafdrop  
* Spring Boot Websocket
* Spring Boot Web
* Spring Boot Security
* Spring Boot Jpa
* Spring Boot Thymeleaf
* Spring Cloud Stream
* Thymeleaf Spring Security5
* Content Negotiation Support(Xml,Json,Yaml Support)
* Spring Boot Log4j2
* Problem Spring Web
* Spring Boot Actuator
* SpringDoc Openapi Web Mvc Core
* SpringDoc Openapi Web Ui
* Maven Jib Plugin
* Maven Clean Plugin
* Maven Enforcer Plugin
* Maven Compiler Plugin
* Lombok
* Mapstruct  
* Dev Tools
* Spring Boot Test

## Web Client

> You can access the Web client from the following url.

http://localhost:9090

<img src="https://github.com/susimsek/spring-boot-kafka-websocket-example/blob/main/images/web-ui.png" alt="Spring Boot Bitcoin Web Ui" width="100%" height="100%"/>


## SpringDoc OpenApi

> You can access the SpringDoc Openapi from the following url.

http://localhost:9090/api

<img src="https://github.com/susimsek/spring-boot-kafka-websocket-example/blob/main/images/springdoc-openapi.png" alt="SpringDoc Openapi" width="100%" height="100%"/> 

By default, there are two user created with the following credentials:

- Username: user1
- Password: 123

- Username: user2
- Password: 123


