
package com.test;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "chefs")
public class Chef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany
    @JoinTable(
        name = "chef_recipe",
        joinColumns = @JoinColumn(name = "chef_id"),
        inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private Set<Recipe> recipes = new HashSet<>();

    public Chef() {}
    public Chef(String name) { 
    	this.name = name; 
    	}

    public int getId() { 
    	return id; 
    	}
    public String getName() { 
    	return name; 
    	}
    public Set<Recipe> getRecipes() { 
    	return recipes; 
    	}

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
        recipe.getChefs().add(this);
    }
}
