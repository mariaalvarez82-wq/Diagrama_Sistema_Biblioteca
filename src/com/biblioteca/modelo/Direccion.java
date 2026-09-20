package com.biblioteca.modelo;

/**
 * Representa la dirección física de un {@link Usuario}.
 * <p>
 * Relación UML: Usuario "1" *-- "1" Direccion (COMPOSICIÓN).
 * Una Direccion no tiene sentido de vida fuera de su Usuario: cuando el
 * Usuario se destruye, su Direccion se destruye con él.
 * <p>
 * Principio SOLID aplicado - SRP (Single Responsibility Principle):
 * esta clase tiene una única razón para cambiar: la forma en que se
 * representa una dirección postal.
 */
public class Direccion {

    private String calle;
    private String carrera;
    private String barrio;

    public Direccion(String calle, String carrera, String barrio) {
        this.calle = calle;
        this.carrera = carrera;
        this.barrio = barrio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    @Override
    public String toString() {
        return "Calle " + calle + " # " + carrera + ", Barrio " + barrio;
    }
}
