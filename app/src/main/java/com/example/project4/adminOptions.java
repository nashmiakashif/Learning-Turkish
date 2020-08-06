package com.example.project4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class adminOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_options);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Learnish");
    }

    public void insertData(View v)
    {
        Intent i = new Intent(this, admin.class);
        startActivity(i);
    }

    public void viewInfo(View v)
    {
        Intent i = new Intent(this, viewLearningTable.class);
        startActivity(i);
    }

    public void viewUsers(View v)
    {
        Intent i = new Intent(this, viewUsersTable.class);
        startActivity(i);
    }
    public void viewRating(View v)
    {
        Intent i = new Intent(this, viewRatingTable.class);
        startActivity(i);
    }
}

