package com.example.ledyakmadeneme;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_Daire3 extends AppCompatActivity {
    Button kirmiziac3,kirmizikapat3;
    Button yesilac3,yesilkapat3;
    Button maviac3,mavikapat3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__daire3);
        kirmiziac3= (Button) findViewById(R.id.kirmiziac3);
        kirmizikapat3= (Button) findViewById(R.id.kirmizikapat3);
        yesilac3= (Button) findViewById(R.id.yesilac3);
        yesilkapat3 = (Button) findViewById(R.id.yesilkapat3);
        maviac3 = (Button) findViewById(R.id.maviac3);
        mavikapat3 = (Button) findViewById(R.id.mavikapat3);


        kirmiziac3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("red");
                myRef.setValue(100);

            }
        });
        kirmizikapat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("red");
                myRef.setValue(0);
            }
        });

        yesilac3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("green");
                myRef.setValue(100);
            }
        });
        yesilkapat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("green");
                myRef.setValue(0);
            }
        });
        maviac3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("blue");
                myRef.setValue(100);
            }
        }); mavikapat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("blue");
                myRef.setValue(0);
            }
        });
    }
}