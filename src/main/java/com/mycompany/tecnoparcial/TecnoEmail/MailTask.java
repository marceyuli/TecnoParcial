package com.mycompany.tecnoparcial.TecnoEmail;

import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.Callable;

import com.mycompany.tecnoparcial.Negocio.*;
import com.mycompany.tecnoparcial.utils.Comandos;

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
    Help help;

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
        this.help = new Help();
    }

    public String verificarComandos() throws IOException {

        LinkedList<Object> datosParseados = parseComando();
        String datos[] = (String[]) datosParseados.get(0);
        String encabezado = (String) datosParseados.get(1);
        String mensaje = "";
        System.err.println(encabezado);
        switch (encabezado) {

            // CU1: Gestionar Usuarios
            case Comandos.INS_USU:
                mensaje = nUsuario.crear(datos);
                break;
            case Comandos.LIST_USU:
                mensaje = nUsuario.listar("Lista Usuarios");
                break;
            case Comandos.MOD_USU:
                mensaje = nUsuario.editar(datos);
                break;
            case Comandos.ELI_USU:
                mensaje = nUsuario.eliminar(datos[0]);
                break;

            //CU2: Gestionar Productos
            case Comandos.INS_PROD:
                if (!verificarAdministrador()) {
                    return "Necesitas tener permisos de administrador para hacer esto";
                }
                mensaje = nProducto.crear(datos);
                break;
            case Comandos.LIST_PROD:
                mensaje = nProducto.listar("Lista Productos");
                break;
            case Comandos.MOD_PROD:
                if (!verificarAdministrador()) {
                    return "Necesitas tener permisos de administrador para hacer esto";
                }
                mensaje = nProducto.editar(datos);
                break;
            case Comandos.ELI_PROD:
                if (!verificarAdministrador()) {
                    return "Necesitas tener permisos de administrador para hacer esto";
                }
                mensaje = nProducto.eliminar(datos[0]);
                break;

            //CU3: Gestionar Pedidos
            case Comandos.INS_PED:
                if (!verificarAdministrador() && !verificarEmpleado()) {
                    return "Necesitas tener permisos de administrador o empleado para hacer esto";
                }
                mensaje = nPedido.crear(datos);
                break;
            case Comandos.LIST_PED:
                mensaje = nPedido.listar("Lista Pedidos");
                break;
            case Comandos.MOD_PED:
                if (!verificarAdministrador() && !verificarEmpleado()) {
                    return "Necesitas tener permisos de administrador o empleado para hacer esto";
                }
                mensaje = nPedido.editar(datos);
                break;
            case Comandos.ELI_PED:
                if (!verificarAdministrador() && !verificarEmpleado()) {
                    return "Necesitas tener permisos de administrador o empleado para hacer esto";
                }
                mensaje = nPedido.eliminar(datos[0]);
                break;
            case Comandos.INS_DETPED:
                if (!verificarAdministrador() && !verificarEmpleado()) {
                    return "Necesitas tener permisos de administrador o empleado para hacer esto";
                }
                mensaje = nDetallePedido.crear(datos);
                break;
            case Comandos.LIST_DETPED:
                if (!verificarAdministrador() && !verificarEmpleado()) {
                    return "Necesitas tener permisos de administrador o empleado para hacer esto";
                }
                mensaje = nDetallePedido.listar(datos[0]);
                break;
            case Comandos.MOD_DETPED:
                if (!verificarAdministrador() && !verificarEmpleado()) {
                    return "Necesitas tener permisos de administrador o empleado para hacer esto";
                }
                mensaje = nDetallePedido.editar(datos);
                break;
            case Comandos.ELI_DETPED:
                if (!verificarAdministrador() && !verificarEmpleado()) {
                    return "Necesitas tener permisos de administrador o empleado para hacer esto";
                }
                mensaje = nDetallePedido.eliminar(datos[0]);
                break;

            //CU4: Gestionar Compras
            case Comandos.INS_COM:
                if (!verificarAdministrador() && !verificarEmpleado()) {
                    return "Necesitas tener permisos de administrador o empleado para hacer esto";
                }
                mensaje = nCompra.crear(datos);
                break;
            case Comandos.LIST_COM:
                mensaje = nCompra.listar("Lista Compras");
                break;
            case Comandos.MOD_COM:
                if (!verificarAdministrador() && !verificarEmpleado()) {
                    return "Necesitas tener permisos de administrador o empleado para hacer esto";
                }
                mensaje = nCompra.editar(datos);
                break;
            case Comandos.ELI_COM:
                if (!verificarAdministrador() && !verificarEmpleado()) {
                    return "Necesitas tener permisos de administrador o empleado para hacer esto";
                }
                mensaje = nCompra.eliminar(datos[0]);
                break;
            case Comandos.INS_DETCOM:
                if (!verificarAdministrador() && !verificarEmpleado()) {
                    return "Necesitas tener permisos de administrador o empleado para hacer esto";
                }
                mensaje = nDetalleCompra.crear(datos);
                break;
            case Comandos.LIST_DETCOM:
                mensaje = nDetalleCompra.listar(datos[0]);
                break;
            case Comandos.MOD_DETCOM:
                if (!verificarAdministrador() && !verificarEmpleado()) {
                    return "Necesitas tener permisos de administrador o empleado para hacer esto";
                }
                mensaje = nDetalleCompra.editar(datos);
                break;
            case Comandos.ELI_DETCOM:
                if (!verificarAdministrador() && !verificarEmpleado()) {
                    return "Necesitas tener permisos de administrador o empleado para hacer esto";
                }
                mensaje = nDetalleCompra.eliminar(datos[0]);
                break;

            //CU5: Gestionar Movimientos
            case Comandos.INS_MOV:
                if (!verificarAdministrador() && !verificarEmpleado()) {
                    return "Necesitas tener permisos de administrador o empleado para hacer esto";
                }
                mensaje = nMovimiento.crear(datos);
                break;
            case Comandos.LIST_MOV:
                mensaje = nMovimiento.listar("Lista Movimientos");
                break;
            case Comandos.MOD_MOV:
                if (!verificarAdministrador() && !verificarEmpleado()) {
                    return "Necesitas tener permisos de administrador o empleado para hacer esto";
                }
                mensaje = nMovimiento.editar(datos);
                break;
            case Comandos.ELI_MOV:
                if (!verificarAdministrador() && !verificarEmpleado()) {
                    return "Necesitas tener permisos de administrador o empleado para hacer esto";
                }
                mensaje = nMovimiento.eliminar(datos[0]);
                break;
            case Comandos.INS_DETMOV:
                if (!verificarAdministrador() && !verificarEmpleado()) {
                    return "Necesitas tener permisos de administrador o empleado para hacer esto";
                }
                mensaje = nDetalleMovimiento.crear(datos);
                break;
            case Comandos.LIST_DETMOV:
                mensaje = nDetalleMovimiento.listar(datos[0]);
                break;
            case Comandos.MOD_DETMOV:
                if (!verificarAdministrador() && !verificarEmpleado()) {
                    return "Necesitas tener permisos de administrador o empleado para hacer esto";
                }
                mensaje = nDetalleMovimiento.editar(datos);
                break;
            case Comandos.ELI_DETMOV:
                mensaje = nDetalleMovimiento.eliminar(datos[0]);
                break;
            
            //CU6: Gestionar Contactos
            case Comandos.INS_CONT:
                if (!verificarAdministrador()) {
                    return "Necesitas tener permisos de administrador para hacer esto";
                }
                mensaje = nContacto.crear(datos);
                break;
            case Comandos.LIST_CONT:
                mensaje = nContacto.listar("Lista Contactos");
                break;
            case Comandos.MOD_CONT:
                if (!verificarAdministrador()) {
                    return "Necesitas tener permisos de administrador para hacer esto";
                }
                mensaje = nContacto.editar(datos);
                break;
            case Comandos.ELI_CONT:
                if (!verificarAdministrador()) {
                    return "Necesitas tener permisos de administrador para hacer esto";
                }
                mensaje = nContacto.eliminar(datos[0]);
                break;
            
            //CU7: Gestionar Categoria
            case Comandos.INS_CAT:
                if (!verificarAdministrador()) {
                    return "Necesitas tener permisos de administrador para hacer esto";
                }
                mensaje = nCategoria.crear(datos);
                break;
            case Comandos.LIST_CAT:
                mensaje = nCategoria.listar("Lista Categorias");
                break;
            case Comandos.MOD_CAT:
                if (!verificarAdministrador()) {
                    return "Necesitas tener permisos de administrador para hacer esto";
                }
                mensaje = nCategoria.editar(datos);
                break;
            case Comandos.ELI_CAT:
                if (!verificarAdministrador()) {
                    return "Necesitas tener permisos de administrador para hacer esto";
                }
                mensaje = nCategoria.eliminar(datos[0]);
                break; 

            //CU8: Gestionar Reportes
            case Comandos.LIST_PRODBYCAT:
                String categoriaid = nCategoria.obtenerIdCategoria(datos[0]);
                mensaje = nProducto.obtenerProductosPorCategoria(categoriaid);
                break;
            case Comandos.LIST_PRODPOPULAR:
                mensaje = nDetallePedido.obtenerProductosPopulares();
                break;
            case Comandos.LIST_PRODREAB:
                mensaje = nProducto.obtenerProductosReabastecimiento();
                break;

            //HELP
            case Comandos.HELP:
                mensaje = help.help();
                break;

            default:
                mensaje = "Comando no renocido, intenta escribir HELP[]";
                break;
        }
        return mensaje;
    }

    private boolean verificarAdministrador(){
        return nUsuario.existeAdministrador(to);
    }

    private boolean verificarEmpleado(){
        return nUsuario.existeEmpleado(to);
    }

    private LinkedList<Object> parseComando() {
        LinkedList<Object> parsedList = new LinkedList<>();
        String sub = this.subject.trim();
        try {
            String[] partesSubject = sub.split("\\[");
            String encabezado = partesSubject[0];
            System.out.println(encabezado);
            String cuerpo[] = partesSubject[1].split("\\]");
            String datos[] = null;
            if (cuerpo.length != 0) {
                datos = cuerpo[0].split("\\;");
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = datos[i].trim();
                    System.out.println(datos[i]);
                }
            }
            parsedList.push(encabezado);
            parsedList.push(datos);
            System.err.println(encabezado);
            System.err.println(datos);
            
        } catch (Exception e) {
            System.out.println(e);
            parsedList.push(sub);
            parsedList.push(null);
        }
        return parsedList; 
    }

    @Override
    public MailSender call() throws Exception {

        String resultadoVerificacion = this.verificarComandos();
        return new MailSender(this.to, "Resultado", resultadoVerificacion);
    }

    
}
