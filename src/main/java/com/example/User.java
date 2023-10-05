package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class User {
    public Connection connection;
    public String nome = "";
    public boolean result = false;

    public void conectarDB() throws Exception {
        try {
            Class.forName("com.mysql.Driver.Manager");
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            this.connection = DriverManager.getConnection(url); // 2
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean verificarUsuario(String login, String senha) throws Exception {
        try {
            this.conectarDB(); // 1
        } catch (Exception e) {
            System.out.println("Erro ao conectar no banco de dados"); //3
        }

        // 4
        // 5
        
        String query = "select nome from usuarios where login = '" + login + "' and senha = '" + senha + "'";

        try {
            Statement statement = this.connection.createStatement(); //6
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) { // 7
                this.result = true;
                this.nome = resultSet.getString("nome");
            }
        } catch (Exception e) {
            throw e; // 8
        }
        return result; // 10
    }
}
