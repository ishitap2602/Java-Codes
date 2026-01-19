package com.test.entity;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionID = 1L;
	private int id;
	private String name;
	private String college;
	
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", college=" + college + "]";
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
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public Student(int id, String name, String college) {
		super();
		this.id = id;
		this.name = name;
		this.college = college;
	}
	
	
}
