package com.mycompany.tecnoparcial.Negocio;

import java.io.IOException;

import com.mycompany.tecnoparcial.Datos.DUsuario;

public class NUsuario extends Negocio {
    public NUsuario() {
        super(new DUsuario());
    }

    @Override
    public String crear(String args[]) {
        try {
            String mensajeValidacion = this.validarDatos(args);
            if (mensajeValidacion.length() > 1) {
                return mensajeValidacion;
            }
            if (args[5].toLowerCase() != "administrador" || args[5].toLowerCase() != "empleado") {
                return "Solo pueden crearse usuarios administrador o empleado";
            }
            Object[] datosParseados = this.parsearDatos(args);
            if (dato.crear(datosParseados)) {
                return listar("Registro Completado !");
            }

        } catch (IOException e) {
            System.err.println(e);

        }
        return "<h1>Ups! Algo Pasó! :(</h1>";
    }
}
