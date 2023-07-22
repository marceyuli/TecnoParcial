package com.mycompany.tecnoparcial.Negocio;

import java.io.IOException;

import com.mycompany.tecnoparcial.Datos.DUsuario;
import com.mycompany.tecnoparcial.Datos.Tabla;

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
            if (!args[5].toLowerCase().equals("administrador") && !args[5].toLowerCase().equals("empleado")) {
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

    public boolean existeAdministrador(String email){
        DUsuario dUsuario = (DUsuario) this.dato;
        Tabla tabla = dUsuario.existeAdministrador(email);
        int cantidad = Integer.parseInt(tabla.getData(0, 0));
        return cantidad > 0;
    }

    public boolean existeEmpleado(String email){
        DUsuario dUsuario = (DUsuario) this.dato;
        Tabla tabla = dUsuario.existeEmpleado(email);
        int cantidad = Integer.parseInt(tabla.getData(0, 0));
        return cantidad > 0;
    }
}
