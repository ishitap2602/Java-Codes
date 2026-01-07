
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
import java.util.List;

public class ListEmployeesServlet extends HttpServlet {
    private final EmployeeDao dao = new EmployeeDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        List<Employee> list = dao.getAllEmployees();

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html><html><head><meta charset='UTF-8'><title>All Employees</title></head><body>");
            out.println("<h2>All Employees</h2>");

            if (list == null || list.isEmpty()) {
                out.println("<p>No employees found.</p>");
            } else {
                out.println("<table border='1' cellpadding='6'>");
                out.println("<tr><th>ID</th><th>Name</th><th>Salary</th><th>Location</th><th>Designation</th></tr>");
                for (Employee e : list) {
                    out.printf("<tr><td>%d</td><td>%s</td><td>%.2f</td><td>%s</td><td>%s</td></tr>%n",
                            e.getEid(), html(e.getEname()), e.getSalary(), html(e.getLocation()), html(e.getDesignation()));
                }
                out.println("</table>");
            }

            out.println("<p><a href='index.html'>Home</a></p>");

            out.println("</body></html>");
        }
    }

    private String html(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
                .replace("\"", "&quot;").replace("'", "&#39;");
    }
}
