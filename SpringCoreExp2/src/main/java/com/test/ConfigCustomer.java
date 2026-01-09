package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigCustomer {
	@Bean
	public Customer getSetterObj() {
		return new Customer();
	}
	
	@Bean
	public Customer getConstObj() {
		return new Customer(112, "Ayush", "Air Conditioner", 30000);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
