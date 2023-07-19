package com.mycompany.tecnoparcial.Datos;

public class DProducto extends Dato{
    public DProducto(){
        super();
        this.TABLE = "producto";
        this.COLUMNS = new String[]{
            "usuarioid",
            "categoriaid",
            "nombre",
            "descripcion",
            "cantidad",
            "precio",
        };
        this.TYPES = new String[]{
            Datatypes.INTEGER,
            Datatypes.INTEGER,
            Datatypes.STRING,
            Datatypes.STRING,
            Datatypes.INTEGER,
            Datatypes.FLOAT,
        };
    }
}
