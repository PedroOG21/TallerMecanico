package org.iesalandalus.programacion.tallermecanico.modelo.negocio;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Revisiones {
    private Revision revision;
    private List<Revision> revisiones;

    public Revisiones() {
        this.revisiones = new ArrayList<>();
    }

    public List<Revision> get() {
        return new ArrayList<>(this.revisiones);
    }

    public List<Revision> get(Cliente cliente) {
        Objects.requireNonNull(cliente, "El cliente no puede ser nulo.");
        List<Revision> listaRevisionesClientes = new ArrayList<>();
        for (Revision revision : revisiones) {
            if (revision.getCliente().equals(cliente)) {
                listaRevisionesClientes.add(revision);
            }
        }
        return listaRevisionesClientes;
    }

    public List<Revision> get(Vehiculo vehiculo) {
        Objects.requireNonNull(vehiculo, "El vehículo no puede ser nulo.");
        List<Revision> listaRevisionesVehiculos = new ArrayList<>();
        for (Revision revision : revisiones) {
            if (revision.getVehiculo().equals(vehiculo)){
                listaRevisionesVehiculos.add(revision);
            }
        }
        return listaRevisionesVehiculos;
    }

    public void insertar(Revision revision) throws OperationNotSupportedException {
        Objects.requireNonNull(revision, "No se puede insertar una revisión nula.");
        comprobarRevision(revision.getCliente(), revision.getVehiculo(), revision.getFechaInicio());
        revisiones.add(revision);
    }

    private void comprobarRevision(Cliente cliente, Vehiculo vehiculo, LocalDate fechaRevision) throws OperationNotSupportedException {
        for (Revision revision : revisiones) {
            if (revision.getCliente().equals(cliente) && !revision.estaCerrada()) {
                throw new OperationNotSupportedException("El cliente tiene otra revisión en curso.");
            }
            if (revision.getVehiculo().equals(vehiculo) && !revision.estaCerrada()) {
                throw new OperationNotSupportedException("El vehículo está actualmente en revisión.");
            }
            if (revision.estaCerrada() && revision.getCliente().equals(cliente) && !fechaRevision.isAfter(revision.getFechaFin())) {
                throw new OperationNotSupportedException("El cliente tiene una revisión posterior.");
            }
            if (revision.estaCerrada() && revision.getVehiculo().equals(vehiculo) && !fechaRevision.isAfter(revision.getFechaFin())) {
                throw new OperationNotSupportedException("El vehículo tiene una revisión posterior.");
            }
        }
    }


    public Revision getRevision(Revision revision) throws OperationNotSupportedException {
        Objects.requireNonNull(revision, "La revisión no puede ser nula.");
        int indice = revisiones.indexOf(revision);
        if (indice != -1) {
            return revisiones.get(indice);
        }
        throw new OperationNotSupportedException("No existe ninguna revisión igual.");
    }

    public void anadirHoras(Revision revision, int horas) throws OperationNotSupportedException {
        Objects.requireNonNull(revision, "No puedo operar sobre una revisión nula.");
        getRevision(revision).anadirHoras(horas);
    }

    public void anadirPrecioMaterial(Revision revision, float precioMaterial) throws OperationNotSupportedException {
        Objects.requireNonNull(revision, "La revision no puede ser nula.");
        getRevision(revision).anadirPrecioMaterial(precioMaterial);
    }

    public void cerrar(Revision revision, LocalDate fechaFin) throws OperationNotSupportedException {
        Objects.requireNonNull(revision, "No puedo operar sobre una revisión nula.");
        getRevision(revision).cerrar(fechaFin);
    }

    public Revision buscar(Revision revision) {
        Objects.requireNonNull(revision, "No se puede buscar una revisión nula.");
        int indice = revisiones.indexOf(revision);
        if (indice != -1) {
            return revisiones.get(indice);
        } else {
            return null;
        }
    }

    public void borrar(Revision revision) throws OperationNotSupportedException {
        Objects.requireNonNull(revision, "No se puede borrar una revisión nula.");
        int indice = revisiones.indexOf(revision);
        if (indice != -1) {
            revisiones.remove(revision);
        } else {
            throw new OperationNotSupportedException("No existe ninguna revisión igual.");
        }
    }
}
