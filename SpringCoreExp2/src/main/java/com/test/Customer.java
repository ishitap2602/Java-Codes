package com.test;

public class Customer {
	private int id;
	private String name;
	private String order;
	private int orderPrice;
	
	public Customer() {
		super();
	}
	public Customer(int id, String name, String order, int orderPrice) {
		super();
		this.id = id;
		this.name = name;
		this.order = order;
		this.orderPrice = orderPrice;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", order=" + order + ", orderPrice=" + orderPrice + "]";
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
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
