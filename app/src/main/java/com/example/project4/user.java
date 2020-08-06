package com.example.project4;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;


import static com.example.project4.DatabaseContract.Users.TABLE_NAME;

public class user extends AppCompatActivity {
    EditText name, email, pas1, pas2, age;
    int id;
    String val1, val2, val3;
    int ag;
    SQLiteDatabase db;
    DatabaseHelper dbHelper;
    TextView g;
    RadioGroup radiogrp;
    ProgressDialog process;
    public static final Pattern EMAIL_ADDRESS
            = Pattern.compile(
            "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dbHelper = new DatabaseHelper(this);
        setTitle("Learnish");
        Intent i = getIntent();
        name=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
        pas1=(EditText)findViewById(R.id.pas1);
        pas2=(EditText)findViewById(R.id.pas2);
        radiogrp = (RadioGroup) findViewById(R.id.RadioG);
        id = radiogrp.getCheckedRadioButtonId();
        g=(TextView)findViewById(R.id.g);

    }

    public void signUP (View v)
    {

        if(validateEmail(v) && validatePas(v)  && fields(v))
        {
            process = ProgressDialog.show(this, "please wait", "Signing Up", true);
            CountDownTimer ctd = new CountDownTimer(2000, 980) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    process.dismiss();

                }
            };
            InsertData(v);
            Intent intent = new Intent(this, reason.class);
            intent.putExtra("email",email.getText().toString());
            startActivity(intent);
        }


    }
    public void InsertData (View v)
    {
        db = dbHelper.getWritableDatabase();
        name=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
        age = (EditText)findViewById(R.id.age);
        pas1=(EditText)findViewById(R.id.pas1);
        val1 = pas1.getText().toString();
        val2 = email.getText().toString();
        val3= name.getText().toString();
        ag=Integer.parseInt(age.getText().toString());
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.Users.PASSWORD, val1);
        values.put(DatabaseContract.Users.EMAIL, val2);
        values.put(DatabaseContract.Users.NAME, val3);
        values.put(DatabaseContract.Users.AGE,ag);
        long newRowId = db.insert(TABLE_NAME, null, values);
        if (newRowId > 0) {
            Toast.makeText(this, "New user joined: " + newRowId, Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
    public Boolean validateEmail (View v)
    {
        String emailInput = email.getText().toString().trim();
        if(email.getText().toString().isEmpty())
        {

            email.setError("Field can't be empty");
            return false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches())
        {
            email.setError("please enter a valid email address");
            email.setText("");
            return false;
        }
        else
        {
            return true;
        }
    }
    public boolean validatePas(View v) {
        if (pas1.getText().toString().isEmpty() || pas2.getText().toString().isEmpty()) {
            pas1.setError("Field can't be left empty");
            return false;
        }
        else if (pas1.length() < 5) {
            pas1.setError("too weak password");
            return false;
        } else if (!pas1.getText().toString().equals(pas2.getText().toString())) {
            pas1.setText("");
            pas2.setText("");
            pas2.setError("passwords dont match");
            return false;
        }
        else
            return true;
    }
    public void login (View v)
    {
        Intent j = new Intent(this, login.class);
        startActivity(j);
    }
    public boolean fields(View v) {

        if (name.getText().toString().isEmpty())
        {
            name.setError("Field can't be empty");
            return false;
        }
        else
            return true;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        name.setText("");
        email.setText("");
        age.setText("");
        pas1.setText("");
        pas2.setText("");
    }
}

