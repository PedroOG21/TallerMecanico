package org.iesalandalus.programacion.tallermecanico.modelo.negocio;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Clientes {
    private Cliente cliente;
    private List<Cliente> clientes;

    public Clientes() {
        this.clientes = new ArrayList<>();
    }

    public List<Cliente> get() {
        return new ArrayList<>(this.clientes);
    }

    public void insertar(Cliente cliente) throws OperationNotSupportedException {
        Objects.requireNonNull(cliente, "No se puede insertar un cliente nulo.");
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
        } else {
            throw new OperationNotSupportedException("Ya existe un cliente con ese DNI.");
        }
    }

    public boolean modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
        Objects.requireNonNull(cliente, "No se puede modificar un cliente nulo.");
        boolean modificado = false;
        cliente = buscar(cliente);
        if (cliente == null) {
            throw new OperationNotSupportedException("No existe ningún cliente con ese DNI.");
        }
        if (nombre != null && !nombre.isBlank()) {
            cliente.setNombre(nombre);
            modificado = true;
        }
        if (telefono != null && !telefono.isBlank()) {
            cliente.setTelefono(telefono);
            modificado = true;
        }
        return modificado;
    }

    public Cliente buscar(Cliente cliente) {
        Objects.requireNonNull(cliente, "No se puede buscar un cliente nulo.");
        for (Cliente cliente1 : clientes) {
            if (cliente.getDni().equals(cliente.getDni())) {
                return cliente;
            }
        }
        return null;
    }

    public void borrar(Cliente cliente) throws OperationNotSupportedException {
        Objects.requireNonNull(cliente, "No se puede borrar un cliente nulo.");
        if (clientes.contains(cliente)) {
            clientes.remove(cliente);
        } else {
            throw new OperationNotSupportedException("No existe ningún cliente con ese DNI.");
        }
    }
}