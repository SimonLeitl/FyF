package com.example.linkn.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Farmshop extends AppCompatActivity {
    private Farmer owner;
    private String shopname;
    private double[] gps;
    public FirebaseAuth auth;
    private FirebaseFirestore mDatabase;
    Map<String, Object> userEingabe = new HashMap<>();

    EditText shopnameTextbox,inhaberTextBox,StraßeTextBox,hausnummerTextBox,plzTextBox, ortTextBox2,phoneTextBox, emailTextBox;

    // Farmshopdaten als enum speichern? Name, Adresse, Öffnungszeiten...
public Farmshop(){}
public Farmshop(Farmer owner, String shopname, double[]gps){
    this.owner=owner;
    this.shopname=shopname;
    this.gps=gps;
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_farm_shop1);

        mDatabase = FirebaseFirestore.getInstance();


    }

public void createFarmshop1(View view){
    auth = FirebaseAuth.getInstance();
    //ruft den aktuellen User ab
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    //gibt den String des aktuellen Users
    String uid = user.getUid();

    shopnameTextbox = (EditText) findViewById(R.id.shopnameTextBox);
    inhaberTextBox = (EditText) findViewById(R.id.inhaberTextBox);
    StraßeTextBox = (EditText) findViewById(R.id.StraßeTextBox);
    hausnummerTextBox = (EditText) findViewById(R.id.hausnummerTextBox);
    plzTextBox = (EditText) findViewById(R.id.plzTextBox);
    ortTextBox2 = (EditText) findViewById(R.id.ortTextBox2);
    phoneTextBox = (EditText) findViewById(R.id.phoneTextBox);
    emailTextBox = (EditText) findViewById(R.id.emailTextBox);

    userEingabe.put("shopname",shopnameTextbox.getText().toString());
    userEingabe.put("inhabername", inhaberTextBox.getText().toString());
    userEingabe.put("straße", StraßeTextBox.getText().toString());
    userEingabe.put("hausnummer",hausnummerTextBox.getText().toString());
    userEingabe.put("plz", plzTextBox.getText().toString());
    userEingabe.put("ort", ortTextBox2.getText().toString());
    userEingabe.put("phone",phoneTextBox.getText().toString());
    userEingabe.put("email", emailTextBox.getText().toString());

    mDatabase.collection("Farmshop").document(uid).set(userEingabe);
    setContentView(R.layout.create_farm_shop2);
}

public void createFarmshop2(){
    int i=0;
    auth = FirebaseAuth.getInstance();
    //ruft den aktuellen User ab
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    //gibt den String des aktuellen Users
    String uid = user.getUid();
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
