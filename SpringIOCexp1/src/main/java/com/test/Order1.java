
package com.test;

public class Order1 {
    private int id;
    private String name;
    private int price;

    public Order1() {
        super();
    }

    public Order1(int id, String name, int price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    @Override
    public String toString() {
        return "Order1 [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}
