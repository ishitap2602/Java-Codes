package com.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
	@GetMapping("/test")
	public String studentAPI() {
		return "This is a simple cloud service1 / one proj";
	}
	
	
	
	
	
	
	
}
