package com.fieb.mercado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAddProdPg;
    Button btnListProdPg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddProdPg = findViewById(R.id.btnAddProdPg);
        btnListProdPg = findViewById(R.id.btnListProdPg);
    }

    public void setBtnAddProdPg(View v){
            Intent intent = new Intent(MainActivity.this, produtos_add.class);
            startActivity(intent);
    }

    public void setBtnListProdPg(View v){
        Intent intent = new Intent(MainActivity.this, Listar.class);
        startActivity(intent);
    }

}