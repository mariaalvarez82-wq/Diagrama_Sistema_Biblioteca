package com.biblioteca.modelo;

/**
 * Empleado de la biblioteca encargado de registrar préstamos.
 * <p>
 * Relaciones UML:
 * - Usuario &lt;|-- Bibliotecario (HERENCIA)
 * - Prestamo "0..*" --&gt; "1" Bibliotecario (ASOCIACIÓN)
 */
public class Bibliotecario extends Usuario {

    private String idEmpleado;
    private String turnoTrabajo;

    public Bibliotecario(String idUsuario, String nombre, String apellido, String telefono,
                          String correoElectronico, Direccion direccion,
                          String idEmpleado, String turnoTrabajo) {
        super(idUsuario, nombre, apellido, telefono, correoElectronico, direccion);
        this.idEmpleado = idEmpleado;
        this.turnoTrabajo = turnoTrabajo;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getTurnoTrabajo() {
        return turnoTrabajo;
    }

    public void setTurnoTrabajo(String turnoTrabajo) {
        this.turnoTrabajo = turnoTrabajo;
    }

    /**
     * SOBRESCRITURA (@Override) del método abstracto de Usuario:
     * misma firma que en UsuarioConPrestamos, pero comportamiento distinto
     * (POLIMORFISMO).
     */
    @Override
    public String obtenerRolDescripcion() {
        return "Bibliotecario";
    }
}
