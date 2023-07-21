package com.mycompany.tecnoparcial.Negocio;

import org.rendersnake.HtmlCanvas;

import com.mycompany.tecnoparcial.Datos.*;
import com.mycompany.tecnoparcial.utils.ParseUtils;

import static org.rendersnake.HtmlAttributesFactory.*;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

public abstract class Negocio {

    private final String styles = ParseUtils.styles;

    Dato dato;
    protected HtmlCanvas html;

    public Negocio(Dato dato) {
        this.dato = dato;
        this.html = new HtmlCanvas();
    }

    public String crear(String args[]) {
        try {

            String mensajeValidacion = this.validarDatos(args);
            if (mensajeValidacion.length() > 1) {
                return mensajeValidacion;
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

    public String editar(String args[]) {
        try {
            Object[] datosTotales = new Object[args.length];
            Integer id = Integer.parseInt(args[0]);
            datosTotales[args.length - 1] = id;

            String mensajeValidacion = this.validarDatos(Arrays.copyOfRange(args, 1, args.length));
            if (mensajeValidacion.length() > 1) {
                return mensajeValidacion;
            }

            Object[] datosParseados = this.parsearDatos(Arrays.copyOfRange(args, 1, args.length));
            for (int i = 0; i < datosParseados.length; i++) {
                Object datoParseado = datosParseados[i];
                datosTotales[i] = datoParseado;
            }
            if (dato.editar(datosTotales)) {
                return listar("Registro Completado !");
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return "<h1>Ups! Algo Pasó! :(</h1>";
    }

    public String eliminar(String id) {
        try {
            if (this.dato.eliminar(id)) {
                return listar("Consulta Exitosa");
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return "<h1>Ups! Algo Pasó</h1>";
    }

    public String listar(String title) throws IOException {
        Tabla datos = this.dato.listar();
        return TablaHTML(title, datos);
    }

    public String listarDinamico(String title, Tabla datos) throws IOException {
        return TablaHTML(title, datos);
    }

    public String TablaHTML(String title, Tabla datos) throws IOException {
        Tabla data = datos;

        this.html.style().write(styles)._style();
        this.html.html().title().write(title)._title()._html();
        this.html.html().h1().write(title)._h1();
        this.html.html().div(class_("wrapper"));
        this.html.table(class_(" c-table"));
        this.html.thead(class_("c-table__header")).tr();
        for (String nombre : data.nombres) {
            this.html.th(class_("c-table__col-label")).write(nombre)._th();
        }
        this.html._tr()._thead();
        this.html.tbody(class_("c-table__body"));
        for (int i = 0; i < data.getFila(); i++) {
            this.html.tr();
            for (int j = 0; j < data.getColumna(); j++) {
                this.html.td(class_("c-table__cell")).write(data.getData(i, j))._td();
            }
            this.html._tr();
        }

        this.html._tbody()._table()._div()._html();

        String innerHTML = this.html.toHtml();
        innerHTML = "Content-Type: text/html; charset=\"UTF-8\"\n" + innerHTML;
        this.html = new HtmlCanvas();
        return innerHTML;
    }

    public String validarDatos(String[] datos) {
        String mensajeValidacion = "";
        try {

            String[] columnas = dato.getColums();
            if (datos.length != columnas.length) {
                mensajeValidacion = "Cantidad de parametros incorrecta";
                throw new Exception(mensajeValidacion);
            }
            String[] tipos = dato.getTypesList();
            int i;
            for (i = 0; i < tipos.length; i++) {
                String tipo = tipos[i];
                switch (tipo) {
                    case Dato.Datatypes.DATE:
                        if (!validarFecha(datos[i])) {
                            mensajeValidacion = "Parametro incorrecto en posicion: " + i
                                    + " : " + columnas[i] + "Verifique que sea una fecha correcta";
                            throw new Exception(mensajeValidacion);
                        }
                        break;
                    case Dato.Datatypes.FLOAT:
                        if (!validarFloat(datos[i])) {
                            mensajeValidacion = "Parametro incorrecto en posicion: " + i
                                    + " : " + columnas[i] + "Verifique que sea un decimal correcto";
                            throw new Exception(mensajeValidacion);
                        }
                        break;
                    case Dato.Datatypes.INTEGER:
                        if (!validarInteger(datos[i])) {
                            mensajeValidacion = "Parametro incorrecto en posicion: " + i
                                    + " : " + columnas[i] + "Verifique que sea un numero correcto";
                            throw new Exception(mensajeValidacion);
                        }
                        break;
                    case Dato.Datatypes.STRING:
                        if (!validarString(datos[i])) {
                            mensajeValidacion = "Parametro incorrecto en posicion: " + i
                                    + " : " + columnas[i] + "Verifique que sea una Cadena correcta";
                            throw new Exception(mensajeValidacion);
                        }
                        break;
                }

            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return mensajeValidacion;
    }

    private boolean validarFecha(String dato) {
        return ParseUtils.tryParseDate(dato);
    }

    private boolean validarFloat(String dato) {
        return ParseUtils.tryParseFloat(dato);
    }

    public boolean validarInteger(String dato) {
        return ParseUtils.tryParseInt(dato);
    }

    private boolean validarString(String dato) {
        return ParseUtils.tryParseString(dato);
    }

    public Object[] parsearDatos(String[] args) {

        String[] tipos = dato.getTypesList();
        Object[] datosParseados = new Object[tipos.length];

        for (int i = 0; i < tipos.length; i++) {
            String tipoActual = tipos[i];
            switch (tipoActual) {
                case Dato.Datatypes.INTEGER:
                    datosParseados[i] = Integer.parseInt(args[i]);
                    break;

                case Dato.Datatypes.FLOAT:
                    datosParseados[i] = Float.parseFloat(args[i]);
                    break;
                case Dato.Datatypes.DATE:
                    datosParseados[i] = Date.valueOf(args[i]);
                    break;
                case Dato.Datatypes.STRING:
                    datosParseados[i] = (args[i]);
                    break;
            }

        }
        return datosParseados;
    }

}
