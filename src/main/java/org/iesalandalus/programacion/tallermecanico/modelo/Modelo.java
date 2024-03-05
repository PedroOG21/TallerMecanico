package org.iesalandalus.programacion.tallermecanico.modelo;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.tallermecanico.modelo.negocio.Clientes;
import org.iesalandalus.programacion.tallermecanico.modelo.negocio.Revisiones;
import org.iesalandalus.programacion.tallermecanico.modelo.negocio.Vehiculos;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Modelo {
    private Clientes clientes;
    private Revisiones revisiones;
    private Vehiculos vehiculos;

    public Modelo() {
        clientes = new Clientes();
        revisiones = new Revisiones();
        vehiculos = new Vehiculos();
    }

    public void comenzar() {
        clientes = new Clientes();
        revisiones = new Revisiones();
        vehiculos = new Vehiculos();
    }

    public void terminar() {
        System.out.print("Fin.");
    }

    public void insertar(Cliente cliente) throws OperationNotSupportedException {
        clientes.insertar(new Cliente(cliente));
    }

    public void insertar(Vehiculo vehiculo) throws OperationNotSupportedException {
        vehiculos.insertar(vehiculo);
    }

    public void insertar(Revision revision) throws OperationNotSupportedException {
        Cliente cliente = clientes.buscar(revision.getCliente());
        Vehiculo vehiculo = vehiculos.buscar(revision.getVehiculo());

        Revision newRevision = new Revision(revision);
        revisiones.insertar(newRevision);
    }

    public Cliente buscar(Cliente cliente) {
        clientes.buscar(new Cliente(cliente));
        return clientes.buscar(cliente);
    }

    public Vehiculo buscar(Vehiculo vehiculo) {
        return vehiculos.buscar(vehiculo);
    }

    public Revision buscar(Revision revision) {
        revisiones.buscar(new Revision(revision));
        return revisiones.buscar(revision);
    }

    public boolean modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
        clientes.modificar(cliente, nombre, telefono);
        return true;
    }

    public void anadirHoras(Revision revision, int horas) throws OperationNotSupportedException {
        revisiones.anadirHoras(revision, horas);
    }

    public void anadirPrecioMaterial(Revision revision, float precioMaterial) throws OperationNotSupportedException {
        revisiones.anadirPrecioMaterial(revision, precioMaterial);
    }

    public void cerrar(Revision revision, LocalDate fechaFin) throws OperationNotSupportedException {
        revisiones.cerrar(revision, fechaFin);
    }

    public void borrar(Cliente cliente) throws OperationNotSupportedException {
        List<Revision> revisionsToRemove = new ArrayList<>();

        for (Revision revision : revisiones.get(cliente)) {
            revisionsToRemove.add(revision);
        }

        for (Revision revision : revisionsToRemove) {
            revisiones.borrar(revision);
        }

        clientes.borrar(cliente);
    }

    public void borrar(Vehiculo vehiculo) throws OperationNotSupportedException {
        List<Revision> revisionsToRemove = new ArrayList<>();

        for (Revision revision : revisiones.get(vehiculo)) {
            revisionsToRemove.add(revision);
        }

        for (Revision revision : revisionsToRemove) {
            revisiones.borrar(revision);
        }
        vehiculos.borrar(vehiculo);
    }

    public void borrar(Revision revision) throws OperationNotSupportedException {
        revisiones.get(revision.getCliente());
        revisiones.borrar(revision);
    }

    public List<Cliente> getClientes() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        for (Cliente cliente : clientes.get()) {
            listaClientes.add(new Cliente(cliente));
        }
        return listaClientes;
    }

    public List<Vehiculo> getVehiculos() {
        return new ArrayList<>(vehiculos.get());
    }

    public List<Revision> getRevisiones() {
        ArrayList<Revision> listaRevisiones = new ArrayList<>();
        for (Revision revision : revisiones.get()) {
            listaRevisiones.add(new Revision(revision));
        }
        return listaRevisiones;
    }

    public List<Revision> getRevisiones(Cliente cliente) {
        ArrayList<Revision> listaRevisionesCliente = new ArrayList<>();
        for (Revision revision : revisiones.get(cliente)) {
            listaRevisionesCliente.add(new Revision(revision));
        }
        return listaRevisionesCliente;
    }

    public List<Revision> getRevisiones(Vehiculo vehiculo) {
        ArrayList<Revision> listaRevisionesVehiculo = new ArrayList<>();
        for (Revision revision : revisiones.get(vehiculo)) {
            listaRevisionesVehiculo.add(new Revision(revision));
        }
        return listaRevisionesVehiculo;
    }
}
