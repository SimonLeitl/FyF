package com.example.linkn.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class FarmerProfile extends AppCompatActivity {

    private static String farmerIDReal;
    private FirebaseFirestore mDatabase;
    private List<String> group = new ArrayList<>();
    private List<String> shops = new ArrayList<>();
    private static final String FARMERID = "com.example.linkn.myapplication";
    private TextView farmerVorname, farmerNachname;
    private ListView farmerShops;


    public FarmerProfile(){

    }
    public static void start(Context context, String farmerIDID) {
        Intent intent = new Intent(context, FarmerProfile.class);
        intent.putExtra(FARMERID, farmerIDID);
        context.startActivity(intent);
        farmerIDReal = farmerIDID;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmer_profile);
        Intent intent = this.getIntent();
        getShopsAndMachines(farmerIDReal);
    }


    public void showShopsOrMachines(){
      /*  for ( String farmshopIDReal  : shops) {
        DocumentReference farmerProfile;
        farmerProfile = mDatabase.collection("Farmshop").document(farmshopGroup);
        farmerProfile.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();

                String shopName = document.getString("shopname");
                String shopArt = document.getString("Shopart");
                shops.add(shopName + ", " + shopArt);
            }
        });

        } */
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, shops);

        farmerShops.setAdapter(adapter);
    }

   /* public void showResultAsList(){

    }*/

    protected void getShopsAndMachines(String farmerID){
        this.farmerIDReal = farmerID;
        farmerShops = findViewById(R.id.shopListItem);
        farmerVorname = findViewById(R.id.textViewFarmerVorname);
        farmerNachname = findViewById(R.id.textViewFarmerNachname);
        mDatabase = FirebaseFirestore.getInstance();

        DocumentReference farmerProfile = mDatabase.collection("Farmer").document(farmerID);
        farmerProfile.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>(){
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                String farmerVornameDB = document.getString("firstname");
                farmerVorname.setText(farmerVornameDB);
                String farmerNachnameDB = document.getString("lastname");
                farmerNachname.setText(farmerNachnameDB);

                group = (List<String>) document.get("farmshopid");

                for (String farmshopGroup : group ) {
                    shops.add(farmshopGroup);

                    showShopsOrMachines();
                }
            }
        });

        //showResultAsList();

        Button okButton = (Button) findViewById(R.id.buttonOK);
        View.OnClickListener onClickListener = OnClickListener -> {
            startActivity(new Intent(FarmerProfile.this, MapsActivity.class));
        };
        okButton.setOnClickListener(onClickListener);
    }
}