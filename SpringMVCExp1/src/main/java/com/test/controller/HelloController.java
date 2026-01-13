package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/hello")
public class HelloController {
	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public String homePage() {
		return "home";
		
	}
	@GetMapping("/user1")
	public String greetUser1(@RequestParam("name") String name, Model model){   
		model.addAttribute("info",name);
		return "greet";
	}
	 
	
}
