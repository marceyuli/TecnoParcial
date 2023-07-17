package com.mycompany.tecnoparcial.Datos;

public class DMovimiento extends Dato{
    public DMovimiento(){
        super();
        this.TABLE = "movimiento";
        this.COLUMNS = new String[]{
            "tipo",
            "fecha"
        };
        this.TYPES = new String[]{
            Datatypes.STRING,
            Datatypes.DATE,
        };
    }
}
