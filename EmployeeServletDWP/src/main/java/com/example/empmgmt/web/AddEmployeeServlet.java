
package com.example.empmgmt.web;

import com.example.empmgmt.dao.EmployeeDao;
import com.example.empmgmt.dao.EmployeeDaoImpl;
import com.example.empmgmt.entity.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class AddEmployeeServlet extends HttpServlet {
    private final EmployeeDao dao = new EmployeeDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String ename = req.getParameter("ename");
        String location = req.getParameter("location");
        String designation = req.getParameter("designation");
        double salary = parseDouble(req.getParameter("salary"), -1);

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html><html><head><meta charset='UTF-8'><title>Add Employee</title></head><body>");
            out.println("<h2>Add Employee</h2>");
            if (isBlank(ename) || isBlank(designation) || salary < 0) {
                out.println("<p style='color:red;'>Invalid input. Name, Designation and non-negative Salary are required.</p>");
                out.println("<p><a href='add.html'>Back</a></p>");
                out.println("</body></html>");
                return;
            }

            Employee emp = new Employee(0, ename, salary, location == null ? "" : location, designation);
            boolean ok = dao.addEmployee(emp);

            if (ok) {
                out.printf("<p>Added successfully. New ID: <strong>%d</strong></p>%n", emp.getEid());
            } else {
                out.println("<p style='color:red;'>Add failed.</p>");
            }

          
            out.println("<p><a href='index.html'>Home</a> | <a href='Employee.html'>List All</a></p>");
            out.println("</body></html>");
            

        }
    }

    private boolean isBlank(String s) { return s == null || s.trim().isEmpty(); }
    private double parseDouble(String s, double fallback) {
        try { return Double.parseDouble(s); } catch (Exception e) { return fallback; }
    }
}

