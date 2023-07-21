package com.mycompany.tecnoparcial.Datos;

import java.sql.ResultSet;

public class DDetallePedido extends Dato {
    public DDetallePedido() {
        super();
        this.TABLE = "detallepedido";
        this.COLUMNS = new String[] {
                "pedidoid",
                "productoid",
                "cantidad",
                "precio",
        };
        this.TYPES = new String[] {
                Datatypes.INTEGER,
                Datatypes.INTEGER,
                Datatypes.INTEGER,
                Datatypes.FLOAT,
        };
    }

    public Tabla listar(String id){
        String sql = "SELECT * FROM " + TABLE + " WHERE pedidoid = '" + id + "'";
        return new Tabla((ResultSet) dbc.query(sql));
    }

    public Tabla obtenerProductosPopulares() {
        String sql = "SELECT p.nombre AS nombre, SUM(d.cantidad) AS total " +
                "FROM detallePedido d " +
                "JOIN producto p ON d.productoid = p.id " +
                "GROUP BY d.productoid, p.nombre";
        return new Tabla((ResultSet) dbc.query(sql));
    }
}
