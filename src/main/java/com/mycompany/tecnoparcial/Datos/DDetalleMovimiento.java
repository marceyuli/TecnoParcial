package com.mycompany.tecnoparcial.Datos;

import java.sql.ResultSet;

public class DDetalleMovimiento extends Dato {
    public DDetalleMovimiento() {
        super();
        this.TABLE = "detallemovimiento";
        this.COLUMNS = new String[] {
                "movimientoid",
                "productoid",
                "cantidad",
        };
        this.TYPES = new String[] {
                Datatypes.INTEGER,
                Datatypes.INTEGER,
                Datatypes.INTEGER,
        };
    }

    public Tabla listar(String id){
        String sql = "SELECT * FROM " + TABLE + " WHERE movimientoid = '" + id + "'";
        return new Tabla((ResultSet) dbc.query(sql));
    }
}
