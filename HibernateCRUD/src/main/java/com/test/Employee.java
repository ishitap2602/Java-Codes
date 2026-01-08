
package com.test;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "eid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ename")
    private String name;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "location")
    designation;

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    designation; }
    public void setDesignation(String designation) { this.designation = designation; }
}

