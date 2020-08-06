package com.example.project4;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class words extends AppCompatActivity {
    String category;
    ListView l1;
    ArrayAdapter<String> adapter;
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    String email;
    String Eword,Tword,Tsen,Esen,Category,aud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);
        setTitle("Learnish");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dbHelper = new DatabaseHelper(this);
        final List<String> usersList = new ArrayList();
        Intent g= getIntent();
        email=g.getStringExtra("email");
        category= g.getStringExtra("Category");
        l1 = (ListView) findViewById(R.id.list1);
        db = dbHelper.getWritableDatabase();

        final String[] columns = {DatabaseContract.Learning.Category,DatabaseContract.Learning.T_word,DatabaseContract.Learning.E_word,DatabaseContract.Learning.T_sentence,DatabaseContract.Learning.E_Sentence,DatabaseContract.Learning.audio};

        Cursor c = db.query(DatabaseContract.Learning.TABLE_NAME, null, null, null, null, null, null);

        while (c.moveToNext()) {
            final String name1 = c.getString(0);
            if (name1.equalsIgnoreCase(category)) {
                usersList.add(c.getString(2));
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, usersList);
        l1.setAdapter(adapter);
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(getApplicationContext(), "You Clicked: " + usersList.get(position), Toast.LENGTH_SHORT).show();
                Cursor c = db.query(DatabaseContract.Learning.TABLE_NAME, null, null, null, null, null, null);

                while (c.moveToNext()) {
                    String name1 = c.getString(2);
                    if (name1.equalsIgnoreCase(usersList.get(position))) {
                        Category=name1;
                        Eword=c.getString(1);
                        Tword=c.getString(2);
                        Esen=c.getString(3);
                        Tsen=c.getString(4);
                        aud=c.getString(5);

                    }
                }
                Intent intent = new Intent(words.this, Information.class);
                intent.putExtra("Category",category);
                intent.putExtra("E_Word" ,Eword);
                intent.putExtra("T_Word", Tword);
                intent.putExtra("E_Sentence" ,Esen);
                intent.putExtra("T_Sentence",Tsen);
                intent.putExtra("audio",aud);
                startActivity(intent);

            }

        });
        c.close();
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
                fb.putExtra("email",email);
                startActivity(fb);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}
