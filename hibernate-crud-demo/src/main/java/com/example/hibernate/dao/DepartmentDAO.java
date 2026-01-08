
package com.example.hibernate.dao;

import com.example.hibernate.entity.Department;
import com.example.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DepartmentDAO {

    public Department create(Department dept) {
        Transaction tx = null;
        try (Session session = HibernateUtil.openSession()) {
            tx = session.beginTransaction();
            session.persist(dept);
            tx.commit();
            return dept;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public Department findById(Long id) {
        try (Session session = HibernateUtil.openSession()) {
            return session.get(Department.class, id);
        }
    }

    public List<Department> findAll() {
        try (Session session = HibernateUtil.openSession()) {
            return session.createQuery("from Department", Department.class).list();
        }
    }

    public Department update(Department dept) {
        Transaction tx = null;
        try (Session session = HibernateUtil.openSession()) {
            tx = session.beginTransaction();
            Department merged = (Department) session.merge(dept);
            tx.commit();
            return merged;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public void deleteById(Long id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.openSession()) {
            tx = session.beginTransaction();
            Department d = session.get(Department.class, id);
            if (d != null) {
                session.remove(d);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}

