package com.test;

import java.util.List;

public class Student {
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", college=" + college + ", skills=" + skills + "]";
	}
	private int id;
	private String name;
	private String college;
	private List<String> skills;
	public Student(int id, String name, String college, List<String> skills) {
		super();
		this.id = id;
		this.name = name;
		this.college = college;
		this.skills = skills;
	}
	public Student() {
		super();
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
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
}
