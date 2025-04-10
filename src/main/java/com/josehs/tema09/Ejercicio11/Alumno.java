package com.josehs.tema09.Ejercicio11;

import java.util.List;

public class Alumno {
    private final int id;
    private final String nombre;
    private final Grupo grupo;
    private final List<Asignatura> asignaturas;

    public Alumno(int id, String nombre, Grupo grupo, List<Asignatura> asignaturas) {
        this.id = id;
        this.nombre = nombre;
        this.grupo = grupo;
        this.asignaturas = asignaturas;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }
}
