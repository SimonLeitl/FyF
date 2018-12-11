package com.example.linkn.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Profile extends AppCompatActivity {
    private double[] gps;
    private String name;
   private int id;
    public FirebaseAuth auth;
    public TextView vornameTextView,nachnameTextView, gebTextView, emailTextView;

    private FirebaseFirestore mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil_view);
        mDatabase = FirebaseFirestore.getInstance();

       read();

    }



    public Profile() {
    }

    public void read(){
        vornameTextView=(TextView) findViewById(R.id.vornameTextView);
        nachnameTextView=(TextView) findViewById(R.id.nachnameTextView);
        gebTextView=(TextView) findViewById(R.id.gebTextView);
        gebTextView=(TextView) findViewById(R.id.gebTextView);
        //ruft den aktuellen User ab
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        //gibt den String des aktuellen Users
        String uid = user.getUid();

        DocumentReference Farmer=mDatabase.collection("Farmer").document(uid);
        DocumentReference Customer=mDatabase.collection("Customer").document(uid);


        Farmer.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>(){
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                DocumentSnapshot document=task.getResult();
                String vorname=document.getString("firstname");
                String nachname=document.getString("lastname");
                String geb=document.getString("born");
                vornameTextView.setText(vorname);
                nachnameTextView.setText(nachname);
                gebTextView.setText(geb);

            }
        });




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
