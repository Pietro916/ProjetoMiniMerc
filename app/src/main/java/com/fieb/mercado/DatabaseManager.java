package com.fieb.mercado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DatabaseManager {

    private static final String DB_URL = "jdbc:mysql://MiniMerc.mssql.somee.com/MiniMerc";
    private static final String DB_USERNAME = "Nicolas_2701_SQLLogin_1";
    private static final String DB_PASSWORD = "m2rv8z283k";

    private static final Executor executor = Executors.newSingleThreadExecutor();

    public static void insertData(String descricao, Double preco, int quantidade, String nome, String image) {
        executor.execute(() -> {
            try {
                Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                String query = "INSERT INTO usuarios (descricao, nome, preco, quantidade, image) VALUES (?, ?, ?, ?, ?)";
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
}