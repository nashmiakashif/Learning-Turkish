package com.example.project4;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class goal extends AppCompatActivity {
    TextView  hint;
    String email;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);
        setTitle("Learnish");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent in = getIntent();
        email= in.getStringExtra("email");
        hint=(TextView)findViewById(R.id.hint);
        hint.setText(email);
    }
    public void next(View v)
    {
        Intent intent = new Intent (this,path.class);
        intent.putExtra("email", email);
        startActivity (intent);
    }

}
