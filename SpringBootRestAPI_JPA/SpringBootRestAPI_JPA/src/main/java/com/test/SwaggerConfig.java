package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    private final SpringBootRestApiJpaApplication springBootRestApiApplication;

    SwaggerConfig(SpringBootRestApiJpaApplication springBootRestApiApplication) {
        this.springBootRestApiApplication = springBootRestApiApplication;
    }
@Bean
public  OpenAPI apiInfo() {
	
	return new OpenAPI()
			.info(new Info()
			         .title("Swagger Testing")
			         .description("Employee Crud Operation")
			         .version("1.0.0"));
}
}
