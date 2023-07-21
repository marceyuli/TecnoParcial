package com.mycompany.tecnoparcial.Datos;

import java.sql.ResultSet;

public class DProducto extends Dato {
    public DProducto() {
        super();
        this.TABLE = "producto";
        this.COLUMNS = new String[] {
                "usuarioid",
                "categoriaid",
                "nombre",
                "descripcion",
                "cantidad",
                "precio",
        };
        this.TYPES = new String[] {
                Datatypes.INTEGER,
                Datatypes.INTEGER,
                Datatypes.STRING,
                Datatypes.STRING,
                Datatypes.INTEGER,
                Datatypes.FLOAT,
        };
    }
    
    public Tabla obtenerProductosPorCategoria(String categoriaid){
        String sql = "SELECT * FROM " + TABLE + " WHERE categoriaid = '" + categoriaid + "'";
        return new Tabla((ResultSet) dbc.query(sql));
    }

    public Tabla obtenerProductosReabastecimiento(){
        String sql = "SELECT nombre, precio, cantidad FROM " + TABLE +" WHERE cantidad < 10";
        return new Tabla((ResultSet) dbc.query(sql));
    }
}
