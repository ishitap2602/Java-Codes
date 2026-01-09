
package com.test;

import java.util.List;

public class Customer {
    private int id;
    private String name;

    // Add these to match beans.xml
    private List<Order1> orders;
    private List<Address> addr;

    public Customer() {
        super();
    }

    public Customer(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    // id
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    // name
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // orders
    public List<Order1> getOrders() { return orders; }
    public void setOrders(List<Order1> orders) { this.orders = orders; }

    // addr
    public List<Address> getAddr() { return addr; }
    public void setAddr(List<Address> addr) { this.addr = addr; }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orders=" + orders +
                ", addr=" + addr +
                '}';
    }
}
