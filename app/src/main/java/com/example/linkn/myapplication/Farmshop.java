package com.example.linkn.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
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
    //Map<String, Object> öffnungszeiten=new HashMap<>();

    EditText shopnameTextbox,inhaberTextBox,StraßeTextBox,hausnummerTextBox,plzTextBox, ortTextBox2,phoneTextBox, emailTextBox,
            moAnfangTextBox, moEndeTextBox,diAnfangTextBox, diEndeTextBox,miAnfangTextBox, miEndeTextBox,doAnfangTextBox,
            doEndeTextBox,frAnfangTextBox, frEndeTextBox,saAnfangTextBox, saEndeTextBox,soAnfangTextBox, soEndeTextBox;
    CheckBox montagcheckBox,dienstagcheckBox,mittwochcheckBox,donnerstagcheckBox,freitagcheckBox, samstagcheckBox, sonntagcheckBox;

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

public void createFarmshop2(View view){
    int i=0;
    auth = FirebaseAuth.getInstance();
    //ruft den aktuellen User ab
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    //gibt den String des aktuellen Users
    String uid = user.getUid();

    moAnfangTextBox = (EditText) findViewById(R.id.moAnfangTextBox);
    moEndeTextBox = (EditText) findViewById(R.id.moEndeTextBox);
    diAnfangTextBox = (EditText) findViewById(R.id.diAnfangTextBox);
    diEndeTextBox = (EditText) findViewById(R.id.diEndeTextBox);
    miAnfangTextBox = (EditText) findViewById(R.id.miAnfangTextBox);
    miEndeTextBox = (EditText) findViewById(R.id.miEndeTextBox);
    doAnfangTextBox = (EditText) findViewById(R.id.doAnfangTextBox);
    doEndeTextBox = (EditText) findViewById(R.id.doEndeTextBox);
    frAnfangTextBox = (EditText) findViewById(R.id.frAnfangTextBox);
    frEndeTextBox = (EditText) findViewById(R.id.frEndeTextBox);
    saAnfangTextBox = (EditText) findViewById(R.id.saAnfangTextBox);
    saEndeTextBox = (EditText) findViewById(R.id.saEndeTextBox);
    soAnfangTextBox = (EditText) findViewById(R.id.soAnfangTextBox);
    soEndeTextBox = (EditText) findViewById(R.id.soEndeTextBox);


    montagcheckBox = (CheckBox) findViewById(R.id.montagcheckBox);
    dienstagcheckBox = (CheckBox) findViewById(R.id.dienstagcheckBox);
    mittwochcheckBox= (CheckBox) findViewById(R.id.mittwochcheckBox);
    donnerstagcheckBox = (CheckBox) findViewById(R.id.donnerstagcheckBox);
    freitagcheckBox = (CheckBox) findViewById(R.id.freitagcheckBox);
    samstagcheckBox = (CheckBox) findViewById(R.id.samstagcheckBox);
    sonntagcheckBox=(CheckBox)findViewById(R.id.sonntagcheckBox);


    if(montagcheckBox.isChecked()){
    userEingabe.put("Montag",moAnfangTextBox.getText().toString() + " - " + moEndeTextBox.getText().toString());
    }
    if(dienstagcheckBox.isChecked()){
        userEingabe.put("Dienstag",diAnfangTextBox.getText().toString() + " - " + diEndeTextBox.getText().toString());
    }
    if(mittwochcheckBox.isChecked()){
        userEingabe.put("Mittwoch",miAnfangTextBox.getText().toString() + " - " + miEndeTextBox.getText().toString());

    }
    if(donnerstagcheckBox.isChecked()){
        userEingabe.put("Donnerstag",doAnfangTextBox.getText().toString() + " - " + doEndeTextBox.getText().toString());

    }
    if(freitagcheckBox.isChecked()){
        userEingabe.put("Freitag",frAnfangTextBox.getText().toString() + " - " + frEndeTextBox.getText().toString());

    }
    if(samstagcheckBox.isChecked()){
        userEingabe.put("Samstag",saAnfangTextBox.getText().toString() + " - " + saEndeTextBox.getText().toString());

    }
    if(sonntagcheckBox.isChecked()){
        userEingabe.put("Sonntag",soAnfangTextBox.getText().toString() + " - " + soEndeTextBox.getText().toString());

    }

    mDatabase.collection("Farmshop").document(uid).set(userEingabe);

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
