package com.mycompany.tecnoparcial.Negocio;

import com.mycompany.tecnoparcial.Datos.DCategoria;
import com.mycompany.tecnoparcial.Datos.Tabla;

public class NCategoria extends Negocio {

    public NCategoria() {
        super(new DCategoria());
        
    }

    public String obtenerIdCategoria(String nombreCategoria){
        DCategoria dCategoria = (DCategoria) this.dato;
        Tabla datos = dCategoria.obtenerIdCategoria(nombreCategoria);
        return datos.getData(0, 0);
    }
}
