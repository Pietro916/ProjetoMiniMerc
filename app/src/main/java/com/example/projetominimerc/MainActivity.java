package com.example.projetominimerc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.projetominimerc.api.ConexaoSqlSever;

import java.sql.Connection;

public class MainActivity extends AppCompatActivity {

    Connection conn = ConexaoSqlSever.conectar(getApplication());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarConexao();
    }

    private void inicializarConexao() {

        try {
            if (conn != null) {
                if (!conn.isClosed())
                    setTitle("CONEXAO REALIZADA COM SUCESSO");
                else
                    setTitle("A CONEXÃO ESTÁ FECHADA");
            } else {
                setTitle("CONEXAO NULA, NÃO REALIZADA");
            }
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            setTitle("CONEXÃO FALHOU!!!\n" + ex.getMessage());
        }
    }
}