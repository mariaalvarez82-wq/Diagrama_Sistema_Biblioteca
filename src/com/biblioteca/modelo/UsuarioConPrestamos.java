package com.biblioteca.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Usuario que puede solicitar préstamos de libros.
 * <p>
 * Relaciones UML:
 * - Usuario &lt;|-- UsuarioConPrestamos (HERENCIA)
 * - UsuarioConPrestamos "1" o-- "0..*" Prestamo (AGREGACIÓN: el Prestamo
 *   puede seguir existiendo -por ejemplo, para efectos históricos- aunque
 *   el UsuarioConPrestamos que lo tenía asignado sea eliminado).
 */
public class UsuarioConPrestamos extends Usuario {

    private List<Prestamo> prestamos;

    public UsuarioConPrestamos(String idUsuario, String nombre, String apellido, String telefono,
                                String correoElectronico, Direccion direccion) {
        super(idUsuario, nombre, apellido, telefono, correoElectronico, direccion);
        this.prestamos = new ArrayList<>();
    }

    public void agregarPrestamo(Prestamo prestamo) {
        this.prestamos.add(prestamo);
    }

    public void removerPrestamo(Prestamo prestamo) {
        this.prestamos.remove(prestamo);
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    /**
     * SOBRESCRITURA (@Override) del método abstracto de Usuario:
     * cumple el pilar de POLIMORFISMO.
     */
    @Override
    public String obtenerRolDescripcion() {
        return "Usuario con préstamos";
    }
}
