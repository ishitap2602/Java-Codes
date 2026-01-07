
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

public class UpdateEmployeeServlet extends HttpServlet {
    private final EmployeeDao dao = new EmployeeDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        int eid = parseInt(req.getParameter("eid"), -1);
        double salary = parseDouble(req.getParameter("salary"), -1);
        String ename = req.getParameter("ename");
        String location = req.getParameter("location");
        String designation = req.getParameter("designation");

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html><html><head><meta charset='UTF-8'><title>Update Employee</title></head><body>");
            out.println("<h2>Update Employee</h2>");

            if (eid <= 0 || isBlank(ename) || isBlank(designation) || salary < 0) {
                out.println("<p style='color:red;'>Invalid input. ID must be > 0, Name & Designation required, Salary ≥ 0.</p>");
                out.println("<p><a href='update.html'>Back</a></p>");
                out.println("<p><a href='index.html'>Home</a> | <a href='employees.html'>List All</a></p>");
                out.println("</body></html>");
                return;
            }

            Employee updated = new Employee(eid, ename, salary, location == null ? "" : location, designation);
            boolean ok = dao.updateEmployee(updated);

            if (ok) {
                out.println("<p>Update successful.</p>");
            } else {
                out.println("<p style='color:red;'>Update failed (ID may not exist).</p>");
            }

          
            out.println("<p><a href='index.html'>Home</a> | <a href='Employee.html'>List All</a></p>");
            out.println("</body></html>");
        }

        }
    

    private boolean isBlank(String s) { return s == null || s.trim().isEmpty(); }
    private int parseInt(String s, int fallback) {
        try { return Integer.parseInt(s); } catch (Exception e) { return fallback; }
    }
    private double parseDouble(String s, double fallback) {
        try { return Double.parseDouble(s); } catch (Exception e) { return fallback; }
    }
}
