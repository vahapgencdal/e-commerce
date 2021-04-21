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