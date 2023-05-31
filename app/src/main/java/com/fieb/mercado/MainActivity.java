package com.fieb.mercado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAddProdPg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddProdPg = findViewById(R.id.btnAddProdPg);
    }

    public void setBtnAddProdPg(View v){
        Intent intent = new Intent(MainActivity.this, produtos_add.class);
        startActivity(intent);
        finish();
    }

}