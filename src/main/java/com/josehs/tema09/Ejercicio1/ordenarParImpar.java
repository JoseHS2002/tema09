package com.josehs.tema09;

import java.util.*;
/*Hacer que un ArrayList separe pares e impares*/
public class ordenarParImpar {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];

        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt(51);
        }

        System.out.print("Array: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        List<Integer> listaParImpar = ordenarParImpar(array);

        System.out.print("ArrayList: [");
        for (int i = 0; i < listaParImpar.size(); i++) {
            System.out.print(listaParImpar.get(i));
            if (i < listaParImpar.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static List<Integer> ordenarParImpar(int[] array) {
        List<Integer> pares = new ArrayList<>();
        List<Integer> impares = new ArrayList<>();

        for (int numero : array) {
            if (numero % 2 == 0) {
                pares.add(numero);
            } else {
                impares.add(numero);
            }
        }

        pares.addAll(impares);
        return pares;
    }
}
