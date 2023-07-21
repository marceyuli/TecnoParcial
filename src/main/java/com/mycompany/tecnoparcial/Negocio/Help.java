package com.mycompany.tecnoparcial.Negocio;

import java.util.Date;
import java.text.SimpleDateFormat;

import com.mycompany.tecnoparcial.utils.Comandos;

public class Help {
    public Help() {
    };

    public String help() {
        // Arreglo que se usara para la tabla

        String[][] miTabla = Comandos.listaComandos;

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        String help = "Content-Type: text/html; charset=\"UTF-8\"\n"
                + "\n"
                + "<h1>Lista de Comandos  </h1>"
                + formatter.format(date)
                + "<table style=\"border-collapse: collapse; width: 100%; border: 2px solid black;\">\n"
                + "\n";
        // Ponemos el encabezado
        help += generarEncabezado(miTabla);
        help += generarCuerpoTabla(miTabla);
        // Ponemos el contenido del documento
        return help;
    }

    private String generarCuerpoTabla(String[][] miTabla) {
        String cuerpo = "";
        for (int i = 1; i < miTabla.length; i++) {
            cuerpo += "  <tr>\n"
                    + "\n";
            for (int j = 0; j < miTabla[i].length; j++) {
                cuerpo += "    <td style = \"text-align: left; padding: 8px; border: 2px solid black;\">"
                        + miTabla[i][j] + "</td>\n"
                        + "\n";
            }
            cuerpo += "  </tr>\n"
                    + "\n";
        }
        return cuerpo;
    }

    private String generarEncabezado(String[][] miTabla) {
        String encabezado = "<tr>\n"
                + "\n";
        for (int i = 0; i < miTabla[0].length; i++) {
            encabezado += "<th style = \"text-align: left; padding: 8px; background-color: #4CAF50; color: white; border: 2px solid black;\">"
                    + miTabla[0][i] + "</th>\n"
                    + "\n";
        }
        encabezado += "  </tr>\n"
                + "\n";
        return encabezado;
    }
}
