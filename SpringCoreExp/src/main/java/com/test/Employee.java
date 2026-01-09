package com.test;

public class Employee {
	private int id;
	private String name;
	private String cmp;
	private int salary;
	public Employee() {
		
	}
	public Employee(int id, String name, String cmp, int salary) {
		this.id=id;
		this.name=name;
		this.cmp=cmp;
		this.salary=salary;

		
				
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", cmp=" + cmp + ", salary=" + salary + "]";
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
	public String getCmp() {
		return cmp;
	}
	public void setCmp(String cmp) {
		this.cmp = cmp;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
		public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
