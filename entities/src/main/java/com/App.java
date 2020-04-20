package com.carrent;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App
{

    private static final SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

    public static void main( String[] args )
    {
        final Session session = SESSION_FACTORY.openSession();
        final Transaction transaction = session.beginTransaction();

        transaction.commit();
        session.close();

        System.out.println("test");
    }
}
