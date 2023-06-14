package com.fieb.mercado;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAddProdPg,btnListProdPg,btnRegisterPg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddProdPg = findViewById(R.id.btnAddProdPg);
        btnListProdPg = findViewById(R.id.btnListProdPg);
        btnRegisterPg = findViewById(R.id.btnRegisterPg);
    }

    public void setBtnAddProdPg(View v){
            Intent intent = new Intent(MainActivity.this, produtos_add.class);
            startActivity(intent);
    }

    public void setBtnListProdPg(View v){
        Intent intent = new Intent(MainActivity.this, Listar.class);
        startActivity(intent);
    }

    public void setBtnRegisterPg(View v){
        Intent intent = new Intent(MainActivity.this, Register.class);
        startActivity(intent);
    }

    public void setBtnLoginPg(View v){
        Intent intent = new Intent(MainActivity.this, Login.class);
        startActivity(intent);
    }

}