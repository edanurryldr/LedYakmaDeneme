package com.example.ledyakmadeneme;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_Daire6 extends AppCompatActivity {
    Button kirmiziac6,kirmizikapat6;
    Button yesilac6,yesilkapat6;
    Button maviac6,mavikapat6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__daire6);
        kirmiziac6= (Button) findViewById(R.id.kirmiziac6);
        kirmizikapat6= (Button) findViewById(R.id.kirmizikapat6);
        yesilac6 = (Button) findViewById(R.id.yesilac6);
        yesilkapat6 = (Button) findViewById(R.id.yesilkapat6);
        maviac6 = (Button) findViewById(R.id.maviac6);
        mavikapat6 = (Button) findViewById(R.id.mavikapat6);


        kirmiziac6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("red");
                myRef.setValue(100);

            }
        });
        kirmizikapat6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("red");
                myRef.setValue(0);
            }
        });

        yesilac6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("green");
                myRef.setValue(100);
            }
        });
        yesilkapat6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("green");
                myRef.setValue(0);
            }
        });
        maviac6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("blue");
                myRef.setValue(100);
            }
        }); mavikapat6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("blue");
                myRef.setValue(0);
            }
        });
    }
}