package org.iesalandalus.programacion.tallermecanico.vista;

import org.iesalandalus.programacion.tallermecanico.Main;

import java.util.*;

public enum Opcion {
    INSERTAR_CLIENTE,
    BUSCAR_CLIENTE,
    BORRAR_CLIENTE,
    LISTAR_CLIENTES,
    MODIFICAR_CLIENTE,
    INSERTAR_VEHICULO,
    BUSCAR_VEHICULO,
    BORRAR_VEHICULO,
    LISTAR_VEHICULOS,
    INSERTAR_REVISION,
    BUSCAR_REVISION,
    BORRAR_REVISION,
    LISTAR_REVISIONES_CLIENTE,
    LISTAR_REVISIONES_VEHICULO,
    ANADIR_HORAS_REVISION,
    ANADIR_PRECIO_MATERIAL_REVISION,
    CERRAR_REVISION,
    SALIR;
    private int numeroOpcion;
    private String mensaje;

}
