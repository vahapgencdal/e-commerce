# E-Commerce Application Spring Cloud Config Server

## Settings
1. @EnableConfigServer
    Goto your application main class and addd **@EnableConfigServer** Annotation
2. goto Application.yml file and code below
    ```
    spring:
    application:
        name: ecommerce-spring-cloud-config-server
    cloud:
        config:
        server:
            git:
            uri: https://github.com/vahapgencdal/e-commerce-variables-repo.git
        
    server:
    port: ${port:8888}
    ```
    *  here we specify application name have to be same with folder name
    * then we give e-commerce-microservices config variables repository.
    * then we specify port for config server. port parameter can be taken from environment variables.

then you are going to just run.


## **Spring Cloud Config**
Spring Cloud Config is Spring's client/server approach for storing and serving distributed configurations across multiple applications and environments.

This configuration store is ideally versioned under Git version control and can be modified at application runtime. While it fits very well in Spring applications using all the supported configuration file formats together with constructs like Environment, PropertySource or @Value, it can be used in any environment running any programming language.

In this write-up, we'll focus on an example of how to setup a Git-backed config server, use it in a simple REST application server and setup a secure environment including encrypted property values.