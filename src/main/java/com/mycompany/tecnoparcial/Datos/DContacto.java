package com.mycompany.tecnoparcial.Datos;

public class DContacto extends Dato{
    public DContacto(){
        super();
        this.TABLE = "contacto";
        this.COLUMNS = new String[]{
            "tipo",
            "nombre",
            "apellidopaterno",
            "apellidomaterno",
            "direccion",
            "telefono",
        };
        this.TYPES = new String[]{
            Datatypes.STRING,
            Datatypes.STRING,
            Datatypes.STRING,
            Datatypes.STRING,
            Datatypes.STRING,
        };
    }
}
