package com.example.linkn.myapplication;

public class Account {
    private String id,name, nachname, alter;
    private int geburtstag;

    public Account(){

    }
    public Account(String name, String nachname, String alter, String id){
        this.name=name;
        this.nachname=nachname;
        this.alter=alter;
        this.id=id;
    }

}
