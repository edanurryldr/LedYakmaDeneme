package com.example.ledyakmadeneme;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_Daire4 extends AppCompatActivity {
    Button kirmiziac4,kirmizikapat4;
    Button yesilac4,yesilkapat4;
    Button maviac4,mavikapat4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__daire4);
        kirmiziac4= (Button) findViewById(R.id.kirmiziac4);
        kirmizikapat4= (Button) findViewById(R.id.kirmizikapat4);
        yesilac4 = (Button) findViewById(R.id.yesilac4);
        yesilkapat4 = (Button) findViewById(R.id.yesilkapat4);
        maviac4 = (Button) findViewById(R.id.maviac4);
        mavikapat4 = (Button) findViewById(R.id.mavikapat4);


        kirmiziac4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("red");
                myRef.setValue(100);

            }
        });
        kirmizikapat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("red");
                myRef.setValue(0);
            }
        });

        yesilac4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("green");
                myRef.setValue(100);
            }
        });
        yesilkapat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("green");
                myRef.setValue(0);
            }
        });
        maviac4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("blue");
                myRef.setValue(100);
            }
        }); mavikapat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("blue");
                myRef.setValue(0);
            }
        });
    }
}