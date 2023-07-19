package com.mycompany.tecnoparcial.Datos;

public class DPedido extends Dato {
    public DPedido() {
        super();
        this.TABLE = "pedido";
        this.COLUMNS = new String[] {
                "contactoid",
                "fecha",
                "estado",
        };
        this.TYPES = new String[] {
                Datatypes.INTEGER,
                Datatypes.DATE,
                Datatypes.STRING,
        };
    }
}
