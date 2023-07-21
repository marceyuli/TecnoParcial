package com.mycompany.tecnoparcial.Negocio;

import java.io.IOException;

import com.mycompany.tecnoparcial.Datos.DContacto;

public class NContacto extends Negocio {
    public NContacto() {
        super(new DContacto());
    }

    @Override
    public String crear(String args[]) {
        try {
            
            String mensajeValidacion = this.validarDatos(args);
            if (mensajeValidacion.length() > 1) {
                return mensajeValidacion;
            }
            if (args[0].toLowerCase() != "proveedor" || args[0].toLowerCase() != "distribuidor") {
                return "Solo pueden crearse contactos de tipo proveedor o distribuidor";
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
