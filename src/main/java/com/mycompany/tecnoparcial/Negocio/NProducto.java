package com.mycompany.tecnoparcial.Negocio;

import java.io.IOException;

import com.mycompany.tecnoparcial.Datos.DProducto;
import com.mycompany.tecnoparcial.Datos.Tabla;

public class NProducto extends Negocio {
    public NProducto() {
        super(new DProducto());
    }

    public String obtenerProductosPorCategoria(String categoriaid) throws IOException{
        DProducto dProducto = (DProducto) this.dato;
        Tabla datos = dProducto.obtenerProductosPorCategoria(categoriaid);
        return listarDinamico("Productos por categoria", datos);
    }

    public String obtenerProductosReabastecimiento() throws IOException{
        DProducto dProducto = (DProducto) this.dato;
        Tabla datos = dProducto.obtenerProductosReabastecimiento();
        return listarDinamico("Productos a Reabastecer", datos);
    }
}
