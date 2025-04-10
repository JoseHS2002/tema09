package com.josehs.tema09.Ejercicio11;

public class Profesor {
    private final String dni;
    private final String nombre;
    private final double sueldo;

    public Profesor(String dni, String nombre, double sueldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }
}
