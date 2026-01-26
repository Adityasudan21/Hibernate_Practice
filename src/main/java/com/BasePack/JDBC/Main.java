package com.BasePack.JDBC;

public class Main
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        DBTest test1=new DBTest();
        try {
            test1.createconnection();
            JDBC_Queries q1=new JDBC_Queries();
            System.out.println("Starting create statement");
//            q1.create();
//            q1.insert(1,"Aditya",23);
//            q1.insert(2,"Anushka",22);
            q1.read();
//            q1.update();
//            q1.delete(1);
            test1.closeconnection();
        } catch (Exception e) {
            System.out.println("Connection Not made");
            e.printStackTrace();
        }


    }
}
