package com.example.project4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.project4.DatabaseHelper;
import com.example.project4.R;

import java.util.ArrayList;
import java.util.List;

public class viewLearningTable extends AppCompatActivity {
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_learning_table);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getReadableDatabase();
        setTitle("Learnish");
        List<String> usersList = new ArrayList();
        Intent i1=getIntent();
        final String[] columns = {DatabaseContract.Learning.Category,DatabaseContract.Learning.T_word,DatabaseContract.Learning.E_word,DatabaseContract.Learning.T_sentence,DatabaseContract.Learning.E_Sentence,DatabaseContract.Learning.audio};
        String sortOrder = DatabaseContract.Learning.Category + " ASC";
        Cursor c = db.query(DatabaseContract.Learning.TABLE_NAME, null, null, null, null, null, sortOrder);
        int i =1;
        while (c.moveToNext()) {
            String Category= c.getString(0) ;
            String EWord= c.getString(1);
            usersList.add(i +"- "+Category+"  ---   "+EWord );
            i++;
        }
        ListView lv=(ListView) findViewById(R.id.list1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, usersList);
        lv.setAdapter(adapter);
        c.close();

    }
}
