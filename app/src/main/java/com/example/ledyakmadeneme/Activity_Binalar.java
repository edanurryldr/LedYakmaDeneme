package com.example.ledyakmadeneme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Binalar extends AppCompatActivity {
Button daire1,daire2,daire3,daire4,daire5,daire6,daire7,daire8,kaydet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__binalar);
        daire1=(Button)findViewById(R.id.daire1);
        daire2=(Button)findViewById(R.id.daire2);
        daire3=(Button)findViewById(R.id.daire3);
        daire4=(Button)findViewById(R.id.daire4);
        daire5=(Button)findViewById(R.id.daire5);
        daire6=(Button)findViewById(R.id.daire6);
        daire7=(Button)findViewById(R.id.daire7);
        daire8=(Button)findViewById(R.id.daire8);

        daire1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_Binalar.this,Activity_Daire1.class);
                startActivity(i);
            }
        });
        daire2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_Binalar.this,Activity_Daire2.class);
                startActivity(i);
            }
        });daire3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_Binalar.this,Activity_Daire3.class);
                startActivity(i);
            }
        });daire4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_Binalar.this,Activity_Daire4.class);
                startActivity(i);
            }
        });daire5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_Binalar.this,Activity_Daire5.class);
                startActivity(i);
            }
        });daire6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_Binalar.this,Activity_Daire6.class);
                startActivity(i);
            }
        });daire7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_Binalar.this,Activity_Daire7.class);
                startActivity(i);
            }
        });daire8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_Binalar.this,Activity_Daire8.class);
                startActivity(i);
            }
        });

    }
}