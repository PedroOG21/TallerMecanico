package org.iesalandalus.programacion.tallermecanico.vista;

import org.iesalandalus.programacion.tallermecanico.Main;

import java.util.*;

public enum Opcion {
    INSERTAR_CLIENTE("Insertar cliente", 1),
    BUSCAR_CLIENTE("Buscar cliente", 2),
    BORRAR_CLIENTE("Borrar cliente", 3),
    LISTAR_CLIENTES("Listar clientes", 4),
    MODIFICAR_CLIENTE("Modificar cliente", 5),
    INSERTAR_VEHICULO("Insertar vehículo", 6),
    BUSCAR_VEHICULO("Buscar vehículo", 7),
    BORRAR_VEHICULO("Borrar Vehículo", 8),
    LISTAR_VEHICULOS("Listar Vehículo", 9),
    INSERTAR_REVISION("Insertar revisión", 10),
    BUSCAR_REVISION("Buscar revisión", 11),
    BORRAR_REVISION("Borrar revisión", 12),
    LISTAR_REVISIONES_CLIENTE("Listar revisiones de clientes", 13),
    LISTAR_REVISIONES_VEHICULO("Listar revisiones de vehiculos", 14),
    ANADIR_HORAS_REVISION("Añadir horas", 15),
    ANADIR_PRECIO_MATERIAL_REVISION("Añadir precio material", 16),
    CERRAR_REVISION("Cerrar revision", 17),
    SALIR("Salir", 18);
    private int numeroOpcion;
    private String mensaje;

    public static final Map<Integer, Opcion> opciones;

    static {
        opciones = new HashMap<>();
        for (Opcion opcion : Opcion.values()) {
            opciones.put(opcion.numeroOpcion, opcion);
        }
    }

    Opcion(String mensaje, int opcion) {
        this.numeroOpcion = opcion;
        this.mensaje = mensaje;
    }

    public static boolean esValida(int numeroOpcion) {
        Objects.requireNonNull(numeroOpcion,"No puede ser nula la opción.");
        return opciones.containsKey(numeroOpcion);
    }

    public static Opcion get(int numeroOpcion) {
        Opcion.esValida(numeroOpcion);
        Opcion opcion = opciones.get(numeroOpcion);
        return opcion;
    }

    @Override
    public String toString() {
        return String.format("[%s] --> %s", this.numeroOpcion, this.mensaje);
    }
}
