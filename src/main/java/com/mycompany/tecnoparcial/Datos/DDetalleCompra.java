package com.mycompany.tecnoparcial.Datos;

public class DDetalleCompra extends Dato{
    public DDetalleCompra(){
        super();
        this.TABLE = "detallecompra";
        this.COLUMNS = new String[]{
            "compraid",
            "productoid",
            "cantidad",
            "precio",
        };
        this.TYPES = new String[]{
            Datatypes.INTEGER,
            Datatypes.INTEGER,
            Datatypes.INTEGER,
            Datatypes.FLOAT,
        };
    }
}
