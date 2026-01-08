
package com.test;

import jakarta.persistence.*;

@Entity
@Table
public class Order {
    @Id
    @Column(name = "o_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "o_name")
    private String name;

    @Column(name = "o_price")
    private Double price;

    // Getters & Setters
    public Integer getId() { return id; }
    Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}
