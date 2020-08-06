package com.example.project4;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project4.DatabaseContract;
import com.example.project4.DatabaseHelper;
import com.example.project4.MainActivity;
import com.example.project4.R;


import static com.example.project4.DatabaseContract.Learning.TABLE_NAME;


public class admin extends AppCompatActivity {
    String val1, val2, val3, val4, val5, val6;
    DatabaseHelper dbHelper;
    EditText tw,ew,ts,es,pi,ca;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        setTitle("Learnish");
        dbHelper = new DatabaseHelper(this);
        tw= (EditText)findViewById(R.id.T_word);
        ew= (EditText)findViewById(R.id.E_word);
        ts= (EditText)findViewById(R.id.T_sen);
        es= (EditText)findViewById(R.id.E_sen);
        pi= (EditText)findViewById(R.id.pic);
        AutoCompleteTextView ca = (AutoCompleteTextView) findViewById(R.id.cat);
// Get the string array
        String[] categories = getResources().getStringArray(R.array.category);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories);

        ca.setAdapter(adapter);
    }
    public void insert (View v)
    {
        tw= (EditText)findViewById(R.id.T_word);
        ew= (EditText)findViewById(R.id.E_word);
        ts= (EditText)findViewById(R.id.T_sen);
        es= (EditText)findViewById(R.id.E_sen);
        pi= (EditText)findViewById(R.id.pic);
        ca=(EditText)findViewById(R.id.cat) ;
        db= dbHelper.getWritableDatabase();
        val1= ca.getText().toString();
        val2= tw.getText().toString();
        val3= ew.getText().toString();
        val4= ts.getText().toString();
        val5= es.getText().toString();
        val6= pi.getText().toString();

        ContentValues values = new ContentValues();
        values.put (DatabaseContract.Learning.Category, val1);
        values.put (DatabaseContract.Learning.T_word, val2);
        values.put (DatabaseContract.Learning.E_word, val3);
        values.put (DatabaseContract.Learning.T_sentence, val4);
        values.put (DatabaseContract.Learning.E_Sentence, val5);
        values.put (DatabaseContract.Learning.audio, val6);

        long newRowId = db.insert(TABLE_NAME, null, values);
        if(newRowId>0)
        {
            Toast.makeText(this, "New Record Inserted: " + newRowId, Toast.LENGTH_SHORT).show();
            tw.setText("");
            ew.setText("");
            ts.setText("");
            pi.setText("");
            es.setText("");
        }
    }
    public void back (View v)
    {
        Intent in= new Intent(this, adminOptions.class);
        startActivity(in);
    }
    public void reLoad(View v)
    {
        tw.setText("");
        ew.setText("");
        ts.setText("");
        pi.setText("");
        es.setText("");
    }
}
