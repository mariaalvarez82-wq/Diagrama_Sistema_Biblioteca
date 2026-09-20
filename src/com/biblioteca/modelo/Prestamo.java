package com.biblioteca.modelo;

/**
 * Representa el préstamo de un libro a un usuario, registrado por un
 * bibliotecario.
 * <p>
 * Relaciones UML:
 * - Prestamo "1" *-- "1" Libro (COMPOSICIÓN): el Prestamo es dueño de la
 *   referencia al Libro durante su ciclo de vida.
 * - UsuarioConPrestamos "1" o-- "0..*" Prestamo (AGREGACIÓN)
 * - Prestamo "0..*" --&gt; "1" Bibliotecario (ASOCIACIÓN)
 * <p>
 * Principio SOLID aplicado - SRP: esta clase se encarga únicamente de la
 * lógica de un préstamo (fechas, libro asociado, bibliotecario que lo
 * gestiona); no conoce ni valida datos personales del usuario ni del
 * catálogo completo de libros.
 */
public class Prestamo {

    private String fechaPrestamo;
    private String fechaDevolucion;
    private Libro libro;
    private Bibliotecario bibliotecario;

    public Prestamo(String fechaPrestamo, String fechaDevolucion, Libro libro, Bibliotecario bibliotecario) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.libro = libro;
        this.bibliotecario = bibliotecario;
    }

    /**
     * SOBRECARGA (overload) del constructor anterior: mismo nombre de
     * "método" (constructor), distinta lista de parámetros. Se usa cuando
     * el préstamo se registra sin fecha de devolución aún definida.
     */
    public Prestamo(String fechaPrestamo, Libro libro, Bibliotecario bibliotecario) {
        this(fechaPrestamo, null, libro, bibliotecario);
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    /**
     * Comportamiento de negocio: efectúa el préstamo delegando en el
     * propio Libro (que sabe cómo validar y cambiar su disponibilidad).
     * Esto respeta el ENCAPSULAMIENTO: Prestamo no manipula el atributo
     * "disponible" directamente.
     */
    public void registrarPrestamo() {
        libro.prestar();
    }

    /**
     * Comportamiento de negocio: registra la devolución del libro y fija
     * la fecha de devolución real.
     */
    public void registrarDevolucion(String fechaDevolucionReal) {
        libro.devolver();
        this.fechaDevolucion = fechaDevolucionReal;
    }

    @Override
    public String toString() {
        return String.format("Préstamo[libro='%s', prestado=%s, devuelto=%s, bibliotecario=%s %s]",
                libro.getTitulo(), fechaPrestamo,
                fechaDevolucion == null ? "pendiente" : fechaDevolucion,
                bibliotecario.getNombre(), bibliotecario.getApellido());
    }
}
