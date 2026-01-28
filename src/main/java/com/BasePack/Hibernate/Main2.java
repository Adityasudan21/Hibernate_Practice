package com.BasePack.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main2 {
    static HibernateFunctions Functions=new HibernateFunctions(); //Can't use this creates Session Factory for Student Class
    public static void main(String[] args) {


        Laptop l1=new Laptop();
        l1.setName("Mac");
        l1.setRam("16");

        Alien a1=new Alien();
        a1.setAid(1);
        a1.setAname("Aditya");
        a1.setLaptop(l1);

        Configuration cfg=new Configuration();
        cfg.addAnnotatedClass(com.BasePack.Hibernate.Alien.class);
        cfg.configure();

        SessionFactory sf=cfg.buildSessionFactory();

        Session session=sf.openSession();

        session.persist(a1);

        Transaction t1= session.beginTransaction();
        t1.commit();

        session.close();
        sf.close();

    }
}
