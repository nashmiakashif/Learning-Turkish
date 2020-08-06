package com.example.project4;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Information extends AppCompatActivity {
    TextView ca,tw,ew,ts,es;
    ImageView au;
    String s1,s2,s3,s4,s5,s6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        setTitle("Information");
        setTitle("Learnish");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i = getIntent();
        s1=i.getStringExtra("Category");
        s2=i.getStringExtra("E_Word");
        s3=i.getStringExtra("T_Word");
        s4=i.getStringExtra("E_Sentence");
        s5=i.getStringExtra("T_Sentence");
        s6=i.getStringExtra("audio");
        ca= (TextView)findViewById(R.id.cate);
        tw= (TextView)findViewById(R.id.Tword);
        ew= (TextView)findViewById(R.id.Eword);
        ts= (TextView)findViewById(R.id.Tsen);
        es= (TextView)findViewById(R.id.Esen);
        au=(ImageView)findViewById(R.id.aud);
        ca.setText(s1);
        ew.setText(s2);
        tw.setText(s3);
        ts.setText(s5);
        es.setText(s4);
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
                startActivity(fb);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
    public int play (View v)
    {

        if(s6.equalsIgnoreCase("excuseme"))
            return R.raw.excuseme;
        if(s6.equalsIgnoreCase("goodbyeformal"))
            return R.raw.goodbyeformal;
        if(s6.equalsIgnoreCase("goodbye"))
            return R.raw.goodbye;
        if(s6.equalsIgnoreCase("goodday"))
            return R.raw.goodday;
        if(s6.equalsIgnoreCase("goodevening"))
            return R.raw.goodevening;
        if(s6.equalsIgnoreCase("goodmorning"))
            return R.raw.goodmorning;
        if(s6.equalsIgnoreCase("goodnight"))
            return R.raw.goodnight;
        if(s6.equalsIgnoreCase("hello"))
            return R.raw.hello;
        if(s6.equalsIgnoreCase("howareyou"))
            return R.raw.howareyou;
        if(s6.equalsIgnoreCase("iamfinethankyou"))
            return R.raw.iamfinethankyou;
        if(s6.equalsIgnoreCase("ok"))
            return R.raw.ok;
        if(s6.equalsIgnoreCase("pleasedtomeetyou"))
            return R.raw.pleasedtomeetyou;
        if(s6.equalsIgnoreCase("pleasetomeetyoutoo"))
            return R.raw.pleasetomeetyoutoo;
        if(s6.equalsIgnoreCase("sorry"))
            return R.raw.sorry;
        if(s6.equalsIgnoreCase("brother"))
            return R.raw.brother;
        if(s6.equalsIgnoreCase("daughter"))
            return R.raw.daughter;
        if(s6.equalsIgnoreCase("elderbrother"))
            return R.raw.elderbrother;
        if(s6.equalsIgnoreCase("eldersister"))
            return R.raw.eldersister;
        if(s6.equalsIgnoreCase("father"))
            return R.raw.father;
        if(s6.equalsIgnoreCase("grandchild"))
            return R.raw.grandchild;
        if(s6.equalsIgnoreCase("grandfather"))
            return R.raw.grandfather;
        if(s6.equalsIgnoreCase("grandmother"))
            return R.raw.grandmother;
        if(s6.equalsIgnoreCase("husband"))
            return R.raw.husband;
        if(s6.equalsIgnoreCase("mother"))
            return R.raw.mother;
        if(s6.equalsIgnoreCase("sister"))
            return R.raw.sister;
        if(s6.equalsIgnoreCase("son"))
            return R.raw.son;
        if(s6.equalsIgnoreCase("spouse"))
            return R.raw.spouse;
        if(s6.equalsIgnoreCase("wife"))
            return R.raw.wife;
        if(s6.equalsIgnoreCase("canyouhelpme"))
            return R.raw.canyouhelpme;
        if(s6.equalsIgnoreCase("hello"))
            return R.raw.hello;
        if(s6.equalsIgnoreCase("howareyou"))
            return R.raw.howareyou;
        if(s6.equalsIgnoreCase("iamfinethankyou"))
            return R.raw.iamfinethankyou;
        if(s6.equalsIgnoreCase("iamlearningturkish"))
            return R.raw.iamlearningturkish;
        if(s6.equalsIgnoreCase("idontunderstand"))
            return R.raw.idontunderstand;
        if(s6.equalsIgnoreCase("ispeakenglish"))
            return R.raw.ispeakenglish;
        if(s6.equalsIgnoreCase("iunderstand"))
            return R.raw.iunderstand;
        if(s6.equalsIgnoreCase("mynameis"))
            return R.raw.mynameis;
        if(s6.equalsIgnoreCase("no"))
            return R.raw.no;
        if(s6.equalsIgnoreCase("please"))
            return R.raw.please;
        if(s6.equalsIgnoreCase("pleasedtomeetyou"))
            return R.raw.pleasedtomeetyou;
        if(s6.equalsIgnoreCase("pleasedtomeetyoutoo"))
            return R.raw.pleasetomeetyoutoo;
        if(s6.equalsIgnoreCase("seeyou"))
            return R.raw.seeyou;
        if(s6.equalsIgnoreCase("thankyou"))
            return R.raw.welcome;
        if(s6.equalsIgnoreCase("theweatherisreallynicetoday"))
            return R.raw.theweatherisreallynicetoday;
        if(s6.equalsIgnoreCase("whatdoesthismean"))
            return R.raw.whatdoesthismean;
        if(s6.equalsIgnoreCase("whatisthis"))
            return R.raw.whatisthis;
        if(s6.equalsIgnoreCase("whatisyourname"))
            return R.raw.whatisyourname;
        if(s6.equalsIgnoreCase("yes"))
            return R.raw.yes;
        if(s6.equalsIgnoreCase("yourwelcome"))
            return R.raw.yourwelcome;
        if(s6.equalsIgnoreCase("congratulations"))
            return R.raw.congratulations;
        if(s6.equalsIgnoreCase("eidmubarak"))
            return R.raw.eidmubarak;
        if(s6.equalsIgnoreCase("enjoyyourmeal"))
            return R.raw.enjoyyourmeal;
        if(s6.equalsIgnoreCase("getwellsoon"))
            return R.raw.getwellsoon;
        if(s6.equalsIgnoreCase("happyeid"))
            return R.raw.happyeid;
        if(s6.equalsIgnoreCase("jumahmubarak"))
            return R.raw.jumahmubarak;
        if(s6.equalsIgnoreCase("mayallahhavemercyonhissoul"))
            return R.raw.mayallahhavemercyonhissoul;
        if(s6.equalsIgnoreCase("ramadanmubarak"))
            return R.raw.ramadanmubarak;
        if(s6.equalsIgnoreCase("0"))
            return R.raw.n0;
        if(s6.equalsIgnoreCase("1"))
            return R.raw.n1;
        if(s6.equalsIgnoreCase("2"))
            return R.raw.n2;
        if(s6.equalsIgnoreCase("3"))
            return R.raw.n3;
        if(s6.equalsIgnoreCase("4"))
            return R.raw.n4;
        if(s6.equalsIgnoreCase("5"))
            return R.raw.n5;
        if(s6.equalsIgnoreCase("6"))
            return R.raw.n6;
        if(s6.equalsIgnoreCase("7"))
            return R.raw.n7;
        if(s6.equalsIgnoreCase("8"))
            return R.raw.n8;
        if(s6.equalsIgnoreCase("9"))
            return R.raw.n9;
        if(s6.equalsIgnoreCase("10"))
            return R.raw.n10;
        if(s6.equalsIgnoreCase("20"))
            return R.raw.n20;
        if(s6.equalsIgnoreCase("30"))
            return R.raw.n30;
        if(s6.equalsIgnoreCase("40"))
            return R.raw.n40;
        if(s6.equalsIgnoreCase("50"))
            return R.raw.n50;
        if(s6.equalsIgnoreCase("60"))
            return R.raw.n60;
        if(s6.equalsIgnoreCase("70"))
            return R.raw.n70;
        if(s6.equalsIgnoreCase("80"))
            return R.raw.n80;
        if(s6.equalsIgnoreCase("90"))
            return R.raw.n90;
        if(s6.equalsIgnoreCase("100"))
            return R.raw.n100;
        if(s6.equalsIgnoreCase("1000"))
            return R.raw.n1000;
        if(s6.equalsIgnoreCase("1000000"))
            return R.raw.n1000000;
        if(s6.equalsIgnoreCase("1000000000"))
            return R.raw.n1000000000;
        if(s6.equalsIgnoreCase("enjoyyourmeal"))
            return R.raw.enjoyyourmeal;
        if(s6.equalsIgnoreCase("beef"))
            return R.raw.beef;
        if(s6.equalsIgnoreCase("bread"))
            return R.raw.bread;
        if(s6.equalsIgnoreCase("breakfast"))
            return R.raw.breakfast;
        if(s6.equalsIgnoreCase("chicken"))
            return R.raw.chicken;
        if(s6.equalsIgnoreCase("coffee"))
            return R.raw.coffee;
        if(s6.equalsIgnoreCase("dessert"))
            return R.raw.dessert;
        if(s6.equalsIgnoreCase("dinner"))
            return R.raw.dinner;
        if(s6.equalsIgnoreCase("drink"))
            return R.raw.drink;
        if(s6.equalsIgnoreCase("fish"))
            return R.raw.fish;
        if(s6.equalsIgnoreCase("food"))
            return R.raw.food;
        if(s6.equalsIgnoreCase("fork"))
            return R.raw.fork;
        if(s6.equalsIgnoreCase("knife"))
            return R.raw.knife;
        if(s6.equalsIgnoreCase("lunch"))
            return R.raw.lunch;
        if(s6.equalsIgnoreCase("meat"))
            return R.raw.meat;
        if(s6.equalsIgnoreCase("plate"))
            return R.raw.plate;
        if(s6.equalsIgnoreCase("rice"))
            return R.raw.rice;
        if(s6.equalsIgnoreCase("salad"))
            return R.raw.salad;
        if(s6.equalsIgnoreCase("soup"))
            return R.raw.soup;
        if(s6.equalsIgnoreCase("sugar"))
            return R.raw.sugar;
        if(s6.equalsIgnoreCase("tea"))
            return R.raw.tea;
        if(s6.equalsIgnoreCase("water"))
        return R.raw.water;


        else
            return R.raw.wrong;
    }
    public void playButton(View v)
    {
        int t=play(v);
        MediaPlayer media = MediaPlayer.create(Information.this,t);
        media.start();
    }
}
