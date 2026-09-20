package com.biblioteca.app;

import com.biblioteca.modelo.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de prueba que instancia los objetos del sistema y demuestra:
 * - Herencia y sobrescritura (@Override)
 * - Sobrecarga de métodos y constructores
 * - Composición y agregación
 * - Polimorfismo
 * - Encapsulamiento
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=== SISTEMA DE BIBLIOTECA ===\n");

        // ---- Direcciones (composición: Usuario *-- Direccion) ----
        Direccion direccionAna = new Direccion("Calle 10", "20-30", "El Poblado");
        Direccion direccionCarlos = new Direccion("Carrera 45", "12-08", "Laureles");

        // ---- Autores ----
        Autor gabo = new Autor("A01", "Gabriel García Márquez", "Colombiana");
        Autor isabel = new Autor("A02", "Isabel Allende", "Chilena");

        // ---- Libros (herencia: Libro <|-- LibroDigital / LibroFisico) ----
        LibroFisico cienAnios = new LibroFisico(
                "L01", "Cien años de soledad", gabo, true, "Realismo mágico", "3B-12");

        LibroDigital laCasa = new LibroDigital(
                "L02", "La casa de los espíritus", isabel, true, "Realismo mágico", 2.4, "EPUB");

        LibroFisico eloraculo = new LibroFisico(
                "L03", "El amor en los tiempos del cólera", gabo, true, "Romance", "3B-15");

        // Agregación: Autor o-- Libro (sobrecarga de agregarLibro)
        gabo.agregarLibro(cienAnios);
        gabo.agregarLibro(eloraculo);
        isabel.agregarLibro(laCasa);

        // ---- Usuarios (herencia: Usuario <|-- UsuarioConPrestamos / Bibliotecario) ----
        UsuarioConPrestamos ana = new UsuarioConPrestamos(
                "U01", "Ana", "Martínez", "3001112233", "ana.martinez@mail.com", direccionAna);

        Bibliotecario carlos = new Bibliotecario(
                "B01", "Carlos", "Pérez", "3004445566", "carlos.perez@biblioteca.com",
                direccionCarlos, "E01", "Mañana");

        System.out.println(ana);
        System.out.println(carlos);
        System.out.println();

        // ---- Préstamo (composición: Prestamo *-- Libro | asociación: Prestamo --> Bibliotecario) ----
        Prestamo prestamo1 = new Prestamo("2026-09-01", cienAnios, carlos); // constructor sobrecargado
        prestamo1.registrarPrestamo();
        ana.agregarPrestamo(prestamo1); // agregación: UsuarioConPrestamos o-- Prestamo

        Prestamo prestamo2 = new Prestamo("2026-09-05", "2026-09-20", laCasa, carlos);
        prestamo2.registrarPrestamo();
        ana.agregarPrestamo(prestamo2);

        System.out.println("--- Préstamos activos de " + ana.getNombre() + " ---");
        for (Prestamo p : ana.getPrestamos()) {
            System.out.println(p);
        }
        System.out.println();

        // ---- Polimorfismo: una lista de Libro contiene objetos LibroFisico y LibroDigital ----
        List<Libro> catalogo = new ArrayList<>();
        catalogo.add(cienAnios);
        catalogo.add(laCasa);
        catalogo.add(eloraculo);

        System.out.println("--- Catálogo e instrucciones de acceso (POLIMORFISMO) ---");
        for (Libro libro : catalogo) {
            System.out.println(libro);
            System.out.println("  -> " + libro.obtenerInstruccionesAcceso()); // cada subclase responde distinto
        }
        System.out.println();

        // ---- Devolución de un libro ----
        System.out.println("--- Devolviendo '" + cienAnios.getTitulo() + "' ---");
        prestamo1.registrarDevolucion("2026-09-15");
        System.out.println("¿Disponible ahora?: " + cienAnios.isDisponible());
        System.out.println(prestamo1);
        System.out.println();

        // ---- Intentar prestar un libro ya prestado (regla de negocio encapsulada) ----
        System.out.println("--- Probando regla de negocio: prestar un libro ya prestado ---");
        try {
            laCasa.prestar(); // ya estaba prestado por prestamo2
        } catch (IllegalStateException e) {
            System.out.println("Error controlado: " + e.getMessage());
        }
    }
}
