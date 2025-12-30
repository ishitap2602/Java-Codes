package com.test;

import java.util.Objects;
import java.util.TreeSet;

class Emp{
	private int id;
	private String name;
	private int salary;
	
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, name, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		return id == other.id && Objects.equals(name, other.name) && salary == other.salary;
	}
	public Emp(int id, String name, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
}
public class SetCustomGenerics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Emp> data = new TreeSet<>();
		data.add(new Emp(101, "Ishita", 4000));
		data.add(new Emp(102, "Jay", 100));
		data.add(new Emp(103, "Vidhan", 10));
		
		System.out.println(data.size());
		
		

	}

}
