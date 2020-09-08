package com.example.ledyakmadeneme;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_Daire7 extends AppCompatActivity {
    Button kirmiziac7,kirmizikapat7;
    Button yesilac7,yesilkapat7;
    Button maviac7,mavikapat7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__daire7);
        kirmiziac7= (Button) findViewById(R.id.kirmiziac7);
        kirmizikapat7= (Button) findViewById(R.id.kirmizikapat7);
        yesilac7 = (Button) findViewById(R.id.yesilac7);
        yesilkapat7= (Button) findViewById(R.id.yesilkapat7);
        maviac7 = (Button) findViewById(R.id.maviac7);
        mavikapat7 = (Button) findViewById(R.id.mavikapat7);


        kirmiziac7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("red");
                myRef.setValue(100);

            }
        });
        kirmizikapat7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("red");
                myRef.setValue(0);
            }
        });

        yesilac7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("green");
                myRef.setValue(100);
            }
        });
        yesilkapat7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("green");
                myRef.setValue(0);
            }
        });
        maviac7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("blue");
                myRef.setValue(100);
            }
        }); mavikapat7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("blue");
                myRef.setValue(0);
            }
        });
    }
}