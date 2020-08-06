package com.example.project4;


import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import static com.example.project4.DatabaseContract.Rate.TABLE_NAME;


public class feedBack extends AppCompatActivity {
    Float ratingNumber;
    RatingBar simpleRatingBar;
    TextView hint;
    String email;
    SQLiteDatabase db;
    Button b;
    DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        setTitle("Learnish");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        simpleRatingBar = (RatingBar) findViewById(R.id.ratingBar); // initiate a rating bar
        ratingNumber = simpleRatingBar.getRating(); // get rating number from a rating bar
        Intent in = getIntent();
        email= in.getStringExtra("email");
        hint=(TextView)findViewById(R.id.hint);
        hint.setText(email);
        dbHelper = new DatabaseHelper(this);
        b= (Button)findViewById(R.id.b);

    }
    public void rated(View v)
    {
        rating(v);

        b.setEnabled(false);

    }
    public void rating(View v)
    {
        if(check(v))
        {
            String s="Feedback is already been Recorded.Thankyou!";
            Snackbar mySnackbar = Snackbar.make(v, s, 2000);
            mySnackbar.show();
        }
        else {
            db = dbHelper.getWritableDatabase();
            ratingNumber = simpleRatingBar.getRating();
            ContentValues values = new ContentValues();
            values.put(DatabaseContract.Rate.EMAIL, hint.getText().toString());
            values.put(DatabaseContract.Rate.RATING, ratingNumber);
            long newRowId = db.insert(TABLE_NAME, null, values);
            if (newRowId > 0) {
                String s="Thankyou for feedBack";
                Snackbar mySnackbar = Snackbar.make(v, s, 2000);
                mySnackbar.show();
                Toast.makeText(this, "New user rated: " + newRowId, Toast.LENGTH_SHORT).show();
            }
        }
        db.close();
    }
    public boolean check (View v)
    {
        db= dbHelper.getWritableDatabase();
        int found=0;
        final String [] columns={DatabaseContract.Rate.EMAIL};
        ContentValues values = new ContentValues();
        Cursor c=db.query (TABLE_NAME, null, null, null, null, null,null);
        while (c.moveToNext())
        {
            String em=c.getString(0);
            if(em.equalsIgnoreCase(email))
            {
                found=1;
            }
        }
        if(found==1)
            return true;
        else
            return false;
    }

    public void implIntent (View v)
    {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.atistudios.mondly.languages"));
            startActivity(intent);
        }
        catch(Exception e)
        {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.atistudios.mondly.languages&h1=en"));
            startActivity(intent);
        }
    }
}
