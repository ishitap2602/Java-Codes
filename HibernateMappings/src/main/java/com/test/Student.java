package com.test;
 
import org.hibernate.mapping.List;
 
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
private int id;
public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	public String getStd_name() {
		return std_name;
	}
 
	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}
 
	public java.util.List<Address> getAddresses() {
		return addresses;
	}
 
	public void setAddresses(java.util.List<Address> addresses) {
		this.addresses = addresses;
	}
 
private String std_name;
@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="std_id")
private java.util.List<Address> addresses;
}
 
 