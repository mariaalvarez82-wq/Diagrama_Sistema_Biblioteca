package com.biblioteca.modelo;

/**
 * Superclase que modela los datos comunes de cualquier persona registrada
 * en el sistema de biblioteca.
 * <p>
 * Relaciones UML:
 * - Usuario "1" *-- "1" Direccion (COMPOSICIÓN)
 * - Usuario &lt;|-- UsuarioConPrestamos (HERENCIA)
 * - Usuario &lt;|-- Bibliotecario (HERENCIA)
 * <p>
 * Se declara ABSTRACTA porque en el dominio del negocio nunca existe un
 * "Usuario" genérico: siempre es, o bien un usuario que solicita préstamos,
 * o bien un bibliotecario. Esto aplica el pilar de ABSTRACCIÓN de la POO
 * y evita instanciar un concepto que solo existe para ser especializado.
 * <p>
 * Principio SOLID aplicado - OCP (Open/Closed Principle): el sistema está
 * abierto a nuevos tipos de usuario (por ejemplo, un futuro "UsuarioVIP")
 * simplemente extendiendo esta clase, sin necesidad de modificar el código
 * ya existente que trabaja con la referencia Usuario.
 */
public abstract class Usuario {

    protected String idUsuario;
    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected String correoElectronico;
    protected Direccion direccion;

    public Usuario(String idUsuario, String nombre, String apellido, String telefono,
                   String correoElectronico, Direccion direccion) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Método abstracto que cada subclase debe sobrescribir ({@code @Override})
     * para describir su rol dentro del sistema. Es la base del POLIMORFISMO:
     * el mismo mensaje ("obtenerRolDescripcion") produce respuestas distintas
     * según el objeto real que reciba la llamada en tiempo de ejecución.
     */
    public abstract String obtenerRolDescripcion();

    @Override
    public String toString() {
        return String.format("%s: %s %s (ID: %s, Tel: %s, Email: %s)",
                obtenerRolDescripcion(), nombre, apellido, idUsuario, telefono, correoElectronico);
    }
}
