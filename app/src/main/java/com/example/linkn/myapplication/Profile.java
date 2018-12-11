package com.example.linkn.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    EditText changePasswort;
    public void changePasswordKlick(View view){
        setContentView(R.layout.change_password);
        changePasswort=(EditText) findViewById(R.id.newPasswortTextBox);
    }
public void changePassword(View view){
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    user.updatePassword(changePasswort.getText().toString().trim())
            .addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(Profile.this, "Password is updated!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Profile.this, "Failed to update password!", Toast.LENGTH_SHORT).show();
                        //progressBar.setVisibility(View.GONE);
                    }
                }
            });
}
    EditText newMail;
public void changeEmailKlick(View view){
    setContentView(R.layout.change_mail);
    newMail=(EditText) findViewById(R.id.newMail);

}

public void changeEmail(View view){
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    user.updateEmail(newMail.getText().toString().trim())
            .addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(Profile.this, "Email address is updated.", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(Profile.this, "Failed to update email!", Toast.LENGTH_LONG).show();
                    }
                }
            });
}

public void deleteAcc(View view){

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    if (user != null) {
        user.delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Profile.this, "Your profile is deleted:( Create a account now!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Profile.this, "Failed to delete your account!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
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
