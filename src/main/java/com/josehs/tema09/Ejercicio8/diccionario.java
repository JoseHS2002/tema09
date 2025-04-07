package com.josehs.tema09.Ejercicio8;

import java.util.HashMap;
import java.util.Scanner;

public class diccionario {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        HashMap<String, String> diccionario = new HashMap<>();

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
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elige una opción válida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("***********************");
        System.out.println("* GESTIÓN DICCIONARIO *");
        System.out.println("***********************");
        System.out.println("1. Añadir palabra");
        System.out.println("2. Modificar palabra");
        System.out.println("3. Eliminar palabra");
        System.out.println("4. Consultar palabra");
        System.out.println("5. Mostrar diccionario");
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
}
