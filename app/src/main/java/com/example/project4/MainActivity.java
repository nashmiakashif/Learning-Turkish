package com.example.project4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Learnish");


    }
    public void admin (View v)
    {
        Intent i = new Intent(this,adminPas.class);
        startActivity(i);
    }
    public void user (View v)
    {
        Intent j = new Intent(this,user.class);
        startActivity(j);
    }
}
