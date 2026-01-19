package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@GetMapping("/")
	public ModelAndView userPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("userpage");
		return model;
	}
	
	@GetMapping("/")
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("adminpage");
		return model;
	}
	
	public ModelAndView loginPage(
			@RequestParam(value = "error", required = false)String error, 
			@RequestParam(value = "logout", required = false)String logout) {
		ModelAndView model=new ModelAndView();
		if(error !=null) {
			model.addObject("error", "Invalid credentials provided");
		}
		if(logout != null) {
			model.addObject("message", "logged out from application successfully");
		}
		model.setViewName("loginpage");
		return model;
	}
	
	
}
