package com.example.linkn.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Farmshop extends AppCompatActivity {
    private Farmer owner;
    private String shopname;
    private double[] gps;
    public FirebaseAuth auth;
    private FirebaseFirestore mDatabase;
    private DocumentReference Farmshop;
    Map<String, Object> userEingabe = new HashMap<>();
    //Map<String, Object> öffnungszeiten=new HashMap<>();
    Map<String, Object> farmshopId=new HashMap<>();

    EditText shopnameTextbox,inhaberTextBox,StraßeTextBox,hausnummerTextBox,plzTextBox, ortTextBox2,phoneTextBox, emailTextBox,
            moAnfangTextBox, moEndeTextBox,diAnfangTextBox, diEndeTextBox,miAnfangTextBox, miEndeTextBox,doAnfangTextBox,
            doEndeTextBox,frAnfangTextBox, frEndeTextBox,saAnfangTextBox, saEndeTextBox,soAnfangTextBox, soEndeTextBox;
    CheckBox montagcheckBox,dienstagcheckBox,mittwochcheckBox,donnerstagcheckBox,freitagcheckBox, samstagcheckBox, sonntagcheckBox, geöffnetCeckBox;
    private RadioGroup radioGroup;
    private RadioButton radioButton;

    TextView adressTextView,phoneTextView;
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

        mDatabase = FirebaseFirestore.getInstance();
        setContentView(R.layout.create_farm_shop1);

    }
public void durchgängigGeöffnet(View view){
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
    geöffnetCeckBox=(CheckBox) findViewById(R.id.geöffnetCheckBox);


    if(geöffnetCeckBox.isChecked()){
        moAnfangTextBox.setVisibility(View.INVISIBLE);
        moEndeTextBox.setVisibility(View.INVISIBLE);
        diAnfangTextBox.setVisibility(View.INVISIBLE);
        diEndeTextBox.setVisibility(View.INVISIBLE);
        miAnfangTextBox.setVisibility(View.INVISIBLE);
        miEndeTextBox.setVisibility(View.INVISIBLE);
        doAnfangTextBox.setVisibility(View.INVISIBLE);
        doEndeTextBox.setVisibility(View.INVISIBLE);
        frAnfangTextBox.setVisibility(View.INVISIBLE);
        frEndeTextBox.setVisibility(View.INVISIBLE);
        saAnfangTextBox.setVisibility(View.INVISIBLE);
        saEndeTextBox.setVisibility(View.INVISIBLE);
        soAnfangTextBox.setVisibility(View.INVISIBLE);
        soEndeTextBox.setVisibility(View.INVISIBLE);

    }else {
        moAnfangTextBox.setVisibility(View.VISIBLE);
        moEndeTextBox.setVisibility(View.VISIBLE);
        diAnfangTextBox.setVisibility(View.VISIBLE);
        diEndeTextBox.setVisibility(View.VISIBLE);
        miAnfangTextBox.setVisibility(View.VISIBLE);
        miEndeTextBox.setVisibility(View.VISIBLE);
        doAnfangTextBox.setVisibility(View.VISIBLE);
        doEndeTextBox.setVisibility(View.VISIBLE);
        frAnfangTextBox.setVisibility(View.VISIBLE);
        frEndeTextBox.setVisibility(View.VISIBLE);
        saAnfangTextBox.setVisibility(View.VISIBLE);
        saEndeTextBox.setVisibility(View.VISIBLE);
        soAnfangTextBox.setVisibility(View.VISIBLE);
        soEndeTextBox.setVisibility(View.VISIBLE);
    }
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
    radioGroup = (RadioGroup) findViewById(R.id.radioGroup);


    int selectedId = radioGroup.getCheckedRadioButtonId();
    radioButton = (RadioButton) findViewById(selectedId);
    userEingabe.put("Shopart",radioButton.getText());

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
    userEingabe.put("FarmerID",uid);
    //erstellt ein neues Document für einen Farmshop mit einer zufalls ID
    DocumentReference ref=mDatabase.collection("Farmshop").document();
    //fügt die Farmshopdaten in das Farmshop Dokument
    mDatabase.collection("Farmshop").add(userEingabe);
    //String für die zufällig generierte ID
    String id=ref.getId();
    //fügt die Farmshop Id dem Farmer zu
    DocumentReference Farmer = mDatabase.collection("Farmer").document(uid);
    Farmer.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
        public void onComplete(@NonNull Task<DocumentSnapshot> task) {

            DocumentSnapshot document = task.getResult();
            List<Object> farmshopIds=new ArrayList<Object>();
            farmshopIds.add(document.get("farmshopid"));
            farmshopIds.add(id);


            farmshopId.put("farmshopid",farmshopIds);

        }
    });
    mDatabase.collection("Farmer").add(farmshopId);

    startActivity(new Intent(Farmshop.this, MapsActivity.class));


}

public void FarmShopShow(){
}

public void showFarmShop(View view){
    setContentView(R.layout.farm_shop_profile);
    adressTextView = (TextView) findViewById(R.id.adressTextView);
    phoneTextView = (TextView) findViewById(R.id.phoneTextView);

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    //gibt den String des aktuellen Users
    String uid = user.getUid();

    Farmshop=mDatabase.collection("Farmshop").document(uid);

    Farmshop.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>(){
        public void onComplete(@NonNull Task<DocumentSnapshot> task) {

            DocumentSnapshot document=task.getResult();
            String adresse=document.getString("straße")+" "+document.getString("hausnummer")+" "+document.getString("plz")+" "+document.getString("ort");
            String phone=document.getString("phone");
           // String geb=document.getString("born");
            adressTextView.setText(adresse);
            phoneTextView.setText(phone);
        }
    });


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

    public void saveAsFavorite(){

        auth = FirebaseAuth.getInstance();

        // gibt eine Instanz des aktuellen Nutzers zurück
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        //speichert die ID des aktuellen Nutzer in einen String.
        String uid = user.getUid();

        //erstellet einen neuen einen neuen Eintrag in der Favoriten Tabelle. Der Eintrag bekommt als Id, die des aktiven Nutzers zugewiesen. Die Farmshop ID wird als Feld innerhalb des Eintrags gespeichert.
        mDatabase.collection("Favoriten").document(uid).set(Farmshop.getId());

    }
}