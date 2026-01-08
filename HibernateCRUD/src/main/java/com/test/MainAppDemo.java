
package com.test;

public class MainAppDemo {
    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        DepartmentDAO departmentDAO = new DepartmentDAO();

        // ===== Customer + Orders =====
        Customer cust = new Customer();
        cust.setName("Alice");
        cust.setEmail("alice@example.com");
        cust.addOrder(new Order(){{
            setProduct("Laptop");
            setAmount(1200.0);
        }});
        cust.addOrder(new Order(){{
            setProduct("Mouse");
            setAmount(25.0);
        }});

        Integer custId = customerDAO.save(cust);
        System.out.println("Saved Customer ID: " + custId);

        // Read
        Customer foundCust = customerDAO.findById(custId);
        System.out.println("Loaded Customer: " + foundCust);

        // Update: add a new order
        customerDAO.addOrder(custId, new Order(){{
            setProduct("Keyboard");
            setAmount(45.0);
        }});

        // Remove one order (pick an existing order id)
        Integer orderIdToRemove = foundCust.getOrders().get(0).getId(); // first order
        customerDAO.removeOrder(custId, orderIdToRemove);
        System.out.println("Removed Order ID: " + orderIdToRemove);

        // ===== Department + Employees =====
        Department dept = new Department();
        dept.setDeptName("Engineering");
        dept.addEmployee(new Employee(){{
            setName("Bob");
            setSalary(90000.0);
        }});
        dept.addEmployee(new Employee(){{
            setName("Carol");
            setSalary(95000.0);
        }});

        Integer deptId = departmentDAO.save(dept);
        System.out.println("Saved Department ID: " + deptId);

        Department foundDept = departmentDAO.findById(deptId);
        System.out.println("Loaded Department: " + foundDept);

        // Add employee
        departmentDAO.addEmployee(deptId, new Employee(){{
            setName("Dave");
            setSalary(88000.0);
        }});

        // Remove employee
        Integer empIdToRemove = foundDept.getEmployees().get(0).getId();
        departmentDAO.removeEmployee(deptId, empIdToRemove);
        System.out.println("Removed Employee ID: " + empIdToRemove);

        // Cleanup (optional deletes)
        // customerDAO.delete(custId);
        // departmentDAO.delete(deptId);

        HibernateUtil.shutdown();
    }
}
