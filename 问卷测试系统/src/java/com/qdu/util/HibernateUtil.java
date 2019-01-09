
package com.qdu.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    static {
        try {
            Configuration cfg=new Configuration().configure();
            sessionFactory = cfg.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session getSession(){
        return sessionFactory.openSession();
    }
    public static void close(Session session){
        if(null!=session&&session.isOpen())
            session.close();
    }
}
