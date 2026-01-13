package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.model.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	@GetMapping("/ulogin")
	public String userLoginPage() {
		return "login";
		
	}
//	@PostMapping("/submit")
//	public String submitUserForm(HttpServletRequest request) {
//		String usr = request.getParameter("user");
//		String pas = request.getParameter("pwd");
//		if(usr.equals("admin") && pas.equals("a123")) {
//			return "success";
//
//		}
//		else {
//			return "login";
//		}
//	}
	
	@PostMapping("/submit")
	public ModelAndView submitUserForm(@RequestParam("user") String usr, @RequestParam("pwd") String pas, Model model, @ModelAttribute("info") User usr1) {
		User obj = new User();
		
		obj.setUserName(usr);
		obj.setPassword(pas);
		model.addAttribute("info", obj);
		
		ModelAndView mv = new ModelAndView("login");
		if(usr.equals("admin") && pas.equals("a123")) {

		mv.setViewName("success");
		mv.addObject("info", obj);
			return mv;

		}
		else {
			return mv;
		}		
	}
	
	
}
