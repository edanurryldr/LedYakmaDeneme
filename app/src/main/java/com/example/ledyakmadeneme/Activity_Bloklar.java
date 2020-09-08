package com.example.ledyakmadeneme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Activity_Bloklar extends AppCompatActivity {

    TextView ablok,bblok,cblok,dblok;

    FirebaseAuth blokYetkisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__bloklar);

    ablok=(TextView) findViewById(R.id.ablok);
    bblok=(TextView)findViewById(R.id.bblok);
    cblok=(TextView)findViewById(R.id.cblok);
    dblok=(TextView)findViewById(R.id.dblok);

        blokYetkisi=FirebaseAuth.getInstance();

        ablok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_Bloklar.this,Activity_Binalar.class);
                startActivity(i);

            }
        });
        bblok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_Bloklar.this,Activity_Menu.class);
                startActivity(i);

            }
        }); cblok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_Bloklar.this,Activity_Menu.class);
                startActivity(i);

            }
        }); dblok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_Bloklar.this,Activity_Menu.class);
                startActivity(i);

            }
        });
    }

}
//      DatabaseReference ddRef= FirebaseDatabase.getInstance().getReference().child("Bloklar").child(blokYetkisi.getCurrentUser().getUid());
//             ddRef.addValueEventListener(new ValueEventListener() {
//                 @Override
//                 public void onDataChange(@NonNull DataSnapshot snapshot) {
//                     Intent intent = new Intent(Activity_Bloklar.this,Activity_Daire1.class);
//                     intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                     startActivity(intent);
//                     finish();
//                 }
//
//                 @Override
//                 public void onCancelled(@NonNull DatabaseError error) {
//
//                 }
//             });