package com.example.project4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class reason extends AppCompatActivity {
String email;
TextView hint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reason);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent in = getIntent();
        setTitle("Learnish");
        email= in.getStringExtra("email");
        hint=(TextView)findViewById(R.id.hint);
        hint.setText(email);

    }
    public void next(View v)
    {

        Intent intent = new Intent (this,goal.class);
        intent.putExtra("email", email);
        startActivity (intent);
    }

}
