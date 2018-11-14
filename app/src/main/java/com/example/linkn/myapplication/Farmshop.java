package com.example.linkn.myapplication;

public class Farmshop {
    private Farmer owner;
    private String shopname;
    private double[] gps;

    // Farmshopdaten als enum speichern? Name, Adresse, Öffnungszeiten...

public Farmshop(Farmer owner, String shopname, double[]gps){
    this.owner=owner;
    this.shopname=shopname;
    this.gps=gps;
}

    public Farmer getOwner() {
        return owner;
    }

    public void setOwner(Farmer owner) {
        this.owner = owner;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public double[] getGps() {
        return gps;
    }

    public void setGps(double[] gps) {
        this.gps = gps;
    }
}
