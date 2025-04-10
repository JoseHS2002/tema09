package com.josehs.tema09.Ejercicio11;

public class Grupo {
    private final int id;
    private final String nombre;
    private final Aula aula;

    public Grupo(int id, String nombre, Aula aula) {
        this.id = id;
        this.nombre = nombre;
        this.aula = aula;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Aula getAula() {
        return aula;
    }
}
