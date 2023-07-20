package com.mycompany.tecnoparcial.Datos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private final String base = "db_grupo01sc";
    private final String user = "grupo01sc";
    private final String password = "grup001grup001";
    private final String host = "tecnoweb.org.bo";
    private final String url = "jdbc:postgresql://" + host + ":5432/" + base;
    private final String driver = "org.postgresql.Driver";
    private Connection con = null;

    public Conexion() {

    }

    public Connection getConexion() {
        if (con != null) {
            return con;
        }
        try {
            Class.forName(this.driver);
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Conetaco correctamente");
        } catch (SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public void connect() {
        if (con != null) {
            return;
        }
        try {
            Class.forName(this.driver);
            con = DriverManager.getConnection(url, user, password);
            System.out.println("\033[32;1;2mCONNECTION OPENED!\033[0m");
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            System.err.println("ERROR ON CONNECTING!");
        }
    }

    public void close() {
        if (con == null) {
            return;
        }
        try {
            con.close();
            con = null;
            System.out.println("\033[32;1;2mCONNECTION CLOSED!!\033[0m");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("ERROR ON CLOSING!");
        }
    }

    public Object query(String query) {
        Statement statement;
        Object resultSet = null;
        String m = query.toLowerCase();
        boolean type = m.contains("select");

        try {
            connect();
            statement = (Statement) con.createStatement();

            if (type) {
                resultSet = statement.executeQuery(query);
            } else {
                resultSet = (statement.executeUpdate(query) >= 0);
            }

        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            close();
        }

        return resultSet;
    }
}
