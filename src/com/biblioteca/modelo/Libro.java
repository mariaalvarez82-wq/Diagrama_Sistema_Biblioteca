package com.biblioteca.modelo;

/**
 * Superclase que modela los datos y comportamientos comunes de cualquier
 * libro del catálogo.
 * <p>
 * Relaciones UML:
 * - Autor "1" o-- "0..*" Libro (AGREGACIÓN)
 * - Libro &lt;|-- LibroDigital (HERENCIA)
 * - Libro &lt;|-- LibroFisico (HERENCIA)
 * - Prestamo "1" *-- "1" Libro (COMPOSICIÓN)
 * <p>
 * Se declara ABSTRACTA (pilar de ABSTRACCIÓN) porque en el catálogo real
 * todo libro es, o físico, o digital; "Libro" es solo el concepto común.
 * <p>
 * Implementa {@link Prestable}: aplica el pilar de ENCAPSULAMIENTO, ya que
 * el estado {@code disponible} solo puede cambiar a través de los métodos
 * de negocio {@link #prestar()} y {@link #devolver()}, nunca directamente.
 */
public abstract class Libro implements Prestable {

    protected String idLibro;
    protected String titulo;
    protected Autor autor;
    protected boolean disponible;
    protected String generoLiterario;

    public Libro(String idLibro, String titulo, Autor autor, boolean disponible, String generoLiterario) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = disponible;
        this.generoLiterario = generoLiterario;
    }

    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getGeneroLiterario() {
        return generoLiterario;
    }

    public void setGeneroLiterario(String generoLiterario) {
        this.generoLiterario = generoLiterario;
    }

    /**
     * Comportamiento de negocio: marca el libro como prestado.
     * Lanza una excepción si ya estaba prestado, evitando estados
     * inconsistentes (regla de negocio real, no solo un setter).
     */
    @Override
    public void prestar() {
        if (!disponible) {
            throw new IllegalStateException("El libro '" + titulo + "' no está disponible para préstamo.");
        }
        this.disponible = false;
    }

    /**
     * Comportamiento de negocio: marca el libro como devuelto y por lo
     * tanto disponible nuevamente.
     */
    @Override
    public void devolver() {
        this.disponible = true;
    }

    /**
     * Método abstracto que cada tipo concreto de libro debe sobrescribir
     * ({@code @Override}) para explicar cómo se accede a él. Base del
     * POLIMORFISMO: al recorrer una lista de Libro, cada objeto responde
     * de forma distinta según su clase real (LibroDigital o LibroFisico).
     */
    public abstract String obtenerInstruccionesAcceso();

    @Override
    public String toString() {
        return String.format("\"%s\" de %s [%s] - %s - Disponible: %s",
                titulo, autor.getNombre(), generoLiterario, getClass().getSimpleName(),
                disponible ? "Sí" : "No");
    }
}
