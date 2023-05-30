package com.example.projetominimerc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FormCadastro extends AppCompatActivity {
    private TextView lblStatus;
    private EditText txtNome, txtEmail, txtSenha;
    DbHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);

        lblStatus = (TextView) findViewById(R.id.textViewStatus);
        txtNome = (EditText) findViewById(R.id.edit_nome);
        txtEmail = (EditText) findViewById(R.id.edit_email);
        txtSenha = (EditText) findViewById(R.id.edit_senha);

        findViewById(R.id.btnCadastrar).setOnClickListener(clickListenerDb);
    }

    private final View.OnClickListener clickListenerDb = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String nome = txtNome.getText().toString();
            String email = txtEmail.getText().toString();
            String senha = txtSenha.getText().toString();

            salvarArquivoDb(nome, email, senha);
            lblStatus.setText(" Status: Dados Salvos no BD! ");

        }
    };

    private void salvarArquivoDb(String nome, String email, String senha) {
        try {
            dbHelper = new DbHelper(this);
            db = dbHelper.getReadableDatabase();

            ContentValues values = new ContentValues();
            values.put(dbHelper.C_NOME, nome);
            values.put(dbHelper.C_EMAIL, email);
            values.put(dbHelper.C_SENHA, senha);

            try {
                db.insertOrThrow(dbHelper.TABLE, null, values);
            }finally {
                db.close();
            }

        }catch (Exception e){
            Log.e("Erro DB: ", e.getMessage());
        }


    }
}