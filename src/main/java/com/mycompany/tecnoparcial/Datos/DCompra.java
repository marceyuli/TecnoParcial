package com.mycompany.tecnoparcial.Datos;

public class DCompra extends Dato {
    public DCompra() {
        super();
        this.TABLE = "compra";
        this.COLUMNS = new String[] {
                "contactoid",
                "fecha",
        };
        this.TYPES = new String[] {
                Datatypes.INTEGER,
                Datatypes.DATE,
        };
    }
}
