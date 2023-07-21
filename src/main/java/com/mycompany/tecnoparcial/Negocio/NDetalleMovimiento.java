package com.mycompany.tecnoparcial.Negocio;

import java.io.IOException;

import com.mycompany.tecnoparcial.Datos.DDetalleMovimiento;
import com.mycompany.tecnoparcial.Datos.Tabla;

public class NDetalleMovimiento extends Negocio {
    public NDetalleMovimiento() {
        super(new DDetalleMovimiento());
    }
    public String listar(String id) throws IOException{
        if (!validarInteger(id)) {
            return "Debe introducir un id del movimiento";
        }
        DDetalleMovimiento dDetalleMovimiento = (DDetalleMovimiento) this.dato;
        Tabla datos = dDetalleMovimiento.listar(id);
        return listarDinamico("Detalle de Movimiento", datos);
    }
}
