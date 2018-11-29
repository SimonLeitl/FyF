package com.example.linkn.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Sucessful extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sucessful);

    }

    public void okButtonClick(View view){
        startActivity(new Intent(Sucessful.this, MainActivity.class));
    }
}
