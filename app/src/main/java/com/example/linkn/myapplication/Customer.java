package com.example.linkn.myapplication;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Customer extends Profile {
private double[] gps;

    public Customer(double []gps){
        super();
        this.gps=gps;
    }


    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String uid = user.getUid();

}
