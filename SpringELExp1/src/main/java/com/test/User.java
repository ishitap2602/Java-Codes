package com.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("user")

public class User {
	
	@Value("${user.id}")	
	private Integer id;
	
	@Value("${user.name}")	
	private String userName;
	
	@Value("${user.pass}")	
	private String password;
	
	@Value("${user.email}")	
	private String email;
	
	@Value("${user.message}")
	private String greetUser;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGreetUser() {
		return greetUser;
	}
	public void setGreetUser(String greetUser) {
		this.greetUser = greetUser;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", greetUser=" + greetUser + "]";
	}
	
}
