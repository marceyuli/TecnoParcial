package com.mycompany.tecnoparcial.Datos;

public class DCategoria extends Dato{
    public DCategoria(){
        super();
        this.TABLE = "categoria";
        this.COLUMNS = new String[]{
            "nombre",
            "descripcion",
        };
        this.TYPES = new String[]{
            Datatypes.STRING,
            Datatypes.STRING,
        };
    }
}
