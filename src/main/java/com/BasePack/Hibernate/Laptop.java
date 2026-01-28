package com.BasePack.Hibernate;

import jakarta.persistence.Embeddable;

@Embeddable //This make this class club with any table (Adds the columns to a table that has field as Laptop)
public class Laptop {

    private String name;
    private String ram;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }
}
