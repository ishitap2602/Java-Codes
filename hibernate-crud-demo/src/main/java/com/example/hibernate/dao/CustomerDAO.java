
package com.example.hibernate.dao;

import com.example.hibernate.entity.Customer;
import com.example.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerDAO {

    public Customer create(Customer customer) {
        Transaction tx = null;
        try (Session session = HibernateUtil.openSession()) {
            tx = session.beginTransaction();
            session.persist(customer);
            tx.commit();
            return customer;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public Customer findById(Long id) {
        try (Session session = HibernateUtil.openSession()) {
            return session.get(Customer.class, id);
        }
    }

    public List<Customer> findAll() {
        try (Session session = HibernateUtil.openSession()) {
            return session.createQuery("from Customer", Customer.class).list();
        }
    }

    public Customer update(Customer customer) {
        Transaction tx = null;
        try (Session session = HibernateUtil.openSession()) {
            tx = session.beginTransaction();
            Customer merged = (Customer) session.merge(customer);
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
            Customer c = session.get(Customer.class, id);
            if (c != null) {
                session.remove(c);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}

