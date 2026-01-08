
package com.example.hibernate.dao;

import com.example.hibernate.entity.Order;
import com.example.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrderDAO {

    public Order create(Order order) {
        Transaction tx = null;
        try (Session session = HibernateUtil.openSession()) {
            tx = session.beginTransaction();
            session.persist(order);
            tx.commit();
            return order;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public Order findById(Long id) {
        try (Session session = HibernateUtil.openSession()) {
            return session.get(Order.class, id);
        }
    }

    public List<Order> findAll() {
        try (Session session = HibernateUtil.openSession()) {
            return session.createQuery("from Order", Order.class).list();
        }
    }

    public Order update(Order order) {
        Transaction tx = null;
        try (Session session = HibernateUtil.openSession()) {
            tx = session.beginTransaction();
            Order merged = (Order) session.merge(order);
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
            Order o = session.get(Order.class, id);
            if (o != null) {
                session.remove(o);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}

