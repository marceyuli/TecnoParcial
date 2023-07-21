package com.mycompany.tecnoparcial.Datos;

import java.sql.ResultSet;

public class DUsuario extends Dato {
    public DUsuario() {
        super();
        this.TABLE = "usuario";
        this.COLUMNS = new String[] {
                "nombre",
                "apellidopaterno",
                "apellidomaterno",
                "direccion",
                "email",
                "cargo",
                "password",
        };
        this.TYPES = new String[] {
                Datatypes.STRING,
                Datatypes.STRING,
                Datatypes.STRING,
                Datatypes.STRING,
                Datatypes.STRING,
                Datatypes.STRING,
                Datatypes.STRING,
        };
    }

    public Tabla existeAdministrador(String email) {
        String sql = "SELECT COUNT(*) AS total FROM " + TABLE + " WHERE email = '" + email
                + "' AND LOWER(cargo) = 'administrador'";
        return new Tabla((ResultSet) dbc.query(sql));
    }

    public Tabla existeEmpleado(String email) {
        String sql = "SELECT COUNT(*) AS total FROM " + TABLE + " WHERE email = '" + email
                + "' AND LOWER(cargo) = 'empleado'";
        return new Tabla((ResultSet) dbc.query(sql));
    }
}
