package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class User {

    /**
     * Método responsável por se conectar ao banco de dados
     *  
     * @return Connection
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.Driver.Manager").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test7user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
        }
        return conn;
    }

    /**
     * O nome do usuário
     */
    public String nome = "";

    /**
     * True se existir resultado na consulta do banco, caso contrário, false
     */
    public boolean result = false;

    /**
     * Método responsável por verificar se o usuário com o 
     * login e senha informados existe no banco de dados
     * @param login - O login do usuário
     * @param senha - A senha do usuário
     * @return TRUE caso o usuário exista, caso contrário, false
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        Connection conn = conectarBD();
        // INSTRUÇÃO SQL
        sql += "select nome from usuarios";
        sql += "where login= " + "'" + login + "'";
        sql += " and senha = " + "'" + senha + "';";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
        }

        return result;
    }
}