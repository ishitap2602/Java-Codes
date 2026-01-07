
package com.example.empmgmt.entity;

public class Employee {
    private int eid;
    private String ename;
    private double salary;
    private String location;
    private String designation;

    // Constructors
    public Employee() {
    }

    public Employee(int eid, String ename, double salary, String location, String designation) {
        this.eid = eid;
        this.ename = ename;
        this.salary = salary;
        this.location = location;
        this.designation = designation;
    }

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", location=" + location
				+ ", designation=" + designation + "]";
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
}


