
package com.test;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity orphanRemoval = true)
    @JoinColumn(name = "d_id") // FK in employees table
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee emp) { employees.add(emp); }

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    }
}
