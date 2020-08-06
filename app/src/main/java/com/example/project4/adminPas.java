package com.example.project4;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class adminPas extends AppCompatActivity {
    Button b1;
    EditText em, pas;
    TextView aa;
    String ema, pasa;
    ProgressDialog process;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_pas);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        b1=(Button)findViewById(R.id.subm);
        Intent intent = getIntent();
        em=(EditText)findViewById(R.id.em);
        pas=(EditText)findViewById(R.id.pass);
        aa=(TextView)findViewById(R.id.aa);
        setTitle("Learnish");
    }
    public void signin(View v)
    {
        ema=em.getText().toString();
        pasa=pas.getText().toString();
        if(ema.length()>0 && pasa.length()>0) {
            if (ema.equalsIgnoreCase("namra.9678@gmail.com")) {
                if (pasa.equals("namra123")) {
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
                    Intent i = new Intent(this, adminOptions.class);
                    startActivity(i);
                } else {
                    pas.setText("");
                    aa.setText("Incorrect Password: try again");
                }
            } else {
                em.setText("");
                aa.setText("Incorrect Email: try again");
            }
        }
        else
            Toast.makeText(getApplicationContext(),"fill both fields",Toast.LENGTH_SHORT).show();
    }
    public void reLoad(View v)
    {
        em.setText("");
        pas.setText("");
        aa.setText("");
    }
}

