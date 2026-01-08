
package com.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration cfg = new Configuration().configure();
            cfg.addAnnotatedClass(Customer.class);
            cfg.addAnnotatedClass(Order.class);
            cfg.addAnnotatedClass(Department.class);
            cfg.addAnnotatedClass(Employee.class);
            sessionFactory = cfg.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
