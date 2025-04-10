package com.josehs.tema09.benchmark;

import java.util.*;

public class BenchmarkTarea {
    public static void main(String[] args) {
        System.out.println("Prueba de los Set");
        benchmarkSet();
        System.out.println("\nPrueba de los List");
        benchmarkList();
        System.out.println("\nPrueba de los Map");
        benchmarkMap();
    }

    /**
     * Probamos los tiempos de los Set
     */
    private static void benchmarkSet() {
        //Iniciamos los hashSet, linkedHashSet y treeSet
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        //empezamos a contar los nanosegundos
        long startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            //añadimos elementos
            hashSet.add("Elemento " + i);
        }
        //terminamos de contar los nanosegundos
        long endTime = System.nanoTime();
        //indicamos cuanto tiempo ha llevado la inserción
        System.out.println("Tiempo de inserción HashSet: " + (endTime - startTime) + " nanosegundos");

        startTime = System.nanoTime();
        //buscamos uno de los elementos del String
        hashSet.contains("Elemento 50");
        endTime = System.nanoTime();
        System.out.println("Tiempo de búsqueda HashSet: " + (endTime - startTime) + " nanosegundos");

        startTime = System.nanoTime();
        //borramos uno de los elemetos del String
        hashSet.remove("Elemento 50");
        endTime = System.nanoTime();
        System.out.println("Tiempo de borrado HashSet: " + (endTime - startTime) + " nanosegundos");
    }

    /**
     * Probamos los tiempos de los List
     */
    private static void benchmarkList() {
        //Iniciamos los arrayList, linkedList
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        long startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            arrayList.add("Elemento " + i);
        }
        long endTime = System.nanoTime();
        System.out.println("Tiempo de inserción ArrayList: " + (endTime - startTime) + " nanosegundos");

        startTime = System.nanoTime();
        arrayList.contains("Elemento 50");
        endTime = System.nanoTime();
        System.out.println("Tiempo de búsqueda ArrayList: " + (endTime - startTime) + " nanosegundos");

        startTime = System.nanoTime();
        arrayList.remove("Elemento 50");
        endTime = System.nanoTime();
        System.out.println("Tiempo de borrado ArrayList: " + (endTime - startTime) + " nanosegundos");
    }

    /**
     * Probamos los tiempos de los Map
     */
    private static void benchmarkMap() {
        //Iniciamos los hashMap, linkedHashMap y treeMap
        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        Map<String, Integer> treeMap = new TreeMap<>();

        long startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            hashMap.put("Elemento " + i, i);
        }
        long endTime = System.nanoTime();
        System.out.println("Tiempo de inserción HashMap: " + (endTime - startTime) + " nanosegundos");

        startTime = System.nanoTime();
        hashMap.get("Elemento 50");
        endTime = System.nanoTime();
        System.out.println("Tiempo de búsqueda HashMap: " + (endTime - startTime) + " nanosegundos");

        startTime = System.nanoTime();
        hashMap.remove("Elemento 50");
        endTime = System.nanoTime();
        System.out.println("Tiempo de borrado HashMap: " + (endTime - startTime) + " nanosegundos");
    }
}
