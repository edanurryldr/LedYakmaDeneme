package com.example.ledyakmadeneme;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class ActivitySignup extends AppCompatActivity {

    Button btn_signup;
    EditText ed_password,ed_email;
    TextView tx_yenihesap;

    FirebaseAuth yetki;
    DatabaseReference yol;

    ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);

        btn_signup=(Button)findViewById(R.id.btn_signup);
        ed_password=(EditText)findViewById(R.id.ed_password);
        ed_email=(EditText)findViewById(R.id.ed_email);
        tx_yenihesap=(TextView)findViewById(R.id.tx_yenihesap);

        yetki=FirebaseAuth.getInstance();



tx_yenihesap.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
     startActivity(new Intent(ActivitySignup.this,Activity_Login.class));
    }
});
    btn_signup.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            pd=new ProgressDialog(ActivitySignup.this);
            pd.setMessage("Lütfen Bekleyiniz...");
            pd.show();


            String str_Sifre=ed_password.getText().toString();
            String str_Mail=ed_email.getText().toString();

            if(TextUtils.isEmpty(str_Sifre)||TextUtils.isEmpty(str_Mail)){
                Toast.makeText(ActivitySignup.this,"Lütfen bütün alanları doldurun...",Toast.LENGTH_SHORT).show();
            }
            else if(str_Sifre.length()<6){
                Toast.makeText(ActivitySignup.this,"Şifreniz minimum 6 karakter olmalı...",Toast.LENGTH_SHORT).show();
            }
            else{
                //Yeni kullanıcı kaydetme kodları çağır

                kaydet(str_Sifre,str_Mail);

            }


        }
    });

    }
    private void kaydet(final String mail, String sifre){
        //Yeni kullanıcı kaydetme kodları
        yetki.createUserWithEmailAndPassword(mail,sifre).addOnCompleteListener(ActivitySignup.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){

                    FirebaseUser firebaseKullanici = yetki.getCurrentUser();

                    String kullaniciId = firebaseKullanici.getUid();

                    yol = FirebaseDatabase.getInstance().getReference().child("Kullanıcılar").child(kullaniciId);

                    HashMap<String,Object> hashMap = new HashMap<>();

                    hashMap.put("id",kullaniciId);
                    hashMap.put("mail",mail);
                    hashMap.put("resimurl","https://firebasestorage.googleapis.com/v0/b/ledyakmadeneme.appspot.com/o/placeholder.png?alt=media&token=aefd78a5-ca4c-4a7f-a0f1-fced0088d49a");
                    yol.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()){
                                pd.dismiss();

                                Intent intent =new Intent(ActivitySignup.this,Activity_Login.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);

                            }
                        }
                    });
                }
                else{
        pd.dismiss();
        Toast.makeText(ActivitySignup.this,"Bu mail veya şifre ile kayıt başarısız...",Toast.LENGTH_LONG).show();
    }

}
        });

    }


}
