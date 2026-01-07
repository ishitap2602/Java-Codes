package com.test;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @ManyToMany(mappedBy = "recipes")
    private Set<Chef> chefs = new HashSet<>();

    public Recipe() {}
    public Recipe(String title) { 
    	this.title = title; 
    	}

    public int getId() { 
    	return id; 
    	}
    public String getTitle() { 
    	return title; 
    	}
    public Set<Chef> getChefs() { 
    	return chefs; 
    	}
}
