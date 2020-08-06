package com.example.project4;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class path extends AppCompatActivity {
String email;
TextView hint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent in= getIntent();
        email= in.getStringExtra("email");
        hint=(TextView)findViewById(R.id.hint);
        hint.setHint(email);
        setTitle("Learnish");
    }
    public void decide1(View v)
    {
        Intent intent= new Intent (this, quiz1.class);
        intent.putExtra("email", email);
        startActivity(intent);
    }
    public void decide2(View v)
    {
        Intent intent= new Intent (this, categories.class);
        intent.putExtra("email", email);
        startActivity(intent);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.logOut:
                Toast.makeText(this, "logged out successully", Toast.LENGTH_SHORT).show();
                Intent lo = new Intent(this, MainActivity.class);
                startActivity(lo);
                return true;
            case R.id.help:
                Toast.makeText(this, "selected help", Toast.LENGTH_SHORT).show();
                Intent hel = new Intent(this, help.class);
                startActivity(hel);
                return true;
            case R.id.feedBack:
                Toast.makeText(this, "selected feedBack", Toast.LENGTH_SHORT).show();
                Intent fb = new Intent(this, feedBack.class);
                fb.putExtra("email", email);
                startActivity(fb);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}
