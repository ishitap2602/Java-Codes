package com.test;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudGatewayConfig {
	@Bean
	protected RouteLocator getRouteConfig(RouteLocatorBuilder builder)
	{
    	return builder.routes()
    			.route(r->r.path("/student/*")
    					.uri("http://localhost:7373/"))
    			.route(r->r.path("/employee/*")
    					.uri("http://localhost:9393/"))
    			.build();
}
}
 
	

