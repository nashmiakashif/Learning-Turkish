package com.example.project4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class viewRatingTable extends AppCompatActivity {
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_rating_table);
        setTitle("Learnish");
        Intent intent = getIntent();
        dbHelper = new DatabaseHelper(this);
        t= (TextView)findViewById(R.id.avg);
        db = dbHelper.getReadableDatabase();
        List<String> usersList = new ArrayList();
        Intent i1=getIntent();
        final String[] columns = { DatabaseContract.Rate.EMAIL,DatabaseContract.Rate.RATING };
        String sortOrder = DatabaseContract.Rate.EMAIL + " ASC";
        Cursor c = db.query(DatabaseContract.Rate.TABLE_NAME, null, null, null, null, null, sortOrder);
        int i =1;
        int  sum=0;

        while (c.moveToNext()) {

            String Email= c.getString(0) ;
            String Rate= c.getString(1);
            usersList.add(i +"-       "+Email+"     "+Rate );
            i++;
        }
        int rate =getSumValue();
        int avg =rate/c.getCount();
        t.append(" "+avg);
        ListView lv=(ListView) findViewById(R.id.list1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, usersList);
        lv.setAdapter(adapter);
        c.close();

    }
    public int getSumValue(){
        int sum=0;
        db=dbHelper.getReadableDatabase();
        String sumQuery=String.format("SELECT SUM(%s) as Total FROM %s",DatabaseContract.Rate.RATING,DatabaseContract.Rate.TABLE_NAME);
        Cursor cursor=db.rawQuery(sumQuery,null);
        if(cursor.moveToFirst())
            sum= cursor.getInt(cursor.getColumnIndex("Total"));
        return sum;
    }
}
