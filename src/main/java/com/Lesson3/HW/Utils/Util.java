package com.Lesson3.HW.Utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {
    private static SessionFactory sessionFactory;

    public static SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}