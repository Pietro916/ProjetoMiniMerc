package com.fieb.mercado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText emailr,senhar,cnpjr,cpfr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        emailr = findViewById(R.id.email);
        senhar = findViewById(R.id.senha);
        cnpjr = findViewById(R.id.cnpj);
        cpfr = findViewById(R.id.cpf);
    }

    public void addAdm(View v){
        String email = emailr.getText().toString();
        String senha = senhar.getText().toString();
        int cnpj = Integer.parseInt(cnpjr.getText().toString());
        int cpf = Integer.parseInt(cpfr.getText().toString());

        DatabaseManager.insertCadastro(email,senha,cnpj,cpf);
        voltar();
    }

    public void voltar(){
        Intent intent = new Intent(Register.this, MainActivity.class);
        startActivity(intent);
    }
}