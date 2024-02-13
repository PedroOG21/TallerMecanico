package org.iesalandalus.programacion.tallermecanico.modelo.negocio;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;

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

    public void insertar(Cliente cliente) {
        Objects.requireNonNull(cliente, "No se puede insertar un cliente nulo.");
        if (cliente != null && !clientes.contains(cliente)) {
            clientes.add(cliente);
        } else {
            throw new IllegalArgumentException("Ya existe un cliente con ese DNI.");
        }
    }

    public boolean modificar(Cliente cliente, String nombre, String telefono) {
        Objects.requireNonNull(cliente, "No se puede modificar un cliente nulo.");
        if (cliente != null && clientes.contains(cliente)) {
            cliente.setNombre(nombre);
            cliente.setTelefono(telefono);
        } else {
            throw new IllegalArgumentException("No existe ningún cliente con ese DNI.");
        }
        return false;
    }

    public Cliente buscar(Cliente cliente) {
        for (Cliente cliente1 : clientes) {
            if (cliente.getDni().equals(cliente.getDni())) {
                return cliente;
            }
        }
        return null;
    }

    public void borrar(Cliente cliente) {
        Objects.requireNonNull(cliente, "No se puede borrar un cliente nulo.");
        if (clientes.contains(cliente)) {
            clientes.remove(cliente);
        } else {
            throw new IllegalArgumentException("No existe ningún cliente con ese DNI.");
        }
    }
}