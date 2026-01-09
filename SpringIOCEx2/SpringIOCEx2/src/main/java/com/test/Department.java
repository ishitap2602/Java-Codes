package com.test;

public class Department {
	
	private int id;
	
	private String name;
	
	private int noOfEmployees;
	
	public Department() {
	}

	public Department(int id, String name, int noOfEmployees) {
		this.id = id;
		this.name = name;
		this.noOfEmployees = noOfEmployees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfEmployees() {
		return noOfEmployees;
	}

	public void setNoOfEmployees(int noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", noOfEmployees=" + noOfEmployees + "]";
	}
	
	

}
