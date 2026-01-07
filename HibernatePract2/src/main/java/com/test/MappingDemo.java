package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Chef chef = new Chef("Ishita Patel");
        session.persist(chef);

        Recipe recipe = new Recipe("Pasta");
        session.persist(recipe);

        chef.addRecipe(recipe);

        tx.commit();

        Chef fetchedChef = session.get(Chef.class, chef.getId());
        System.out.println("Chef: " + fetchedChef.getName());
        fetchedChef.getRecipes().forEach(r -> System.out.println("Recipe: " + r.getTitle()));

        session.close();
        sf.close();
        System.out.println("Done...");
    }
}
