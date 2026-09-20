package com.biblioteca.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Autor de uno o varios libros.
 * <p>
 * Relación UML: Autor "1" o-- "0..*" Libro (AGREGACIÓN). Un Libro puede
 * existir de forma independiente de la lista que mantiene el Autor
 * (a diferencia de una composición), por eso se modela con una lista que
 * el Autor simplemente "agrega", sin ser dueño exclusivo del ciclo de vida
 * de cada Libro.
 */
public class Autor {

    private String idAutor;
    private String nombre;
    private String nacionalidad;
    private List<Libro> libros;

    public Autor(String idAutor, String nombre, String nacionalidad) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.libros = new ArrayList<>();
    }

    public String getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(String idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    /**
     * Agrega un único libro a la lista de obras del autor.
     */
    public void agregarLibro(Libro libro) {
        if (libro != null && !libros.contains(libro)) {
            libros.add(libro);
        }
    }

    /**
     * SOBRECARGA (overload) del método anterior: mismo nombre, distinta
     * lista de parámetros (recibe varios libros en una sola llamada).
     * Cumple el requisito de sobrecarga de métodos.
     */
    public void agregarLibro(List<Libro> nuevosLibros) {
        for (Libro libro : nuevosLibros) {
            agregarLibro(libro);
        }
    }

    @Override
    public String toString() {
        return nombre + " (" + nacionalidad + ")";
    }
}
