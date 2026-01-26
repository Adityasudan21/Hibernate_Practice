package com.BasePack.Hibernate;

import jakarta.persistence.Entity; //It is not from Hibernate it is from JPA Formerly (Java Persistance API)
import jakarta.persistence.Id;
//Know it is Jakarta Persistance API
//This is standard for the ORM Tools so that we could use some other ORM tool other than Hibernate also if needed

@Entity
public class Student {

    @Id //This is to say that that this is the primary key and this will give error if there is now primary key
    private int rollNo;
    private String sName;
    private int sAge;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsAge() {
        return sAge;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", sName='" + sName + '\'' +
                ", sAge=" + sAge +
                '}';
    }
}
