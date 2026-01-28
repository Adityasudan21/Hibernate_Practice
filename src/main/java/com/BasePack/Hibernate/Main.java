package com.BasePack.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    static HibernateFunctions Functions=new HibernateFunctions();
    public static void main(String[] args){
        Student s1=new Student();
        s1.setRollNo(5);
        s1.setsName("Vishka");
        s1.setsAge(19);

//        //Insert in Table
//        if(Functions.insert(s1))
//            System.out.println("Object Inserted in Table Student");
//        else
//            System.out.println("Can't Insert Object in the Table Student");

        Student s2=null;

        //Read the value of a record with the primary key reference
        s2=Functions.Read(s2,"5");
        if(s2==null)
            System.out.println("No Record Found in Table Student");
        else
            System.out.println(s2.toString());

    }
}
