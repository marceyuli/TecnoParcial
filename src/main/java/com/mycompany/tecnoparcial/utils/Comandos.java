package com.mycompany.tecnoparcial.utils;

public class Comandos {
    public static final String INS_USU = "INS_USU";
    public static final String LIST_USU = "LIST_USU";
    public static final String MOD_USU = "MOD_USU";
    public static final String ELI_USU = "ELI_USU";
    public static final String INS_PROD = "INS_PROD";
    public static final String LIST_PROD = "LIST_PROD";
    public static final String MOD_PROD = "MOD_PROD";
    public static final String ELI_PROD = "ELI_PROD";
    public static final String INS_PED = "INS_PED";
    public static final String LIST_PED = "LIST_PED";
    public static final String MOD_PED = "MOD_PED";
    public static final String ELI_PED = "ELI_PED";
    public static final String INS_DETPED = "INS_DETPED";
    public static final String LIST_DETPED = "LIST_DETPED";
    public static final String MOD_DETPED = "MOD_DETPED";
    public static final String ELI_DETPED = "ELI_DETPED";
    public static final String INS_COM = "INS_COM";
    public static final String LIST_COM = "LIST_COM";
    public static final String MOD_COM = "MOD_COM";
    public static final String ELI_COM = "ELI_COM";
    public static final String INS_DETCOM = "INS_DETCOM";
    public static final String LIST_DETCOM = "LIST_DETCOM";
    public static final String MOD_DETCOM = "MOD_DETCOM";
    public static final String ELI_DETCOM = "ELI_DETCOM";
    public static final String INS_MOV = "INS_MOV";
    public static final String LIST_MOV = "LIST_MOV";
    public static final String MOD_MOV = "MOD_MOV";
    public static final String ELI_MOV = "ELI_MOV";
    public static final String INS_DETMOV = "INS_DETMOV";
    public static final String LIST_DETMOV = "LIST_DETMOV";
    public static final String MOD_DETMOV = "MOD_DETMOV";
    public static final String ELI_DETMOV = "ELI_DETMOV";
    public static final String INS_CONT = "INS_CONT";
    public static final String LIST_CONT = "LIST_CONT";
    public static final String MOD_CONT = "MOD_CONT";
    public static final String ELI_CONT = "ELI_CONT";
    public static final String INS_CAT = "INS_CAT";
    public static final String LIST_CAT = "LIST_CAT";
    public static final String MOD_CAT = "MOD_CAT";
    public static final String ELI_CAT = "ELI_CAT";

    public static final String LIST_PRODBYCAT = "LIST_PRODBYCAT";
    public static final String LIST_PRODPOPULAR = "LIST_PRODPOPULAR";
    public static final String LIST_PRODREAB = "LIST_PRODREAB";
    public static final String LIST_STOCK = "LIST_STOCK";


    public static final String HELP = "HELP";

