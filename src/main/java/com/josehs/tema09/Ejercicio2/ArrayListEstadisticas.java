package com.josehs.tema09.Ejercicio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/*Implementas estadisticas de tipo double*/
public class ArrayListEstadisticas implements IEstadisticas{
    public static void main(String[] args) {
        ArrayList<Double> datos = new ArrayList<>();
        datos.add(1.0);
        datos.add(2.5);
        datos.add(3.0);
        datos.add(2.5);
        datos.add(1.0);

        ArrayListEstadisticas estadisticas = new ArrayListEstadisticas(datos);

        System.out.println("Mínimo: " + estadisticas.minimo());
        System.out.println("Máximo: " + estadisticas.maximo());
        System.out.println("Sumatorio: " + estadisticas.sumatorio());
        System.out.println("Media: " + estadisticas.media());
        //System.out.println("Moda: " + estadisticas.moda());
    }

    private ArrayList<Double> datos;

    public ArrayListEstadisticas(ArrayList<Double> datos) {
        this.datos = datos;
    }

    @Override
    public double minimo() {
        return Collections.min(datos);
    }

    @Override
    public double maximo() {
        return Collections.max(datos);
    }

    @Override
    public double sumatorio() {
        double suma = 0;
        for (Double dato : datos) {
            suma += dato;
        }
        return suma;
    }

    @Override
    public double media() {

        return sumatorio() / datos.size();
    }
/*
    @Override
    public double moda() {

        if (datos.isEmpty()) {
            return Double.NaN;
        }

        Map<Double, Integer> popularidad = new HashMap<>();
        for (Double dato : datos) {
            popularidad.put(dato, popularidad);
        }

        double moda = datos.get(0);
        int popularidadMax = 1;
        for (Map.Entry<Double, Integer> entry : popularidadMax.entrySet()) {
            if (entry.getValue() > popularidadMax) {
                moda = entry.getKey();
                popularidadMax = entry.getValue();
            }
        }
        return moda;

    }
    }
    */

}
