package com.company;

public class Brands {
    private int id;
    private String brandsName;

    public Brands(int id, String brandsName) {
        this.id = id;
        this.brandsName = brandsName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandsName() {
        return brandsName;
    }

    public void setBrandsName(String brandsName) {
        this.brandsName = brandsName;
    }
}
