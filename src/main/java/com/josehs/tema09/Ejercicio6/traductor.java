package com.josehs.tema09.Ejercicio6;

import java.util.Scanner;
import java.util.HashMap;

public class traductor {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        HashMap<String, String> traductor = new HashMap<>();

        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    introducirPalabras(traductor);
                    break;
                case 2:
                    traducirPalabra(traductor);
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("==============");
        System.out.println("1. Introducir parejas de palabras.");
        System.out.println("2. Traducir palabras.");
        System.out.println("0. Salir de la aplicación.");
        System.out.print("Elige una opción: ");
    }

    private static void introducirPalabras(HashMap<String, String> traductor) {
        System.out.print("¿Cuántas palabras deseas introducir? ");
        int numParejas = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numParejas; i++) {
            System.out.print("Introduzca palabra en inglés: ");
            String palabraIngles = scanner.nextLine();
            System.out.print("Introduzca traducción al valenciano: ");
            String palabraValenciano = scanner.nextLine();
            traductor.put(palabraIngles, palabraValenciano);
        }
    }

    private static void traducirPalabra(HashMap<String, String> traductor) {
        System.out.print("Palabra a buscar: ");
        String palabraBuscar = scanner.nextLine();

        if (traductor.containsKey(palabraBuscar)) {
            System.out.println(traductor.get(palabraBuscar));
        } else {
            System.out.println("La palabra no existe.");
        }
    }
}
