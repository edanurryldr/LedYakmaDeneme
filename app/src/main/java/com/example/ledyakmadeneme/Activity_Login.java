package com.example.ledyakmadeneme;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Activity_Login extends AppCompatActivity {

    EditText ed_email,ed_password;
    Button btngiris,btnkayitol,btnunuttum;

    FirebaseAuth girisYetkisi;

    @Override

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btngiris = (Button) findViewById(R.id.btn_girisyap);
        btnkayitol = (Button) findViewById(R.id.btn_kayitol);
        btnunuttum = (Button) findViewById(R.id.btn_unuttum);
        ed_password = (EditText) findViewById(R.id.edt_password);
        ed_email = (EditText) findViewById(R.id.edt_email);

        girisYetkisi=FirebaseAuth.getInstance();


btnkayitol.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(Activity_Login.this,ActivitySignup.class));
    }
});

btngiris.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final ProgressDialog pdGiris=new ProgressDialog(Activity_Login.this);
        pdGiris.setMessage("Giriş Yapılıyor...");
        pdGiris.show();

        String str_emailGiris= ed_email.getText().toString();
        String str_sifreGiris= ed_password.getText().toString();

        if (TextUtils.isEmpty(str_emailGiris)||TextUtils.isEmpty(str_sifreGiris)){
            Toast.makeText(Activity_Login.this,"Lütfen bütün alanları doldurun",Toast.LENGTH_LONG).show();
        }
        else{
            //Giriş yapma kodları

            girisYetkisi.signInWithEmailAndPassword(str_emailGiris,str_sifreGiris).addOnCompleteListener(Activity_Login.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        DatabaseReference yolGiris= FirebaseDatabase.getInstance().getReference()
                                .child("Kullanıcılar").child(girisYetkisi.getCurrentUser().getUid());

                        yolGiris.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                pdGiris.dismiss();

                                Intent intent = new Intent(Activity_Login.this,Activity_Category.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                                pdGiris.dismiss();
                            }
                        });
                    }else
                    {
                        pdGiris.dismiss();
                        Toast.makeText(Activity_Login.this,"Giriş başarısız oldu.Kayıt yapmanız gerekmektedir",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }
});

    }

}
