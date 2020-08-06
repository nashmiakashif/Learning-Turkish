package com.example.project4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.project4.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class viewUsersTable extends AppCompatActivity {
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users_table);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getReadableDatabase();
        setTitle("Learnish");
        List<String> usersList = new ArrayList();
        Intent i1=getIntent();
        final String[] columns = { DatabaseContract.Users.PASSWORD, DatabaseContract.Users.EMAIL,
                DatabaseContract.Users.AGE, DatabaseContract.Users.NAME};
        String sortOrder = DatabaseContract.Users.EMAIL + " ASC";
        Cursor c = db.query(DatabaseContract.Users.TABLE_NAME, null, null, null, null, null, sortOrder);
        int i =1;
        while (c.moveToNext()) {

            String Name =c.getString(2);
            String Email= c.getString(1) ;
            String Age= c.getString(3);
            usersList.add(i +"-     "+ Name+"        "+Email+"     "+Age );
            i++;
        }
        ListView lv=(ListView) findViewById(R.id.list1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, usersList);
        lv.setAdapter(adapter);

        c.close();
    }
}

