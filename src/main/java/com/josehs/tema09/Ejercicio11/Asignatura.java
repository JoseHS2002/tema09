package com.josehs.tema09.Ejercicio11;

public class Asignatura {
    private final int id;
    private final String nombre;
    private final Profesor profesor;

    public Asignatura(int id, String nombre, Profesor profesor) {
        this.id = id;
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }
}
