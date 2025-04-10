package com.josehs.tema09.Ejercicio11;

public class Aula {
    private final int id;
    private final int metrosCuadrados;
    private final int cantidadMesas;
    private final int capacidadEstudiantes;

    public Aula(int id, int metrosCuadrados) {
        this.id = id;
        this.metrosCuadrados = metrosCuadrados;
        this.cantidadMesas = calcularCantidadMesas(metrosCuadrados);
        this.capacidadEstudiantes = cantidadMesas;
    }

    private int calcularCantidadMesas(int metrosCuadrados) {
        return metrosCuadrados / 54;
    }

    public int getId() {
        return id;
    }

    public int getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public int getCantidadMesas() {
        return cantidadMesas;
    }

    public int getCapacidadEstudiantes() {
        return capacidadEstudiantes;
    }
}
