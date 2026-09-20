package com.biblioteca.modelo;

/**
 * Contrato mínimo que debe cumplir cualquier material que pueda prestarse
 * en la biblioteca.
 * <p>
 * Principios SOLID aplicados:
 * - ISP (Interface Segregation Principle): la interfaz es pequeña y
 *   específica -solo agrupa lo relacionado con el ciclo de préstamo-, en
 *   vez de forzar a Libro a implementar métodos que no necesita.
 * - DIP (Dependency Inversion Principle): clases de más alto nivel (como
 *   {@link Prestamo}) pueden razonar en términos de esta abstracción en
 *   lugar de depender directamente de una implementación concreta.
 */
public interface Prestable {

    void prestar();

    void devolver();

    boolean isDisponible();
}
