package com.biblioteca.modelo;

/**
 * Libro en formato físico, ubicado en un estante de la biblioteca.
 * <p>
 * Relación UML: Libro &lt;|-- LibroFisico (HERENCIA).
 */
public class LibroFisico extends Libro {

    private String numeroEstante;

    public LibroFisico(String idLibro, String titulo, Autor autor, boolean disponible,
                        String generoLiterario, String numeroEstante) {
        super(idLibro, titulo, autor, disponible, generoLiterario);
        this.numeroEstante = numeroEstante;
    }

    public String getNumeroEstante() {
        return numeroEstante;
    }

    public void setNumeroEstante(String numeroEstante) {
        this.numeroEstante = numeroEstante;
    }

    /**
     * SOBRESCRITURA (@Override): comportamiento específico de un libro
     * físico (POLIMORFISMO).
     */
    @Override
    public String obtenerInstruccionesAcceso() {
        return "Dirígete al estante " + numeroEstante + " para retirar el ejemplar físico.";
    }
}
