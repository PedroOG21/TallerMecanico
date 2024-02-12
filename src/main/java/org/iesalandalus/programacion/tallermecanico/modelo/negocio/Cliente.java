package org.iesalandalus.programacion.tallermecanico.modelo.negocio;

import java.util.Objects;

public class Cliente {
    private static final String ER_NOMBRE = "(([A-Z][a-záéíóú]+)( [A-Z][a-záéíóú]+)*)";
    private static final String ER_DNI = "\\d{8}[A-Z]";
    private static final String ER_TELEFONO = "\\d{9}";
    private String nombre;
    private String dni;
    private String telefono;

    public Cliente(String nombre, String dni, String telefono) {
        setNombre(nombre);
        setDni(dni);
        setTelefono(telefono);
    }

    public Cliente (Cliente cliente){
        Objects.requireNonNull(cliente,"No es posible copiar un cliente nulo.");
        setDni(cliente.dni);
        setTelefono(cliente.telefono);
        setNombre(cliente.nombre);
    }

    public void setTelefono(String telefono) {
        Objects.requireNonNull(telefono,"El teléfono no puede ser nulo.");
        if (!telefono.matches(ER_TELEFONO)) {
            throw new IllegalArgumentException("El teléfono no tiene un formato válido.");
        }
        this.telefono = telefono;
    }

    private boolean comprobarLetraDni(String dni) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int numDni = Integer.parseInt(dni.substring(0, 8));
        int resto = numDni % 23;
        return letras.charAt(resto) == dni.charAt(8);
    }

    private void setDni(String dni) {
        Objects.requireNonNull(dni,"El DNI no puede ser nulo.");
        if (!dni.matches(ER_DNI)) {
            throw new IllegalArgumentException("El DNI no tiene un formato válido.");
        }
        if (!comprobarLetraDni(dni)){
            throw new IllegalArgumentException("La letra del DNI no es correcta.");
        }
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        Objects.requireNonNull(nombre,"El nombre no puede ser nulo.");

        if (!nombre.matches(ER_NOMBRE)) {
            throw new IllegalArgumentException("El nombre no tiene un formato válido.");
        }
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public static Cliente get (String dni){
       return new Cliente("Juan Pérez",dni,"638290372");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return Objects.equals(dni,cliente.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s)", this.nombre, this.dni, this.telefono);
    }
}