
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

public class DeleteEmployeeServlet extends HttpServlet {
    private final EmployeeDao dao = new EmployeeDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        int eid = parseInt(req.getParameter("eid"), -1);

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html><html><head><meta charset='UTF-8'><title>Delete Employee</title></head><body>");
            out.println("<h2>Delete Employee</h2>");

            if (eid <= 0) {
                out.println("<p style='color:red;'>Invalid ID.</p>");
                out.println("<p><a href='delete.html'>Back</a></p>");
                out.println("</body></html>");
                return;
            }

            List<Employee> updated = dao.deleteEmployee(eid);
            out.printf("<p>Deleted ID: <strong>%d</strong> (if it existed).</p>%n", eid);

            renderTable(out, updated);

            out.println("<p>");
            out.println("<a href='index.html'>Home</a> | ");
            out.println("<a href='employees.html'>View All</a>");
            out.println("</p>");
        }
    }

    private void renderTable(PrintWriter out, List<Employee> list) {
        out.println("<h3>Updated Employees:</h3>");
        if (list == null || list.isEmpty()) {
            out.println("<p>No employees found.</p>");
            return;
        }
        out.println("<table border='1' cellpadding='6'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Salary</th><th>Location</th><th>Designation</th></tr>");
        for (Employee e : list) {
            out.printf("<tr><td>%d</td><td>%s</td><td>%.2f</td><td>%s</td><td>%s</td></tr>%n",
                    e.getEid(), html(e.getEname()), e.getSalary(), html(e.getLocation()), html(e.getDesignation()));
        }
        out.println("</table>");
    }

    private int parseInt(String s, int fallback) {
        try { return Integer.parseInt(s); } catch (Exception e) { return fallback; }
    }

    private String html(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
                .replace("\"", "&quot;").replace("'", "&#39;");
    }
}

