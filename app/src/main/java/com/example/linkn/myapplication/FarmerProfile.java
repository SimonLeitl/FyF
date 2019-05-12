package com.example.linkn.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class FarmerProfile extends AppCompatActivity {

    private FirebaseFirestore mDatabase;
    private String anzahlFarmshops;
    private String anzahlAutomaten;
    private ArrayList<String> farmshopList = new ArrayList<>();
    private ArrayList<String> automatenList = new ArrayList<>();
    private RadioGroup radioButtonGroup;
    private RadioButton radioShopButton, radioMachineButton;
    private String farmerID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        radioButtonGroup = findViewById(R.id.radioGroup);
        radioShopButton = findViewById(R.id.radioButtonShop);
        radioMachineButton = findViewById(R.id.radioButtonAutomat);
    }

    public FarmerProfile(){
    }


    public void showShopsOrMachines(){
        // when the radiobutton is clicked, he will read the data from database and show the shops tje farmer have
        if(radioShopButton.isSelected()){

        }

        if(radioMachineButton.isSelected()){

        }

    }

    protected void getShopsAndMachines(String farmerID){
        this.farmerID = farmerID;
        mDatabase = FirebaseFirestore.getInstance();
        DocumentReference farmerProfile = mDatabase.collection("Farmer").document(farmerID);
        farmerProfile.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>(){
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                anzahlFarmshops = document.getString("farmshop");
                int anzahlshops = Integer.getInteger(anzahlFarmshops);

                // guess the size/ length of the saved farmshops in database and will add it to an arraylist 
                if(anzahlFarmshops != null | anzahlshops > 0){
                    for(int i = 0; i< anzahlshops;i++){
                        String farmerFarmshops = document.getString(Integer.toString(i));
                            farmshopList.add(farmerFarmshops);
                    }
                }

                anzahlAutomaten = document.getString("automat");
                int anzahlautomaten = Integer.getInteger(anzahlAutomaten);

                if(anzahlAutomaten != null | anzahlautomaten > 0){
                    for(int i = 0; i< anzahlautomaten;i++){
                        String farmerAutomat = document.getString(Integer.toString(i));
                            automatenList.add(farmerAutomat);
                    }
                }
            }
        });
    }
}