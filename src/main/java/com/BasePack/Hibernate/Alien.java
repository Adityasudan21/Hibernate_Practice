package com.BasePack.Hibernate;

import jakarta.persistence.*;

//This class is to just show different annotations that can change the table name from give class name when created

@Entity
@Table(name = "alien_table") //This gives the custom Table name
public class Alien {

    @Id //Primary Key
    @Column(name = "alien_id") //This give the custom column name
    private int aid;

    @Column(name = "alien_name")
    private String aname;

    @Transient //This is used to tell Hibernate not use this field in the table
    private String tech;

    private Laptop laptop; //This is from the Embeddable class

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                ", laptop=" + laptop +
                '}';
    }
}
