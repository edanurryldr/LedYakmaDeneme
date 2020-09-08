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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Activity_Daire1 extends AppCompatActivity {
    Button kirmiziac,kirmizikapat;
    Button yesilac,yesilkapat;
    Button maviac,mavikapat;
    Button kaydet;

    EditText ed_username,ed_tel,ed_email;

    FirebaseAuth daireyetki;
    DatabaseReference daireyol;
    ProgressDialog pd1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daire1);

        ed_email=(EditText)findViewById(R.id.ed_email);
        ed_tel=(EditText)findViewById(R.id.ed_tel);
        ed_username=(EditText)findViewById(R.id.ed_username);
        kirmiziac= (Button) findViewById(R.id.kirmiziac);
        kirmizikapat= (Button) findViewById(R.id.kirmizikapat);
        kaydet=(Button)findViewById(R.id.kaydet);
        yesilac = (Button) findViewById(R.id.yesilac);
        yesilkapat = (Button) findViewById(R.id.yesilkapat);
        maviac = (Button) findViewById(R.id.maviac);
        mavikapat = (Button) findViewById(R.id.mavikapat);

        daireyetki=FirebaseAuth.getInstance();


        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd1=new ProgressDialog(Activity_Daire1.this);
                pd1.setMessage("Lütfen Bekleyiniz...");
                pd1.show();

                String str_Kullaniciadi=ed_username.getText().toString();
                String str_Tel=ed_tel.getText().toString();
                String str_Mail=ed_email.getText().toString();

                if(TextUtils.isEmpty(str_Kullaniciadi)||TextUtils.isEmpty(str_Tel)||TextUtils.isEmpty(str_Mail)){
                    Toast.makeText(Activity_Daire1.this,"Lütfen bütün alanları doldurun...",Toast.LENGTH_SHORT).show();
                }
                else{
                    //Yeni kullanıcı kaydetme kodları çağır

                    musterikaydet(str_Kullaniciadi,str_Mail,str_Tel);

                }


            }
        });

    }
    private void musterikaydet(final String kullaniciadi1, final String mail,String tel){
        //Yeni kullanıcı kaydetme kodları
        daireyetki.createUserWithEmailAndPassword(mail,tel).addOnCompleteListener(Activity_Daire1.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){

                    FirebaseUser firebaseKullanici = daireyetki.getCurrentUser();

                    String kullaniciId = firebaseKullanici.getUid();

                    daireyol = FirebaseDatabase.getInstance().getReference().child("Daire 1 Müşteri Bilgileri").child(kullaniciId);

                    HashMap<String,Object> hashMap = new HashMap<>();

                    hashMap.put("id",kullaniciId);
                    hashMap.put("kullaniciadi",kullaniciadi1.toLowerCase());
                    hashMap.put("mail",mail);
                    hashMap.put("resimurl","https://firebasestorage.googleapis.com/v0/b/ledyakmadeneme.appspot.com/o/placeholder.png?alt=media&token=aefd78a5-ca4c-4a7f-a0f1-fced0088d49a");


                    daireyol.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()){
                                pd1.dismiss();

                                Intent intent =new Intent(Activity_Daire1.this,Activity_Login.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                        }
                    });
                }
                else{
                    pd1.dismiss();
                    Toast.makeText(Activity_Daire1.this,"Kaydınız alınmıştır...",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
