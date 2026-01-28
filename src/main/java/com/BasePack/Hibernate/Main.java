package com.BasePack.Hibernate;

public class Main {
    static HibernateFunctions Functions=new HibernateFunctions();
    public static void main(String[] args){
        Student s1=new Student();
        s1.setRollNo(6);
        s1.setsName("Anjali");
        s1.setsAge(17);

//        //Insert in Table
//        if(Functions.insert(s1))
//            System.out.println("Object Inserted in Table Student");
//        else
//            System.out.println("Can't Insert Object in the Table Student");

        //Update row in a table
//        Functions.updateRow(s1);


        Student s3=null;
        s3=Functions.Read(s3,"6");
        //Delete Row in the table (We could first use (Read to fetch student object then send to Removefunction)
        Functions.deleteRow(s3);

        Student s2=null;

        //Read the value of a record with the primary key reference
        s2=Functions.Read(s2,"5");
        if(s2==null)
            System.out.println("No Record Found in Table Student");
        else
            System.out.println(s2.toString());

    }
}
