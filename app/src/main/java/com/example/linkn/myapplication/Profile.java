package com.example.linkn.myapplication;

public class Profile {
    private double[] gps;
    private String name;
   private int id;

    public Profile() {
    }

    public Profile (String name, int id, double[] gps){
        this.name=name;
        this.id=id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void editProfile(){

    }
}
