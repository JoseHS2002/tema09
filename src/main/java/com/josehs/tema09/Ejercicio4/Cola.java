package com.josehs.tema09.Ejercicio4;

import java.util.ArrayList;
import java.util.Random;
/*Utilizar ArrayList en la clase cola*/
public class Cola<T> implements ICola<T>{
    public static void main(String[] args) {
        Cola<Integer> colaEnteros = new Cola<>();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            colaEnteros.add(random.nextInt(100));
        }

        System.out.println("Cola inicial: " + colaEnteros.cola);

        colaEnteros.remove();
        colaEnteros.remove();

        System.out.println("Cola después de eliminar elementos: ");
        System.out.println(colaEnteros.cola);
    }

    private ArrayList<T> cola;

    public Cola() {
        cola = new ArrayList<>();
    }

    @Override
    public boolean add(T elemento) {
        cola.add(elemento);
        return true;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            return null;
        }
        return cola.remove(0);
    }

    @Override
    public int size() {
        return cola.size();
    }

    @Override
    public T peek() {
        return cola.get(0);
    }

    @Override
    public boolean isEmpty() {
        return cola.isEmpty();
    }
}
