package com.josehs.tema09.Ejercicio9;

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class diccionarioGame {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        HashMap<String, String> diccionario = new HashMap<>();
        ArrayList<Puntuacion> mejoresPuntuaciones = new ArrayList<>();

        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    anyadirPalabra(diccionario);
                    break;
                case 2:
                    modificarPalabra(diccionario);
                    break;
                case 3:
                    eliminarPalabra(diccionario);
                    break;
                case 4:
                    consultarPalabra(diccionario);
                    break;
                case 5:
                    mostrarDiccionario(diccionario);
                    break;
                case 6:
                    jugar(diccionario, mejoresPuntuaciones);
                    break;
                case 7:
                    mostrarMejoresPuntuaciones(mejoresPuntuaciones);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elige una opción válida.");
            }
        } while (opcion != 0);
    }

    private static class Puntuacion {
        String nombre;
        int puntuacion;

        public Puntuacion(String nombre, int puntuacion) {
            this.nombre = nombre;
            this.puntuacion = puntuacion;
        }
    }

    private static void mostrarMenu() {
        System.out.println("*********************");
        System.out.println("* JUEGO DICCIONARIO *");
        System.out.println("*********************");
        System.out.println("1. Añadir palabra");
        System.out.println("2. Modificar palabra");
        System.out.println("3. Eliminar palabra");
        System.out.println("4. Consultar palabra");
        System.out.println("5. Mostrar diccionario");
        System.out.println("6. Jugar");
        System.out.println("7. Mejores puntuaciones");
        System.out.println("---------------------");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
    }

    private static void anyadirPalabra(HashMap<String, String> diccionario) {
        System.out.print("Introduce la palabra: ");
        String palabra = scanner.nextLine();

        if (diccionario.containsKey(palabra)) {
            System.out.println("Error: La palabra ya existe en el diccionario.");
        } else {
            System.out.print("Introduce la definición: ");
            String definicion = scanner.nextLine();
            diccionario.put(palabra, definicion);
            System.out.println("Palabra añadida correctamente.");
        }
    }

    private static void modificarPalabra(HashMap<String, String> diccionario) {
        System.out.print("Introduce la palabra a modificar: ");
        String palabra = scanner.nextLine();

        if (diccionario.containsKey(palabra)) {
            System.out.print("Introduce la nueva definición: ");
            String definicion = scanner.nextLine();
            diccionario.put(palabra, definicion);
            System.out.println("Palabra modificada correctamente.");
        } else {
            System.out.println("Error: La palabra no existe en el diccionario.");
        }
    }

    private static void eliminarPalabra(HashMap<String, String> diccionario) {
        System.out.print("Introduce la palabra a eliminar: ");
        String palabra = scanner.nextLine();

        if (diccionario.containsKey(palabra)) {
            diccionario.remove(palabra);
            System.out.println("Palabra eliminada correctamente.");
        } else {
            System.out.println("Error: La palabra no existe en el diccionario.");
        }
    }

    private static void consultarPalabra(HashMap<String, String> diccionario) {
        System.out.print("Introduce la palabra a consultar: ");
        String palabra = scanner.nextLine();

        if (diccionario.containsKey(palabra)) {
            System.out.println("Definición: " + diccionario.get(palabra));
        } else {
            System.out.println("Error: La palabra no existe en el diccionario.");
        }
    }

    private static void mostrarDiccionario(HashMap<String, String> diccionario) {
        if (diccionario.isEmpty()) {
            System.out.println("El diccionario está vacío.");
        } else {
            System.out.println("Diccionario:");
            for (String palabra : diccionario.keySet()) {
                System.out.println(palabra + ": " + diccionario.get(palabra));
            }
        }
    }

    private static void jugar(HashMap<String, String> diccionario, ArrayList<Puntuacion> mejoresPuntuaciones) {
        if (diccionario.isEmpty()) {
            System.out.println("El diccionario está vacío. No se puede jugar.");
            return;
        }

        int puntuacion = 0;
        boolean jugando = true;

        while (jugando) {
            String palabraAleatoria = obtenerPalabraAleatoria(diccionario);
            String definicion = diccionario.get(palabraAleatoria);

            System.out.println("Definición: " + definicion);
            System.out.print("Adivina la palabra: ");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase(palabraAleatoria)) {
                puntuacion++;
                System.out.println("¡Correcto! Puntuación: " + puntuacion);
            } else {
                System.out.println("Incorrecto. La palabra era: " + palabraAleatoria);
                jugando = false;
            }
        }

        System.out.println("Fin del juego. Tu puntuación final es: " + puntuacion);

        if (mejoresPuntuaciones.size() < 5 || puntuacion > mejoresPuntuaciones.get(4).puntuacion) {
            System.out.print("¡Felicidades! Has conseguido una de las 5 mejores puntuaciones. Introduce tu nombre: ");
            String nombre = scanner.nextLine();
            mejoresPuntuaciones.add(new Puntuacion(nombre, puntuacion));
            ordenarMejoresPuntuaciones(mejoresPuntuaciones);
            if (mejoresPuntuaciones.size() > 5) {
                mejoresPuntuaciones.remove(5);
            }
        }
    }

    private static String obtenerPalabraAleatoria(HashMap<String, String> diccionario) {
        int indiceAleatorio = (int) (Math.random() * diccionario.size());
        int i = 0;
        for (String palabra : diccionario.keySet()) {
            if (i == indiceAleatorio) {
                return palabra;
            }
            i++;
        }
        return null;
    }

    private static void ordenarMejoresPuntuaciones(ArrayList<Puntuacion> mejoresPuntuaciones) {
        Collections.sort(mejoresPuntuaciones, new Comparator<Puntuacion>() {
            @Override
            public int compare(Puntuacion p1, Puntuacion p2) {
                return p2.puntuacion - p1.puntuacion;
            }
        });
    }

    private static void mostrarMejoresPuntuaciones(ArrayList<Puntuacion> mejoresPuntuaciones) {
        if (mejoresPuntuaciones.isEmpty()) {
            System.out.println("No hay puntuaciones registradas.");
        } else {
            System.out.println("Mejores puntuaciones:");
            for (int i = 0; i < mejoresPuntuaciones.size(); i++) {
                System.out.println((i + 1) + ". " + mejoresPuntuaciones.get(i).nombre + ": " + mejoresPuntuaciones.get(i).puntuacion);
            }
        }
    }

}
