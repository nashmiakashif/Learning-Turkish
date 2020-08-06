package com.example.project4;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;
public class quiz7 extends AppCompatActivity {
    TextView t1,t2,t3,w1,w2,w3;
    Button c1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz7);
        t1= (TextView)findViewById(R.id.t1);
        t2= (TextView)findViewById(R.id.t2);
        t3= (TextView)findViewById(R.id.t3);
        w1= (TextView)findViewById(R.id.w1);
        w2= (TextView)findViewById(R.id.w2);
        w3= (TextView)findViewById(R.id.w3);
        c1= (Button)findViewById(R.id.ch);
    }
    public void check1 (View v)
    {
        c1.setVisibility(View.VISIBLE);
        t3.setText(w1.getText().toString());
    }

    public void check2 (View v)
    {
        c1.setVisibility(View.VISIBLE);
        t3.setText(w2.getText().toString());
    }

    public void check3 (View v)

    {
        c1.setVisibility(View.VISIBLE);
        t3.setText(w3.getText().toString());
    }

    public void check (final View v)
    {
        if(t3.getText().toString().equalsIgnoreCase("Seyhat etmek"))
        {
            MediaPlayer media = MediaPlayer.create(quiz7.this,R.raw.right);
            media.start();
            t1.setText("Your are Correct ");
            t1.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.tick,
                    0,//left
                    0, //top
                    0);
            w1.setText("");
            w2.setText("");
            w3.setText("");
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            t3.setTextColor(Color.GREEN);
            next(v);


        }
        else
        {
            MediaPlayer media = MediaPlayer.create(quiz7.this,R.raw.wrong);
            media.start();
            t1.setText("Sorry incorrect Solution");
            t1.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.cross,
                    0,//left
                    0, //top
                    0);
            Toast.makeText(this, "InCorrect", Toast.LENGTH_SHORT).show();
            t3.setTextColor(Color.RED);
            w2.setText("");
            w3.setText("");
            w1.setText("Correct Solution \n Seyhat etmek.");
            next(v);
        }
    }
    public void next (View v)
    {
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                Intent intent = new Intent(quiz7.this, quiz8.class);
                startActivity(intent);
            }
        }, 1200);
    }
    @Override
    protected void onStart() {
        super.onStart();
        MediaPlayer media = MediaPlayer.create(quiz7.this,R.raw.seyahat);
        media.start();
        ImageView im = (ImageView)findViewById(R.id.aud);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer media = MediaPlayer.create(quiz7.this,R.raw.seyahat);
                media.start();
            }
        });

    }
}