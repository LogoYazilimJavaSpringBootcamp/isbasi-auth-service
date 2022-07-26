package com.isbasi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class IsbasiAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsbasiAuthServiceApplication.class, args);
	}

}
