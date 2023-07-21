package com.mycompany.tecnoparcial.Negocio;

import java.io.IOException;

import com.mycompany.tecnoparcial.Datos.DMovimiento;

public class NMovimiento extends Negocio {
    public NMovimiento() {
        super(new DMovimiento());
    }

    @Override
    public String crear(String args[]) {
        try {
            String mensajeValidacion = this.validarDatos(args);
            if (mensajeValidacion.length() > 1) {
                return mensajeValidacion;
            }
            if (args[0].toLowerCase() != "ingreso" || args[5].toLowerCase() != "salida") {
                return "Solo pueden crearse movimientos de tipo ingreso o salida";
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
