package com.example.ledyakmadeneme;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_Daire5 extends AppCompatActivity {
    Button kirmiziac5,kirmizikapat5;
    Button yesilac5,yesilkapat5;
    Button maviac5,mavikapat5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__daire5);
        kirmiziac5= (Button) findViewById(R.id.kirmiziac5);
        kirmizikapat5= (Button) findViewById(R.id.kirmizikapat5);
        yesilac5 = (Button) findViewById(R.id.yesilac5);
        yesilkapat5 = (Button) findViewById(R.id.yesilkapat5);
        maviac5 = (Button) findViewById(R.id.maviac5);
        mavikapat5 = (Button) findViewById(R.id.mavikapat5);


        kirmiziac5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("red");
                myRef.setValue(100);

            }
        });
        kirmizikapat5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("red");
                myRef.setValue(0);
            }
        });

        yesilac5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("green");
                myRef.setValue(100);
            }
        });
        yesilkapat5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("green");
                myRef.setValue(0);
            }
        });
        maviac5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("blue");
                myRef.setValue(100);
            }
        }); mavikapat5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("blue");
                myRef.setValue(0);
            }
        });
    }
}