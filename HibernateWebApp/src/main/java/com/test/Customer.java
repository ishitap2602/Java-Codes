package com.test;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
@Entity
@Table(name="customer1")
public class Customer {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String location;
	
	public Customer() {
		
	}
	
	public Customer(int id) {
		this.id = id;
	}
	
	public static Customer fetchCustomerById(int id) {
		Customer ct = CustomerDAO.getCustomerById(id);
		return ct;
	}
 
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	public String getFirstName() {
		return firstName;
	}
 
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
 
	public String getLastName() {
		return lastName;
	}
 
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
 
	public String getLocation() {
		return location;
	}
 
	public void setLocation(String location) {
		this.location = location;
	}
 
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", location=" + location
				+ "]";
	}
	
	
}
 
 