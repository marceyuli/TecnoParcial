package com.mycompany.tecnoparcial.Datos;

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
}
