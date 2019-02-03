package com.spring.microservices.eurekaserver.springdiscoveryeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringDiscoveryEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDiscoveryEurekaServerApplication.class, args);
	}

}

