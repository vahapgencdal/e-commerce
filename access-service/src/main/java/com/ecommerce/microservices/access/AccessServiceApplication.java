package com.ecommerce.microservices.access;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class AccessServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessServiceApplication.class, args);
	}

}
