package com.mycompany.tecnoparcial.TecnoEmail;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.concurrent.Callable;

import com.mycompany.tecnoparcial.Negocio.*;

public class MailTask implements Callable<MailSender> {
    String to, subject;

    NCategoria nCategoria;
    NCompra nCompra;
    NContacto nContacto;
    NDetalleCompra nDetalleCompra;
    NDetalleMovimiento nDetalleMovimiento;
    NDetallePedido nDetallePedido;
    NMovimiento nMovimiento;
    NPedido nPedido;
    NProducto nProducto;
    NUsuario nUsuario;

    public MailTask(String to, String subject) {
        this.to = to;
        this.subject = subject;
        this.nCategoria = new NCategoria();
        this.nCompra = new NCompra();
        this.nContacto = new NContacto();
        this.nDetalleCompra = new NDetalleCompra();
        this.nDetalleMovimiento = new NDetalleMovimiento();
        this.nDetallePedido = new NDetallePedido();
        this.nMovimiento = new NMovimiento();
        this.nPedido = new NPedido();
        this.nProducto = new NProducto();
        this.nUsuario = new NUsuario();
    }

    public String verificarComandos() throws IOException {

        LinkedList<Object> datosParseados = parseComando();
        String datos[] = (String[]) datosParseados.get(0);
        String encabezado = (String) datosParseados.get(1);
        String mensaje = "";
        System.err.println(encabezado);
        switch (encabezado) {

            // CU4: Gestionar Abogado
            case "reg_agenda":
                mensaje = nCategoria.crear(datos);
                break;
            case "listar_agendas":
                mensaje = nCategoria.TablaHTML("Lista Agenda");
            case "mod_agenda":
                mensaje = nCategoria.Editar(datos);
                break;
            case "eliminar_agenda":
                mensaje = nCategoria.Eliminar(datos[0]);
                break;
            case "reserva_cita":
                mensaje = nCompra.crear(datos);
                break;
            case "listar_citas":
                mensaje = nCompra.TablaHTML("Lista Citas");
                break;
            case "mod_cita":
                mensaje = nCompra.Editar(datos);
                break;
            case "eliminar_cita":
                mensaje = nCompra.Eliminar(datos[0]);
                break;
            case "reg_consulta":

                mensaje = nContacto.crear(datos);
                break;
            case "listar_consultas":
                mensaje = nContacto.TablaHTML("Lista Consultas");
                break;
            case "mod_consulta":
                mensaje = nContacto.Editar(datos);
                break;
            case "eliminar_consulta":
                mensaje = nContacto.Eliminar(datos[0]);
                break;

            case "reg_especialidad":
                mensaje = nDetalleCompra.crear(datos);
                break;
            case "listar_especialidades":
                mensaje = nDetalleCompra.TablaHTML("Lista Especialidades");
                break;
            case "mod_especialidad":
                mensaje = nDetalleCompra.Editar(datos);
                break;
            case "eliminar_especialidad":
                mensaje = nDetalleCompra.Eliminar(datos[0]);
                break;
            case "listar_odontologos":
                mensaje = nDetalleMovimiento.TablaHTML("Lista Odontologos");
                break;
            case "mod_odontologo":
                mensaje = nDetalleMovimiento.Editar(datos);
                break;
            case "eliminar_odontologo":
                mensaje = nDetalleMovimiento.Eliminar(datos[0]);
                break;
            case "reg_paciente":
                mensaje = this.nDetallePedido.crear(datos);
                break;
            case "listar_pacientes":
                mensaje = nDetallePedido.TablaHTML("Lista Pacientes");
                break;
            case "mod_paciente":
                mensaje = nDetallePedido.Editar(datos);
                break;
            case "eliminar_paciente":
                mensaje = nDetallePedido.Eliminar(datos[0]);
                break;
            case "reg_receta":
                mensaje = nMovimiento.crear(datos);
                break;
            case "listar_recetas":
                mensaje = nMovimiento.TablaHTML("Lista Recetas");
                break;
            case "mod_receta":
                mensaje = nMovimiento.Editar(datos);
                break;
            case "eliminar_receta":
                mensaje = nMovimiento.Eliminar(datos[0]);
                break;
            case "reg_tratamiento":
                mensaje = nPedido.crear(datos);
                break;
            case "listar_tratamientos":
                mensaje = nPedido.TablaHTML("Lista Tratamientos");
                break;
            case "mod_tratamiento":
                mensaje = nPedido.Editar(datos);
                break;
            case "eliminar_tratamiento":
                mensaje = nPedido.Eliminar(datos[0]);
                break;
            case "help":
                mensaje=this.help();
                break;
            default:
                mensaje = "La petición '" + this.subject + "' es incorrecta.";
                break;

        }
        return mensaje;
    }


    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    /**
     * separa el encabezado y el cuerpo de un comando enviado en una string
     *
     * @param encabezado
     * @param cuerpo
     */
    private LinkedList<Object> parseComando() {
        LinkedList<Object> parsedList = new LinkedList<>();
        String sub = this.subject.trim();
        String[] partesSubject = sub.split("\\[");
        String encabezado = partesSubject[0];
        String cuerpo[] = partesSubject[1].split("\\]");
        String datos[] = null;
        if (cuerpo.length != 0) {
            datos = cuerpo[0].split("\\;;");
            for (int i = 0; i < datos.length; i++) {
                datos[i] = datos[i].trim();
            }
        }
        parsedList.push(encabezado);
        parsedList.push(datos);
        System.err.println(encabezado);
        System.err.println(datos);
        return parsedList;
    }

