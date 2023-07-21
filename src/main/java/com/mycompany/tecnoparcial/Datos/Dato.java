package com.mycompany.tecnoparcial.Datos;

import java.util.regex.*;
import java.sql.ResultSet;

public abstract class Dato {

    protected String TABLE;
    protected String[] COLUMNS;
    protected String[] TYPES;
    protected final Conexion dbc;

    public Dato() {
        this.dbc = new Conexion();
    }

    private boolean isNumber(Object arg) {
        String regex = "^(\\d+(\\.\\d+)?)$";
        return Pattern.matches(regex, String.valueOf(arg));
    }

    public Tabla listar() {
        String sql = "SELECT * FROM " + TABLE;
        return new Tabla((ResultSet) dbc.query(sql));
    }

    public String[] getTypesList() {
        return TYPES;
    }

    public String[] getColums() {
        return COLUMNS;
    }


    public boolean crear(Object args[]) {
        String COLS = "";
        String VALUES = "";

        for (int i = 0; i < COLUMNS.length; i++) {
            if (!isNumber(args[i])) {
                args[i] = "'" + args[i] + "'";
            }

            if (i == COLUMNS.length - 1) {
                VALUES += "%s";
                COLS += COLUMNS[i];
            } else {
                VALUES += "%s,";
                COLS += COLUMNS[i] + ",";
            }
        }

        String sql = String.format(
                "INSERT INTO " + TABLE + "(" + COLS + ") VALUES (" + VALUES + ")",
                args);

        return (boolean) dbc.query(sql);
    }

    public boolean editar(Object args[]) {
        String VALUES = "";
        for (int i = 0; i < COLUMNS.length; i++) {
            if (!isNumber(args[i])) {
                args[i] = "'" + args[i] + "'";
            }

            VALUES += this.COLUMNS[i];
            VALUES += (i == COLUMNS.length - 1) ? "= %s " : " = %s, ";
        }

        String sql = String.format(
                "UPDATE " + TABLE + " SET " + VALUES + "WHERE id = %s",
                args);

        return (boolean) dbc.query(sql);
    }

    public boolean eliminar(String id) {
        String sql = String.format("DELETE FROM " + TABLE + " WHERE id = %s", id);
        return (boolean) dbc.query(sql);
    }

    public static class Datatypes {
        public static final String STRING = "string";
        public static final String INTEGER = "integer";
        public static final String DATE = "date";
        public static final String FLOAT = "float";
    }
}
