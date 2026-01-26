package com.BasePack.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args){
        Student s1=new Student();
        s1.setRollNo(3);
        s1.setsName("Harsh");
        s1.setsAge(28);

//        Configuration cfg=new Configuration();
//        cfg.addAnnotatedClass(com.BasePack.Hibernate.Student.class); //This is to Let hibernate know where to find
//        // the annotated file
//        cfg.configure();  //Configure through the XML provided
//        SessionFactory sf=cfg.buildSessionFactory(); //Heavyweight close and open mindfully

        //WRITE ABOVE OR USE CON-CAT to write in a single line like below
        SessionFactory sf=new Configuration()
                .addAnnotatedClass(com.BasePack.Hibernate.Student.class)
                .configure()
                .buildSessionFactory(); //Heavyweight close and open mindfully



        Session session=sf.openSession(); //lightweight open close when needed
        session.persist(s1);   // .save has been removed in Hibernate 7.1.0

        Transaction trans= session.beginTransaction();
        //After this we need to save this (OR COMMIT this) This is done like a transaction
        trans.commit();

        session.close();
        sf.close();
        System.out.println(s1.toString());
    }
}
