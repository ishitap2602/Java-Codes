
package com.example.hibernate;

import com.example.hibernate.dao.*;
import com.example.hibernate.entity.*;
import com.example.hibernate.entity.Order.Status;
import com.example.hibernate.util.HibernateUtil;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        OrderDAO orderDAO = new OrderDAO();
        DepartmentDAO departmentDAO = new DepartmentDAO();
        EmployeeDAO employeeDAO = new EmployeeDAO();

        try {
            // --- Create Department and Employees ---
            Department engineering = new Department();
            engineering.setName("Engineering");
            departmentDAO.create(engineering);

            Employee alice = new Employee();
            alice.setFirstName("Alice");
            alice.setLastName("Johnson");
            alice.setEmail("alice@example.com");
            alice.setDepartment(engineering);
            employeeDAO.create(alice);

            Employee bob = new Employee();
            bob.setFirstName("Bob");
            bob.setLastName("Singh");
            bob.setEmail("bob@example.com");
            bob.setDepartment(engineering);
            employeeDAO.create(bob);

            // --- Create Customer and Orders ---
            Customer cust = new Customer();
            cust.setName("Acme Corp");
            cust.setEmail("contact@acme.com");

            // Persist Customer first
            customerDAO.create(cust);

            Order o1 = new Order();
            o1.setTotal(new BigDecimal("1999.99"));
            o1.setStatus(Status.PAID);
            o1.setCustomer(cust);
            orderDAO.create(o1);

            Order o2 = new Order();
            o2.setTotal(new BigDecimal("349.50"));
            o2.setStatus(Status.PENDING);
            o2.setCustomer(cust);
            orderDAO.create(o2);

            // Optionally, maintain bidirectional consistency
            // cust.addOrder(o1);
            // cust.addOrder(o2);
            // customerDAO.update(cust);

            // --- Read operations ---
            Customer dbCustomer = customerDAO.findById(cust.getId());
            System.out.println("Loaded Customer: " + dbCustomer);

            List<Customer> allCustomers = customerDAO.findAll();
            System.out.println("All Customers: " + allCustomers);

            List<Order> allOrders = orderDAO.findAll();
            System.out.println("All Orders: " + allOrders);

            List<Employee> allEmployees = employeeDAO.findAll();
            System.out.println("All Employees: " + allEmployees);

            List<Department> allDepartments = departmentDAO.findAll();
            System.out.println("All Departments: " + allDepartments);

            // --- Update operations ---
            dbCustomer.setName("Acme Corp International");
            customerDAO.update(dbCustomer);

            o2.setStatus(Status.CANCELLED);
            orderDAO.update(o2);

            alice.setLastName("Gupta");
            employeeDAO.update(alice);

            engineering.setName("Engineering & R&D");
            departmentDAO.update(engineering);

            // --- Delete operations ---
            orderDAO.deleteById(o1.getId());       // delete an order
            employeeDAO.deleteById(bob.getId());   // delete an employee

            // Optionally delete customer (will remove orders due to orphanRemoval if using convenience methods)
            // customerDAO.deleteById(cust.getId());

        } finally {
            HibernateUtil.shutdown();
        }
    }
}
