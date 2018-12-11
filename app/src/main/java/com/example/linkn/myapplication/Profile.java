package com.example.linkn.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class Profile extends AppCompatActivity {
    private double[] gps;
    private String name;
   private int id;
    public FirebaseAuth auth;
    public EditText vornameTextBox;

    private FirebaseFirestore mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil_view);
        mDatabase = FirebaseFirestore.getInstance();


    }



    public Profile() {
    }

    Task<DocumentSnapshot> task;
    public void read(){
        vornameTextBox=(EditText) findViewById(R.id.vornameTextBox);

        //ruft den aktuellen User ab
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        //gibt den String des aktuellen Users
        String uid = user.getUid();

        DocumentReference Farmer=mDatabase.collection("Farmer").document(uid);
        DocumentReference Customer=mDatabase.collection("Customer").document(uid);


        DocumentSnapshot document=task.getResult();

        String vorname=document.getString("firstname");

        vornameTextBox.setText(vorname);
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
