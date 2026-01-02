
package com.example.empmgmt.dao;

import com.example.empmgmt.entity.Employee;
import com.example.empmgmt.utility.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private final Connection sharedCon; // null in prod; non-null in tests (transaction)

    private static final String INSERT_SQL =
            "INSERT INTO employees (ename, salary, location, designation) VALUES (?,?,?,?)";
    private static final String UPDATE_SQL =
            "UPDATE employees SET ename=?, salary=?, location=?, designation=? WHERE eid=?";
    private static final String DELETE_SQL =
            "DELETE FROM employees WHERE eid=?";
    private static final String SELECT_ALL_SQL =
            "SELECT eid, ename, salary, location, designation FROM employees ORDER BY eid";

    // Default constructor: production use (creates its own connections)
    public EmployeeDaoImpl() {
        this.sharedCon = null;
    }

    // Test constructor: inject a shared Connection (transactional)
    public EmployeeDaoImpl(Connection sharedCon) {
        this.sharedCon = sharedCon;
    }

    private Connection getConnection() throws SQLException {
        return (sharedCon != null) ? sharedCon : DbUtil.getConnection();
    }

    @Override
    public Boolean addEmployee(Employee emp) {
        if (emp == null) return false;
        try (PreparedStatement ps = getConnection().prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, emp.getEname());
            ps.setDouble(2, emp.getSalary());
            ps.setString(3, emp.getLocation());
            ps.setString(4, emp.getDesignation());

            int affected = ps.executeUpdate();
            if (affected == 0) return false;

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) emp.setEid(keys.getInt(1));
            }
            return true;

        } catch (SQLException e) {
            System.err.println("addEmployee failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean updateEmployee(Employee emp) {
        if (emp == null || emp.getEid() <= 0) return false;
        try (PreparedStatement ps = getConnection().prepareStatement(UPDATE_SQL)) {
            ps.setString(1, emp.getEname());
            ps.setDouble(2, emp.getSalary());
            ps.setString(3, emp.getLocation());
            ps.setString(4, emp.getDesignation());
            ps.setInt(5, emp.getEid());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("updateEmployee failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        try (PreparedStatement ps = getConnection().prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("eid"),
                        rs.getString("ename"),
                        rs.getDouble("salary"),
                        rs.getString("location"),
                        rs.getString("designation")
                ));
            }
        } catch (SQLException e) {
            System.err.println("getAllEmployees failed: " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<Employee> deleteEmployee(int id) {
        List<Employee> list = new ArrayList<>();
        try (PreparedStatement psDelete = getConnection().prepareStatement(DELETE_SQL)) {
            psDelete.setInt(1, id);
            psDelete.executeUpdate();
        } catch (SQLException e) {
            System.err.println("deleteEmployee failed: " + e.getMessage());
        }

        try (PreparedStatement psSelect = getConnection().prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = psSelect.executeQuery()) {
            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("eid"),
                        rs.getString("ename"),
                        rs.getDouble("salary"),
                        rs.getString("location"),
                        rs.getString("designation")
                ));
            }
        } catch (SQLException e) {
            System.err.println("getAllEmployees (after delete) failed: " + e.getMessage());
        }
        return list;
    }
}
