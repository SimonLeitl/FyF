package com.example.linkn.myapplication;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class FarmerProfile {
    
    private FirebaseFirestore mDatabase;
    private String anzahlFarmshops;
    private String anzahlAutomaten;
    private ArrayList<String> farmshopList = new ArrayList<>();
    private ArrayList<String> automatenList = new ArrayList<>();

    public FarmerProfile(String farmerID){
        DocumentReference farmerProfile = mDatabase.collection("Farmer").document(farmerID);

        farmerProfile.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>(){
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();

                //check if the farmshop has an evaluation in the database
                if(document.exists()) {

                    // get the information from the database
                    anzahlFarmshops = document.getString("farmshop");

                    int anzahlshops = Integer.getInteger(anzahlFarmshops);

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
                            farmshopList.add(farmerAutomat);
                        }
                    }

                }
            }
        });

    }
}
