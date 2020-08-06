package com.example.project4;


import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText email, pass;
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    ProgressDialog process;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbHelper = new DatabaseHelper(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        setTitle("User Mode");
        setTitle("Learnish");
        setTitleColor(R.color.colorAccent);
        email= (EditText)findViewById(R.id.email);
        pass= (EditText)findViewById(R.id.pass);

    }
    public void signup(View v)
    {
        Intent j = new Intent(this, user.class);
        startActivity(j);
    }
    public void login (View v)
    {

        if(checking(v))
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
            Intent intent = new Intent(this, path.class);
            intent.putExtra("email",email.getText().toString());
            startActivity(intent);
        }
        else
        {
            email.setText("");
            pass.setText("");
            Toast.makeText(getApplicationContext(), "No such user exists." , Toast.LENGTH_SHORT).show();
        }


    }
    public Boolean checking(View v)
    {
        email= (EditText)findViewById(R.id.email);
        pass= (EditText)findViewById(R.id.pass);
        int found=0;
        db = dbHelper.getWritableDatabase();
        final String[] columns = { DatabaseContract.Users.EMAIL, DatabaseContract.Users.PASSWORD, DatabaseContract.Users.NAME,
                DatabaseContract.Users.AGE};
        Cursor c = db.query(DatabaseContract.Users.TABLE_NAME, null, null, null, null, null, null);
        while (c.moveToNext()) {
            String em = c.getString(1);
            String pa = c.getString(0);
            if (em.equalsIgnoreCase(email.getText().toString())   &&  pa.equalsIgnoreCase(pass.getText().toString()) )
            {
                Toast.makeText(getApplicationContext(), "matched." , Toast.LENGTH_SHORT).show();
                found=1;
            }

        }
        if(found==0) {
            return false;
        }
        else
            return true;
    }
    public void reLoad(View v)
    {
        email.setText("");
        pass.setText("");
    }

}
