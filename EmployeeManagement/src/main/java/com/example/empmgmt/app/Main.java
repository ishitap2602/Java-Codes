
package com.example.empmgmt.app;

import com.example.empmgmt.dao.EmployeeDao;
import com.example.empmgmt.dao.EmployeeDaoImpl;
import com.example.empmgmt.entity.Employee;

import java.util.List;
import java.util.Scanner;

/**
 * Menu:
 * 1) Add
 * 2) Update (enter all fields)
 * 3) Delete (returns updated list)
 * 4) List All
 * 5) Exit
 */
public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final EmployeeDao dao = new EmployeeDaoImpl();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = readInt("Enter choice (1-5): ");

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();   // no getById; you enter full details
                    break;
                case 3:
                    deleteEmployee();   // returns updated list
                    break;
                case 4:
                    listAllEmployees();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-5.");
                    break;
            }
            System.out.println();
        }
        sc.close();
    }

    private static void printMenu() {
        System.out.println("\n=== Employee Management ===");
        System.out.println("1) Add Employee");
        System.out.println("2) Update Employee (enter all fields)");
        System.out.println("3) Delete Employee (shows updated list)");
        System.out.println("4) List All Employees");
        System.out.println("5) Exit");
    }

    // --- Case 1: Add ---
    private static void addEmployee() {
        System.out.println("[Add Employee]");
        String name = readNonEmptyString("Name: ");
        double salary = readDouble("Salary (>= 0): ", true);
        String location = readString("Location (optional): ");
        String designation = readNonEmptyString("Designation: ");

        Employee emp = new Employee(0, name, salary, location, designation);
        boolean ok = dao.addEmployee(emp);
        System.out.println(ok ? ("Added. New ID: " + emp.getEid()) : "Add failed.");
    }

    // --- Case 2: Update (no getById; user enters all fields) ---
    private static void updateEmployee() {
        System.out.println("[Update Employee]");
        int id = readInt("Employee ID to update: ");
        String name = readNonEmptyString("New Name: ");
        double salary = readDouble("New Salary (>= 0): ", true);
        String location = readString("New Location (optional): ");
        String designation = readNonEmptyString("New Designation: ");

        Employee updated = new Employee(id, name, salary, location, designation);
        boolean ok = dao.updateEmployee(updated);
        System.out.println(ok ? "Update successful." : "Update failed (id may not exist).");
    }

    // --- Case 3: Delete (returns updated list) ---
    private static void deleteEmployee() {
        System.out.println("[Delete Employee]");
        int id = readInt("Employee ID to delete: ");
        List<Employee> updated = dao.deleteEmployee(id);
        System.out.println("Updated employees (" + updated.size() + "):");
        printEmployees(updated);
    }

    // --- Case 4: List all ---
    private static void listAllEmployees() {
        System.out.println("[List All Employees]");
        List<Employee> list = dao.getAllEmployees();
        if (list.isEmpty()) System.out.println("No employees found.");
        else printEmployees(list);
    }

    // --- Input helpers ---
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid integer.");
            }
        }
    }

    private static double readDouble(String prompt, boolean nonNegative) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                double v = Double.parseDouble(line);
                if (nonNegative && v < 0) {
                    System.out.println("Value must be >= 0.");
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number.");
            }
        }
    }

    private static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Value cannot be empty.");
        }
    }

    private static String readString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    private static void printEmployees(List<Employee> employees) {
        for (Employee e : employees) {
            System.out.println(
                "ID=" + e.getEid() +
                ", Name=" + e.getEname() +
                ", Salary=" + e.getSalary() +
                ", Location=" + e.getLocation() +
                ", Designation=" + e.getDesignation()
            );
        }
    }
}

