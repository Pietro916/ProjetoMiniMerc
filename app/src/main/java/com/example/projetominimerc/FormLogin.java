package com.example.projetominimerc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FormLogin extends AppCompatActivity {

    private TextView text_tela_cadastro;
    private EditText edit_usuario;
    private EditText edit_senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        IniciarComponentes();

        text_tela_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormLogin.this,FormCadastro.class);
                startActivity(intent);
            }
        });

        // Obter referências aos campos de entrada de texto
        edit_usuario = findViewById(R.id.edit_usuario);
        edit_senha = findViewById(R.id.edit_senha);

        // Obter referência ao botão de login
        Button loginButton = findViewById(R.id.bt_entrar);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obter o texto dos campos de entrada de texto
                String username = edit_usuario.getText().toString();
                String password = edit_senha.getText().toString();

                // Verificar se o nome de usuário e senha são válidos
                if (isValidUsername(username) && isValidPassword(password)) {
                    // Navegar para a próxima atividade
                    Intent intent = new Intent(FormLogin.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    // Exibir uma mensagem de erro ao usuário
                    Toast.makeText(FormLogin.this, "Nome de usuário ou senha inválido", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    // Método de verificação para o nome de usuário
    private boolean isValidUsername(String username) {
        // Verificar se o nome de usuário é "admin"
        return username.equals("admin");
    }

    // Método de verificação para a senha
    private boolean isValidPassword(String password) {
        // Verificar se a senha tem pelo menos 6 caracteres
        return password.length() >= 6;
    }

    private void IniciarComponentes(){
        text_tela_cadastro = findViewById(R.id.text_tela_cadastro);
    }
}