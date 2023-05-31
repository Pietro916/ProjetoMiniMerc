package com.fieb.mercado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class produtos_add extends AppCompatActivity {

    EditText nomeV,descricaoV,quantidadeV,precoV,imageV;
    Button addProd = findViewById(R.id.btnAddProd);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos_add);

        nomeV = findViewById(R.id.nome);
        descricaoV = findViewById(R.id.descricao);
        quantidadeV = findViewById(R.id.quantidade);
        precoV = findViewById(R.id.preco);
        imageV = findViewById(R.id.image);
    }

    public void addProd (View v){
        String nome = nomeV.getText().toString();
        String descricao = descricaoV.getText().toString();
        String image = imageV.getText().toString();
        Double preco = Double.valueOf(precoV.getText().toString());
        int quantidade = Integer.parseInt(quantidadeV.getText().toString());

        DatabaseManager.insertData(descricao,preco,quantidade,nome,image);
    }
}
