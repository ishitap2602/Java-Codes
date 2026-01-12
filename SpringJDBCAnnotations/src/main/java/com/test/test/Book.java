package com.test.test;

public class Book {
	private int id;
	private String b_name;
	private int b_price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public int getB_price() {
		return b_price;
	}
	public void setB_price(int b_price) {
		this.b_price = b_price;
	}
	
	public Book() {
		super();
	}
	
	public Book(int id, String b_name, int b_price) {
		super();
		this.id = id;
		this.b_name = b_name;
		this.b_price = b_price;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", b_name=" + b_name + ", b_price=" + b_price + "]";
	}
	
	
	
}
