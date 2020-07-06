package com.example.ledyakmadeneme;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    Button kirmiziac,kirmizikapat;
    Button yesilac,yesilkapat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kirmiziac= (Button) findViewById(R.id.kirmiziac);
        kirmizikapat= (Button) findViewById(R.id.kirmizikapat);
        yesilac = (Button) findViewById(R.id.yesilac);
        yesilkapat = (Button) findViewById(R.id.yesilkapat);


       kirmiziac.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FirebaseDatabase database = FirebaseDatabase.getInstance();
               DatabaseReference myRef = database.getReference("red");
               myRef.setValue(100);
           }
       });
       kirmizikapat.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FirebaseDatabase database = FirebaseDatabase.getInstance();
               DatabaseReference myRef = database.getReference("red");
               myRef.setValue(0);
           }
       });

       yesilac.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FirebaseDatabase database = FirebaseDatabase.getInstance();
               DatabaseReference myRef = database.getReference("green");
               myRef.setValue(100);
           }
       });
       yesilkapat.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FirebaseDatabase database = FirebaseDatabase.getInstance();
               DatabaseReference myRef = database.getReference("green");
               myRef.setValue(0);
           }
       });
    }
}