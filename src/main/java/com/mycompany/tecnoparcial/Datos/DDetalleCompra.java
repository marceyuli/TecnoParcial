package com.mycompany.tecnoparcial.Datos;

import java.sql.ResultSet;

public class DDetalleCompra extends Dato {
    public DDetalleCompra() {
        super();
        this.TABLE = "detallecompra";
        this.COLUMNS = new String[] {
                "compraid",
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
        String sql = "SELECT * FROM " + TABLE + " WHERE compraid = '" + id + "'";
        return new Tabla((ResultSet) dbc.query(sql));
    }
}
