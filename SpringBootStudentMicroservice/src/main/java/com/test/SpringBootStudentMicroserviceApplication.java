package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootStudentMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStudentMicroserviceApplication.class, args);
	}

}
