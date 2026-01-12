package com.test.model;

public class Customer {
	
	private int id;
	private String c_first_name;
	private String c_last_name;
	private String c_location;
	@Override
	public String toString() {
		return "Customer [id=" + id + ", c_first_name=" + c_first_name + ", c_last_name=" + c_last_name
				+ ", c_location=" + c_location + "]";
	}
	public Customer(int id, String c_first_name, String c_last_name, String c_location) {
		super();
		this.id = id;
		this.c_first_name = c_first_name;
		this.c_last_name = c_last_name;
		this.c_location = c_location;
	}
	public Customer() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getC_first_name() {
		return c_first_name;
	}
	public void setC_first_name(String c_first_name) {
		this.c_first_name = c_first_name;
	}
	public String getC_last_name() {
		return c_last_name;
	}
	public void setC_last_name(String c_last_name) {
		this.c_last_name = c_last_name;
	}
	public String getC_location() {
		return c_location;
	}
	public void setC_location(String c_location) {
		this.c_location = c_location;
	}
	
	
	
	
	
}
