package com.test;

public class Employee {
	private int id;
	private String e_name;
	private String e_cmp;
	private String e_city;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getE_cmp() {
		return e_cmp;
	}
	public void setE_cmp(String e_cmp) {
		this.e_cmp = e_cmp;
	}
	public String getE_city() {
		return e_city;
	}
	public void setE_city(String e_city) {
		this.e_city = e_city;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", e_name=" + e_name + ", e_cmp=" + e_cmp + ", e_city=" + e_city + "]";
	}
	
	public Employee() {
		super();
	}
	
	public Employee(int id, String e_name, String e_cmp, String e_city) {
		super();
		this.id = id;
		this.e_name = e_name;
		this.e_cmp = e_cmp;
		this.e_city = e_city;
	}
	
	
	
}
