
package com.test.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DepartmentDAO {

    public Integer save(Department department) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.persist(department);
            tx.commit();
            return department.getId();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Department findById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.get(Department.class, id);
        } finally {
            session.close();
        }
    }

    public void update(Department department) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.merge(department);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void delete(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Department d = session.get(Department.class, id);
            if (d != null) {
                session.remove(d); // cascades delete to employees
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    // Child operations through parent
    public void addEmployee(Integer deptId, Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Department d = session.get(Department.class, deptId);
            if (d == null) throw new IllegalArgumentException("Department not found: " + deptId);
            d.addEmployee(employee);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void removeEmployee(Integer deptId, Integer employeeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Department d = session.get(Department.class, deptId);
            if (d == null) throw new IllegalArgumentException("Department not found: " + deptId);

            Employee toRemove = null;
            for (Employee e : d.getEmployees()) {
                if (e.getId() != null && e.getId().equals(employeeId)) {
                    toRemove = e;
                    break;
                }
            }
            if (toRemove == null) throw new IllegalArgumentException("Employee not found: " + employeeId);

            d.removeEmployee(toRemove);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
