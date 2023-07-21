package com.mycompany.tecnoparcial.Datos;

import java.sql.ResultSet;

public class DCategoria extends Dato {
    public DCategoria() {
        super();
        this.TABLE = "categoria";
        this.COLUMNS = new String[] {
                "nombre",
                "descripcion",
        };
        this.TYPES = new String[] {
                Datatypes.STRING,
                Datatypes.STRING,
        };
    }

    public Tabla obtenerIdCategoria(String nombreCategoria){
        String sql = "SELECT * FROM " + TABLE + " WHERE nombre = '" + nombreCategoria + "'";
        return new Tabla((ResultSet) dbc.query(sql));
    }

}
