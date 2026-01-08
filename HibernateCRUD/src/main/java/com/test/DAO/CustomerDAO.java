
package com.test.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerDAO {

    public Integer save(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.persist(customer);
            tx.commit();
            return customer.getId();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Customer findById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.get(Customer.class, id);
        } finally {
            session.close();
        }
    }

    public void update(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.merge(customer); // use merge for detached entities
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
            Customer c = session.get(Customer.class, id);
            if (c != null) {
                session.remove(c); // cascades delete to orders (orphanRemoval)
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
    public void addOrder(Integer customerId, Order order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Customer c = session.get(Customer.class, customerId);
            if (c == null) throw new IllegalArgumentException("Customer not found: " + customerId);
            c.addOrder(order);
            // No explicit persist needed; dirty checking + cascade handles it
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void removeOrder(Integer customerId, Integer orderId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Customer c = session.get(Customer.class, customerId);
            if (c == null) throw new IllegalArgumentException("Customer not found: " + customerId);

            // Find the managed Order in the collection
            Order toRemove = null;
            for (Order o : c.getOrders()) {
                if (o.getId() != null && o.getId().equals(orderId)) {
                    toRemove = o;
                    break;
                }
            }
            if (toRemove == null) throw new IllegalArgumentException("Order not found: " + orderId);

            c.removeOrder(toRemove); // orphanRemoval will delete it
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
