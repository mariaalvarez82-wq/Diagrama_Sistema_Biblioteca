package com.biblioteca.modelo;

/**
 * Libro en formato digital (ebook).
 * <p>
 * Relación UML: Libro &lt;|-- LibroDigital (HERENCIA).
 */
public class LibroDigital extends Libro {

    private double tamanoArchivoMB;
    private String formato;

    public LibroDigital(String idLibro, String titulo, Autor autor, boolean disponible,
                         String generoLiterario, double tamanoArchivoMB, String formato) {
        super(idLibro, titulo, autor, disponible, generoLiterario);
        this.tamanoArchivoMB = tamanoArchivoMB;
        this.formato = formato;
    }

    public double getTamanoArchivoMB() {
        return tamanoArchivoMB;
    }

    public void setTamanoArchivoMB(double tamanoArchivoMB) {
        this.tamanoArchivoMB = tamanoArchivoMB;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    /**
     * SOBRESCRITURA (@Override): comportamiento específico de un libro
     * digital, distinto del de un libro físico (POLIMORFISMO).
     */
    @Override
    public String obtenerInstruccionesAcceso() {
        return String.format("Descarga el archivo %s (%.1f MB) desde el portal digital de la biblioteca.",
                formato, tamanoArchivoMB);
    }
}
