package com.mycompany.tecnoparcial.Negocio;

import java.io.IOException;

import com.mycompany.tecnoparcial.Datos.DDetalleCompra;
import com.mycompany.tecnoparcial.Datos.Tabla;

public class NDetalleCompra extends Negocio {
    public NDetalleCompra() {
        super(new DDetalleCompra());
    }

    public String listar(String id) throws IOException{
        if (!validarInteger(id)) {
            return "Debe introducir un id de la compra";
        }
        DDetalleCompra dDetalleCompra = (DDetalleCompra) this.dato;
        Tabla datos = dDetalleCompra.listar(id);
        return listarDinamico("Detalle de Compra", datos);
    }
}
