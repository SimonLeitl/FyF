package com.example.linkn.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    public EditText emailTextbox, passwortTextBox;
    public Button registrieren;
    public FirebaseAuth auth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);






    }


    public void onClick(View view){
        auth = FirebaseAuth.getInstance();

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        emailTextbox = (EditText) findViewById(R.id.emailText);
        passwortTextBox = (EditText) findViewById(R.id.passwortTextBox);
        registrieren=(Button) findViewById(R.id.registrierenButton);

        String email = emailTextbox.getText().toString().trim();
        String password = passwortTextBox.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        //create User

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        Toast.makeText(MainActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                          progressBar.setVisibility(View.GONE);
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(MainActivity.this, MainActivity.class));
                            finish();
                        }

                    }
                });
    }

    // eventListener für den Login Button auf der Startseite. Leitet zum Login weiter
    public void preLoginButtonClick(View view){
        setContentView(R.layout.login);
    }

    // eventListener für den Register Button auf der Startseite. Leitet zur preRegistrierung weiter
    public void preRegisterButtonClick(View view){
        setContentView(R.layout.preregistration);
    }


    // eventListener für den Login Button auf der Login Seite
    // Hier muss entsprechende Überprüfung der Daten stattfinden
    public void loginButtonClick(View view){

    }

    // eventListener für den Kunden Button auf der Registrierungsseite. Leitet zur Kundenregistration weiter
    public void kundeButtonClick(View view){
        setContentView(R.layout.registration);
    }

    // eventListener für den Verkäufer Button auf der Registrierungsseite. Leitet zur Verkäuferregistration weiter
    public void verkäuferButtonClick(View view){
        setContentView(R.layout.verkaeufer);
    }

    // setzt Passwort Feld bei Eingabe auf Verschlüsselte Eingabe
    public void passwortTextBoxClick(View view){
        EditText passwortText = (EditText) findViewById(R.id.passwortTextBox);
        passwortText.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }

    // setzt Passwort Feld bei Eingabe auf Verschlüsselte Eingabe
    public void passwortWdhTextBoxClick(View view){
        EditText passwortWdhText= (EditText) findViewById(R.id.passwortWdhTextBox);
        passwortWdhText.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }

    // setzt activity_main.xml wieder als aktiven View
    public void loginZurückButtonClick(View view){
        setContentView(R.layout.start);
    }

    // öffnet die Funktionen ohnen Login oder Registration.
    public void withoutLoginLabelKlick(View view){

    }
          protected void onResume() {
               super.onResume();
               //progressBar.setVisibility(View.GONE);

}}
