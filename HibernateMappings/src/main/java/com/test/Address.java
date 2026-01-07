package com.test;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="addr")

public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String city;
	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}
	private String state;
	private String country;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
