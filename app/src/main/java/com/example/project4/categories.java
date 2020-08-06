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

public class categories extends AppCompatActivity {
    TextView greet,foo , num, fam,oca,bword,hint;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Learnish");
        greet=(TextView)findViewById(R.id.greeting);
        num=(TextView)findViewById(R.id.number);
        foo=(TextView)findViewById(R.id.food);
        fam=(TextView)findViewById(R.id.family);
        oca=(TextView)findViewById(R.id.occassions);
        bword=(TextView)findViewById(R.id.bWord);
        Intent in = getIntent();
        email= in.getStringExtra("email");
        hint=(TextView)findViewById(R.id.hint);
        hint.setHint(email);
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
                Intent lo = new Intent(categories.this, MainActivity.class);
                startActivity(lo);
                return true;
            case R.id.help:
                Toast.makeText(this, "selected help", Toast.LENGTH_SHORT).show();
                Intent hel = new Intent(categories.this, help.class);
                startActivity(hel);
                return true;
            case R.id.feedBack:
                Toast.makeText(this, "selected feedBack", Toast.LENGTH_SHORT).show();
                Intent fb = new Intent(categories.this, feedBack.class);
                fb.putExtra("email", email);
                startActivity(fb);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    public void greet(View v)
    {
        Intent i = new Intent(categories.this,  words.class);
        i.putExtra("Category", "Greetings");
        i.putExtra("email", email);
        startActivity(i);
    }
    public void bWord(View v)
    {
        Intent i = new Intent(categories.this,  words.class);
        i.putExtra("Category", "Basic Words");
        i.putExtra("email", email);
        startActivity(i);
    }
    public void food(View v)
    {
        Intent i = new Intent(categories.this,  words.class);
        i.putExtra("Category", "Food");
        i.putExtra("email", email);
        startActivity(i);
    }
    public void fam(View v)
    {
        Intent i = new Intent(categories.this,  words.class);
        i.putExtra("Category", "family");
        i.putExtra("email", email);
        startActivity(i);
    }
    public void oca(View v)
    {
        Intent i = new Intent(categories.this,  words.class);
        i.putExtra("Category", "Occassions");
        i.putExtra("email", email);
        startActivity(i);
    }
    public void num(View v)
    {
        Intent i = new Intent(categories.this,  words.class);
        i.putExtra("Category", "Numbers");
        i.putExtra("email", email);
        startActivity(i);
    }

}
