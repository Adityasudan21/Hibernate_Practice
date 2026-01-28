package com.BasePack.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateFunctions {
    public Student Read(Student s,String primary_key){
        SessionFactory sf=new Configuration()
                .addAnnotatedClass(com.BasePack.Hibernate.Student.class)
                .configure()
                .buildSessionFactory();
        Session s1=sf.openSession();
        //Main line
        s=s1.find(Student.class,primary_key);

        s1.close();
        sf.close();
        return s;
    }
    public boolean insert(Student s){

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

        //Main Line
        session.persist(s);   // .save has been removed in Hibernate 7.1.0

        Transaction trans= session.beginTransaction();
        //After this we need to save this (OR COMMIT this) This is done like a transaction
        trans.commit();
        session.close();
        sf.close();
        return s != null;
    }

    //Change value of a row in a table
    public void updateRow(Student s1){
        SessionFactory sf=new Configuration()
                .addAnnotatedClass(com.BasePack.Hibernate.Student.class)
                .configure()
                .buildSessionFactory(); //Heavyweight close and open mindfully


        Session session=sf.openSession(); //lightweight open close when needed

        //Main Line
        session.merge(s1);   // This is udpate the entry with object and add object if no entry found
        // This fires first the SELECT query then UPDATE query.

        Transaction trans= session.beginTransaction();
        //After this we need to save this (OR COMMIT this) This is done like a transaction as this is Manilpulation of Table Data
        trans.commit();
        session.close();
        sf.close();
    }
    //Delete a row
    public void deleteRow(Student s1){
        SessionFactory sf=new Configuration()
                .addAnnotatedClass(com.BasePack.Hibernate.Student.class)
                .configure()
                .buildSessionFactory(); //Heavyweight close and open mindfully


        Session session=sf.openSession(); //lightweight open close when needed

        //Main Line
        session.remove(s1);   // This is Delete the entry with object

        Transaction trans= session.beginTransaction();
        //After this we need to save this (OR COMMIT this) This is done like a transaction as this is Manilpulation of Table Data
        trans.commit();
        session.close();
        sf.close();
    }
}
