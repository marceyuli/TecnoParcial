package com.mycompany.tecnoparcial.Datos;

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
}
