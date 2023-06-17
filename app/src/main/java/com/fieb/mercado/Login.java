package com.fieb.mercado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText emailr,senhar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailr = findViewById(R.id.emailL);
        senhar = findViewById(R.id.senhaL);
    }

    public void login(View v){
        String email = emailr.getText().toString();
        String senha = senhar.getText().toString();

        if(DatabaseManager.login(email,senha)){
            ir();
        };
    }

    public void ir(){
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
    }

    public void setBtnRegisterPg(View v){
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }
}