package com.fieb.mercado;

import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DatabaseManager {

    public ListView listProdutosr;
    private static final String DB_URL = "jdbc:jtds:sqlserver://MiniMerc.mssql.somee.com";
    private static final String DB_USERNAME = "Nicolas_2701_SQLLogin_1";
    private static final String DB_PASSWORD = "m2rv8z283k";

    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final Executor executor = Executors.newSingleThreadExecutor();

    public static void insertData(String descricao, Double preco, int quantidade, String nome, String image) {
        executor.execute(() -> {
            try {
                Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                String query = "INSERT INTO produto (descricao, nome, preco, quantidade, image) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, descricao);
                statement.setString(2, nome);
                statement.setDouble(3, preco);
                statement.setInt(4, quantidade);
                statement.setString(5, image);
                statement.executeUpdate();

                statement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
    public static void listProducts(final ListView listProdutos) {
        executor.execute(() -> {
            try {
                Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                String query = "SELECT * FROM produto";
                PreparedStatement statement = conn.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();

                List<String> productList = new ArrayList<>();

                while (resultSet.next()) {
                    String descricao = resultSet.getString("descricao");
                    String nome = resultSet.getString("nome");
                    Double preco = resultSet.getDouble("preco");
                    int quantidade = resultSet.getInt("quantidade");
                    String image = resultSet.getString("image");

                    String productInfo = "Descrição: " + descricao + "\n"
                            + "Nome: " + nome + "\n"
                            + "Preço: " + preco + "\n"
                            + "Quantidade: " + quantidade + "\n"
                            + "Imagem: " + image + "\n"
                            + "-------------------------";

                    productList.add(productInfo);
                }

                resultSet.close();
                statement.close();
                conn.close();

                mainHandler.post(() -> {
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(listProdutos.getContext(), android.R.layout.simple_list_item_1, productList);
                    listProdutos.setAdapter(adapter);
                });
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }
    public static void insertCadastro(String email,String senha,int cnpj,int cpf) {
        executor.execute(() -> {
            try {
                Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                String query = "INSERT INTO admnistrador (email, senha, cnpj, cpf) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, email);
                statement.setString(2, senha);
                statement.setDouble(3, cnpj);
                statement.setInt(4, cpf);
                statement.executeUpdate();

                statement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
    public static boolean login(String email,String senha) {
            try {
                Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                String query = "SELECT * FROM admnistrador WHERE email = ? AND senha = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, email);
                statement.setString(2, senha);
                ResultSet resultSet = statement.executeQuery();

                boolean loginSucesso = resultSet.next();

                resultSet.close();
                statement.close();
                conn.close();

                return loginSucesso;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return false;
    }
}