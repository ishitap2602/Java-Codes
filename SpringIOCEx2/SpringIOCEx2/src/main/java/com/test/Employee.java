package com.test;

public class Employee {
	
	private int id;
	private String name;
	
	private Department dept;
	private Company cmp;
	
	
	public Employee() {
	}
	public Employee(int id, String name, Department dept, Company cmp) {
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.cmp = cmp;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dept=" + dept + ", cmp=" + cmp + "]";
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
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public Company getCmp() {
		return cmp;
	}
	public void setCmp(Company cmp) {
		this.cmp = cmp;
	}
	
	

}
