package com.josehs.tema09.GenericArray;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        GenericDynamicArray<Integer> datos = new GenericDynamicArray<>(100);
        for (int i = 0; i < 50; i++) {
            datos.add(i);
        }

        datos.set(10, null);

        Iterator<Integer> iterator = datos.iterator();
        while (iterator.hasNext()) {
            if (datos == null){
                System.out.flush();
            } else {
                System.out.println(iterator.next());
            }
        }
        System.out.println(iterator.hasNext());

        /*
        for (int numero : datos) {
            System.out.println(numero);
        }
         */

        /*
        DynamicArray<Double> dynamicArray = new DynamicArray<>();
        dynamicArray.add(1.1);
        dynamicArray.add(2.2);
        dynamicArray.add(3.3);
        System.out.println("DynamicArray tamanyo: ");
        System.out.println(dynamicArray.size());
        dynamicArray.add(4.4);
        dynamicArray.add(5.5);
        System.out.println("Devolver la primera ocurrencia de (4.4)");
        System.out.println(dynamicArray.indexOf(4.4));
        dynamicArray.trimToSize();
        System.out.println("Tamano despues de trimToSize: " + dynamicArray.size());
        dynamicArray.swap(0, 2);
        System.out.println("DynamicArray después de swap: " + dynamicArray.get(0) + ", " + dynamicArray.get(2));
        dynamicArray.clone();
        System.out.println("Clonar el array");
        System.out.println(dynamicArray.size());
        System.out.println("Array clonado");
        dynamicArray.clear();
        System.out.println("Vaciar el array");
        System.out.println(dynamicArray.size());
        System.out.println("El array está vacío");

         */
    }
}
