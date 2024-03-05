package org.iesalandalus.programacion.tallermecanico.modelo.negocio;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vehiculos {
    private Vehiculo vehiculo;
    private List<Vehiculo> vehiculos;

    public Vehiculos() {
        this.vehiculos = new ArrayList<>();
    }

    public List<Vehiculo> get() {
        return new ArrayList<>(this.vehiculos);
    }

    public void insertar(Vehiculo vehiculo) throws OperationNotSupportedException {
        Objects.requireNonNull(vehiculo, "No se puede insertar un vehículo nulo.");
        if (vehiculo != null && !vehiculos.contains(vehiculo)) {
            vehiculos.add(vehiculo);
        } else {
            throw new OperationNotSupportedException("Ya existe un vehículo con esa matrícula.");
        }
    }

    public Vehiculo buscar(Vehiculo vehiculo) {
        Objects.requireNonNull(vehiculo, "No se puede buscar un vehículo nulo.");
        for (Vehiculo vehiculo1 : vehiculos) {
            if (vehiculo.matricula().equals(vehiculo.matricula())) {
                return vehiculo;
            }
        }
        return null;
    }

    public void borrar(Vehiculo vehiculo) throws OperationNotSupportedException {
        Objects.requireNonNull(vehiculo, "No se puede borrar un vehículo nulo.");
        if (vehiculos.contains(vehiculo)) {
            vehiculos.remove(vehiculo);
        } else {
            throw new OperationNotSupportedException("No existe ningún vehículo con esa matrícula.");
        }
    }
}
