package com.test;

public class Company {
	
	private int id;
	private String name;
	
	private int noOfDepartment;

	
	public Company() {
	}


	public Company(int id, String name, int noOfDepartment) {
		this.id = id;
		this.name = name;
		this.noOfDepartment = noOfDepartment;
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


	public int getNoOfDepartment() {
		return noOfDepartment;
	}


	public void setNoOfDepartment(int noOfDepartment) {
		this.noOfDepartment = noOfDepartment;
	}


	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", noOfDepartment=" + noOfDepartment + "]";
	}
	
	
}
