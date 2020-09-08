package com.example.ledyakmadeneme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Category extends AppCompatActivity {

    @Override

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
    }

    public void binalar(View view) {
        Intent intent=new Intent(getApplicationContext(),Activity_Bloklar.class);
        startActivity(intent);
    }

    public void cikis(View view) { Intent intent=new Intent(getApplicationContext(),Activity_Login.class);
        startActivity(intent);
    }

    public void hakkimizda(View view) { Intent intent=new Intent(getApplicationContext(),Activity_Hakkimizda.class);
        startActivity(intent);
    }

    public void animasyon(View view) { Intent intent=new Intent(getApplicationContext(),Activity_Animasyon.class);
        startActivity(intent);
    }

    public void satilandaireler(View view) { Intent intent=new Intent(getApplicationContext(),Activity_SatilanDaireler.class);
        startActivity(intent);
    }

    public void menu(View view) { Intent intent=new Intent(getApplicationContext(),Activity_Menu.class);
        startActivity(intent);
    }
}
