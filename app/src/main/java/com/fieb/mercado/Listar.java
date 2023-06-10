package com.fieb.mercado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Listar extends AppCompatActivity {
    public ListView listProdutosr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        listProdutosr = (ListView) findViewById(R.id.listProdutos);
        listar();
    }

    public void listar(){
        try {
            ListView listProdutos = listProdutosr;
            DatabaseManager.listProducts(listProdutos);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}