    @Override
    public MailSender call() throws Exception {
        // TODO: Verificar las consultas, salta error cuando se
        // se llama a Negocio

        String resultadoVerificacion = this.verificarComandos();
        return new MailSender(this.to, "Resultado", resultadoVerificacion);
    }

    public String help() {
        //Arreglo que se usara para la tabla

        String[][] miTabla
                = {
                    {"Caso de uso", "Método", "Comando"},
                    // CU1 GESTIONAR PACIENTE
                    {"CU1. Gestionar paciente", "Registrar Paciente", "reg_paciente[int ci;;String nombre;;Date fNac[AAAA-MM-DD];;String celular];"},
                    {"CU1. Gestionar paciente", "Modificar Paciente", "mod_paciente[int id;;int ci;;String nombre;;Date fNac[AAAA-MM-DD];;String celular];"},
                    {"CU1. Gestionar paciente", "EliminarPaciente", "eliminar_paciente[int id];"},
                    {"CU1. Gestionar paciente", "Listar Paciente", "listar_pacientes[];"},
                    //  CU2 GESTIONAR ODONTÓLOGO
                    {"CU2. Gestionar odontologo", "Registrar Odontologo", "reg_odontologo[int CI;; String nombre;;Date fNac[AAAA-MM-DD];;String celular ;;String Genero (M o F) ;; String Correo ;; String Contrasena];"},
                    {"CU2. Gestionar odontologo", "Modificar  Odontologo", "mod_odontologo[int id;; int CI;; String nombre ;; int celular  ;; String fecha de nacimiento(AAAA-MM-DD) ;; String genero];"},
                    {"CU2. Gestionar odontologo", "Eliminar  Odontologo", "eliminar_odontologo[int id];"},
                    {"CU2. Gestionar odontologo", "Listar  Odontologos", "listar_odontologos[];"},
                    //  CU3 GESTIONAR RECETA
                    {"CU3 Gestionar Receta", "Registrar Receta", "reg_receta[String titulo;;String descripcion;;Date fNac[AAAA-MM-DD];;int Consultaid];"},
                    {"CU3 Gestionar Receta", "Registrar Receta", "mod_receta[int id;;String titulo;;String descripcion;;Date fNac[AAAA-MM-DD];;int Consultaid];"},
                    {"CU3 Gestionar Receta", "Eliminar Receta", "eliminar_paciente[int id];"},
                    {"CU3 Gestionar Receta", "Listar Receta", "listar_pacientes[];"},
                    //  CU4 GESTIONAR CITA
                    {"CU4 Gestionar Cita", "Registrar Cita", "reserva_cita[Time horaInicio[HH-MM];;Time horaFin[HH-MM];;int Pacienteid;; int Agendaid];"},
                    {"CU4 Gestionar Cita", "Registrar Cita", "mod_cita[int id;;Time horaInicio[HH-MM];;Time horaFin[HH-MM];;int Pacienteid;; int Agendaid];"},
                    {"CU4 Gestionar Cita", "Eliminar Cita", "eliminar_cita[int id];"},
                    {"CU4 Gestionar Cita", "Listar Cita", "listar_citas[];"},
                    //  CU5 GESTIONAR TRATAMIENTO
                    {"CU5 Gestionar Tratamiento", "Registrar Tratamiento", "reg_tratamiento[String nombre;; int Especialidadid];"},
                    {"CU5 Gestionar Tratamiento", "Registrar Tratamiento", "mod_tratamiento[int id;;String nombre;; int Especialidadid];"},
                    {"CU5 Gestionar Tratamiento", "Eliminar Tratamiento", "eliminar_tratamiento[int id];"},
                    {"CU5 Gestionar Tratamiento", "Listar Tratamiento", "listar_tratamientos[];"},
                    // CU6 GESTIONAR ESPECIALIDAD
                    {"CU6 Gestionar Especialidad", "Registrar Especialidad", "reg_especialidad[String nombre];"},
                    {"CU6 Gestionar Especialidad", "Registrar Especialidad", "mod_especialidad[int id;;String nombre];"},
                    {"CU6 Gestionar Especialidad", "Eliminar Especialidad", "eliminar_especialidad[int id];"},
                    {"CU6 Gestionar Especialidad", "Listar Especialidad", "listar_especialidades[];"},
                    // CU7 GESTIONAR AGENDA
                    {"CU7 Gestionar Agenda", "Registrar Agenda", "reg_agenda[String nombre;; int Odontologid];"},
                    {"CU7 Gestionar Agenda", "Registrar Agenda", "mod_agenda[int id;;String nombre;; int Odontologid];"},
                    {"CU7 Gestionar Agenda", "Eliminar Agenda", "eliminar_agenda[int id];"},
                    {"CU7 Gestionar Agenda", "Listar Agenda", "listar_agendas[];"},
                    // CU8 GESTIONAR CONSULTA
                    {"CU8 Gestionar Consulta", "Registrar Consulta", "reg_consulta[Date fechaEmision[AAAA-MM-DD];; int Citaid];"},
                    {"CU8 Gestionar Consulta", "Registrar Consulta", "mod_consulta[int id;;Date fechaEmision[AAAA-MM-DD];; int Citaid];"},
                    {"CU8 Gestionar Consulta", "Eliminar Consulta", "eliminar_consulta[int id];"},
                    {"CU8 Gestionar Consulta", "Listar Consulta", "listar_consultas[];"},
                    //  CU9 GENERAR REPORTE
                    {"CU9 VER REPORTE", "Ver Odontologos", "reporteGeneros[];"},};

        Date date = new Date(0);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        
        
        String help = "Content-Type: text/html; charset=\"UTF-8\"\n"
                + "\n"
                + "<h1>Lista de Comandos  </h1>"
                + formatter.format(date)
                // + "<h2>Por favor no utilizar tildes (´) o (ñ) en los datos de los comandos</h2>"
                // + "<h2>(Se acepta documentos tipo: .txt, .docx, .pdf, .jpg, .rar, .xmls) DEPENDIENTO DEL TAMAÑO DEL ARCHIVO EL TIEMPO DE EJECUCION DEL PROGRAMA SERÁ MAYOR</h2>"
                + "<table style=\"border-collapse: collapse; width: 100%; border: 2px solid black;\">\n"
                + "\n";
        //Ponemos el encabezado
        help += generarEncabezado(miTabla);
        help += generarCuerpoTabla(miTabla);
        //Ponemos el contenido del documento
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

    /**
     * Genera el encabezado a partir de la primera fila de la matriz de strings
     * que se le envie
     *
     * @param miTabla
     * @return
     */
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
