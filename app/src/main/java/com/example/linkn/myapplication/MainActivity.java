package com.example.linkn.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
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
}