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
        SpiceFarm everest = new SpiceFarm("Everest Organic", "Maharashtra", "Organic");
        SpiceFarm badshah = new SpiceFarm("Badshah Spice Estate", "Karnataka", "Chemical");
        session.persist(everest);
        session.persist(badshah);

        session.persist(new SpiceBatch("Black Pepper", "123", everest));
        session.persist(new SpiceBatch("Cardamom", "456", everest));
        session.persist(new SpiceBatch("Clove", "789", badshah));
        tx.commit();

        SpiceFarm fetchedFarm = session.get(SpiceFarm.class, everest.getId());
        System.out.println("Farm: " + fetchedFarm.getFarmName());

        session.createQuery(
                "from SpiceBatch sb where sb.farm.farmName = :farm",
                SpiceBatch.class
        )
        .setParameter("farm", "Everest Organic")
        .getResultList()
        .forEach(sb -> System.out.println("Batch: " + sb.getSpiceType() + " | Lot: " + sb.getLotCode()));

        session.close();
        sf.close();
        System.out.println("Done...");
    }
}