    public static final String[][] listaComandos = {
        {"Caso de uso", "Metodo", "Comando"},
        //CU1 Gestionar Usuarios
        {"CU1 Gestionar Usuario", "Registrar Usuario", "INS_USU[String nombre; String apellidoPaterno; String apellidoMaterno; String direccion; String email; String cargo; String contrasena]"},
        {"CU1 Gestionar Usuario", "Listar Usuario", "LIST_USU[]"},
        {"CU1 Gestionar Usuario", "Modificar Usuario", "MOD_USU[int id; String nombre; String apellidoPaterno; String apellidoMaterno; String direccion; String email; String cargo; String contrasena]"},
        {"CU1 Gestionar Usuario", "Eliminar Usuario", "ELI_USU[int id]"},

        //CU2 Gestionar Productos
        {"CU2 Gestionar Producto", "Registrar Producto", "INS_PROD[int usuarioid; int categoriaid; String nombre; String descripcion; int cantidad; double precio]"},
        {"CU2 Gestionar Producto", "Listar Producto", "LIST_PROD[]"},
        {"CU2 Gestionar Producto", "Modificar Producto", "MOD_PROD[int id; int usuarioid; int categoriaid; String nombre; String descripcion; int cantidad; double precio]"},
        {"CU2 Gestionar Producto", "Eliminar Producto", "ELI_PROD[int id]"},

        //CU3 Gestionar Pedidos
        {"CU3 Gestionar Pedido", "Registrar Pedido", "INS_PED[int contactoid; Date fecha[AAAA-MM-DD]; String estado]"},
        {"CU3 Gestionar Pedido", "Listar Pedido", "LIST_PED[]"},
        {"CU3 Gestionar Pedido", "Modificar Pedido", "MOD_PED[int id; int contactoid; Date fecha[AAAA-MM-DD]; String estado]"},
        {"CU3 Gestionar Pedido", "Eliminar Pedido", "ELI_PED[int id]"},
        {"CU3 Gestionar Pedido", "Registrar Detalle de Pedido", "INS_DETPED[int pedidoid; int productoid; int cantidad; double precio]"},
        {"CU3 Gestionar Pedido", "Listar Detalle de Pedido", "LIST_DETPED[int id]"},
        {"CU3 Gestionar Pedido", "Modificar Detalle de Pedido", "MOD_DETPED[int id; int pedidoid; int productoid; int cantidad; double precio]"},
        {"CU3 Gestionar Pedido", "Eliminar Detalle de Pedido", "ELI_DETPED[int id]"},

        //CU4 Gestionar Compras
        {"CU4 Gestionar Compra", "Registrar Compra", "INS_COM[int contactoid; Date fecha[AAAA-MM-DD]]"},
        {"CU4 Gestionar Compra", "Listar Compra", "LIST_COM[]"},
        {"CU4 Gestionar Compra", "Modificar Compra", "MOD_COM[int id; int contactoid; Date fecha[AAAA-MM-DD]]"},
        {"CU4 Gestionar Compra", "Eliminar Compra", "ELI_COM[int id]"},
        {"CU4 Gestionar Compra", "Registrar Detalle de Compra", "INS_DETCOM[int compraid; int productoid; int cantidad; double precio]"},
        {"CU4 Gestionar Compra", "Listar Detalle de Compra", "LIST_DETCOM[int id]"},
        {"CU4 Gestionar Compra", "Modificar Detalle de Compra", "MOD_DETCOM[int id; int compraid; int productoid; int cantidad; double precio]"},
        {"CU4 Gestionar Compra", "Eliminar Detalle de Compra", "ELI_DETCOM[int id]"},

        //CU5 Gestionar Movimientos
        {"CU5 Gestionar Movimiento", "Registrar Movimiento", "INS_MOV[String tipo; Date fecha[AAAA-MM-DD]]"},
        {"CU5 Gestionar Movimiento", "Listar Movimiento", "LIST_MOV[]"},
        {"CU5 Gestionar Movimiento", "Modificar Movimiento", "MOD_MOV[int id; String tipo; Date fecha[AAAA-MM-DD]]"},
        {"CU5 Gestionar Movimiento", "Eliminar Movimiento", "ELI_MOV[int id]"},
        {"CU5 Gestionar Movimiento", "Registar Detalle de Movimiento", "INS_DETMOV[int movimientoid; int productoid; int cantidad]"},
        {"CU5 Gestionar Movimiento", "Listar Detalle de Movimiento", "LIST_DETMOV[int id]"},
        {"CU5 Gestionar Movimiento", "Modificar Detalle de Movimiento", "MOD_DETMOV[int id; int movimientoid; int productoid; int cantidad]"},
        {"CU5 Gestionar Movimiento", "Eliminar Detalle de Movimiento", "ELI_DETMOV[int id]"},

        //CU6 Gestionar Contactos
        {"CU6 Gestionar Contacto", "Registrar Contacto", "INS_CONT[String tipo; String nombre; String apellidoPaterno; String apellidoMaterno; String direccion; String telefono]"},
        {"CU6 Gestionar Contacto", "Listar Contacto", "LIST_CONT[]"},
        {"CU6 Gestionar Contacto", "Modificar Contacto", "MOD_CONT[int id; String tipo; String nombre; String apellidoPaterno; String apellidoMaterno; String direccion; String telefono]"},
        {"CU6 Gestionar Contacto", "Eliminar Contacto", "ELI_CONT[int id]"},

        //CU7 Gestionar Categoria
        {"CU7 Gestionar Categoria", "Registrar Categoria", "INS_CAT[String nombre; String descripcion]"},
        {"CU7 Gestionar Categoria", "Listar Categoria", "LIST_CAT[]"},
        {"CU7 Gestionar Categoria", "Modificar Categoria", "MOD_CAT[int id; String nombre; String descripcion]"},
        {"CU7 Gestionar Categoria", "Eliminar Categoria", "ELI_CAT[int id]"},

        //CU8 Gestionar Reportes
        {"CU8 Gestionar Reportes", "Listar Productos por categoria", "LIST_PRODBYCAT[String categoria]"},
        {"CU8 Gestionar Reportes", "Listar Productos mas vendidos", "LIST_PRODPOPULAR[]"},
        {"CU8 Gestionar Reportes", "Listar Productos que necesitan reabastecimiento", "LIST_PRODREAB[]"},
        {"CU8 Gestionar Reportes", "Listar Stock", "LIST_STOCK[]"},
    };
    
}
