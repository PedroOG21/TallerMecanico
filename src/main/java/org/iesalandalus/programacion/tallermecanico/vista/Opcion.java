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
    LISTAR_REVISIONES("Listar revisiones", 18),
    SALIR("Salir", 19);
    private final int numeroOpcion;
    private final String mensaje;

    public static final Map<Integer, Opcion> opciones = new HashMap<>();

    static {
        for (Opcion opcion : Opcion.values()) {
            opciones.put(opcion.numeroOpcion, opcion);
        }
    }

    private Opcion(String mensaje, int numeroOpcion) {
        this.numeroOpcion = numeroOpcion;
        this.mensaje = mensaje;
    }

    public static boolean esValida(int numeroOpcion) {
        return opciones.containsKey(numeroOpcion);
    }

    public static Opcion get(int numeroOpcion) {
        if (!esValida(numeroOpcion)) {
            throw new IllegalArgumentException("El número de la opción no es correcto.");
        }
        return opciones.get(numeroOpcion);
    }

    @Override
    public String toString() {
        return String.format("%d.- %s%n", this.numeroOpcion, this.mensaje);
    }
}
