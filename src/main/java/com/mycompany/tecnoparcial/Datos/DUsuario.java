package com.mycompany.tecnoparcial.Datos;

public class DUsuario extends Dato{
    public DUsuario(){
        super();
        this.TABLE = "usuario";
        this.COLUMNS = new String[]{
            "nombre",
            "apellidopaterno",
            "apellidomaterno",
            "direccion",
            "email",
            "cargo",
            "password",
        };
        this.TYPES = new String[]{
            Datatypes.STRING,
            Datatypes.STRING,
            Datatypes.STRING,
            Datatypes.STRING,
            Datatypes.STRING,
            Datatypes.STRING,
            Datatypes.STRING,
        };
    }
}
