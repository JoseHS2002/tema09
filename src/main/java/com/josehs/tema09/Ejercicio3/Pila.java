package com.josehs.tema09.Ejercicio3;

import java.util.ArrayList;
import java.util.Random;
/*Utilizar ArrayList en la clase pila*/
public class Pila<T> implements IPila<T>{
    public static void main(String[] args) {
        Pila<Integer> pilaEnteros = new Pila<>();

        Random random = new Random();
        System.out.println("Contenido de la pila");
        for (int i = 0; i < 5; i++) {
            System.out.println(pilaEnteros.push(random.nextInt(100)));
        }

        System.out.println("Contenido de la pila después de agregar algunos elementos:");
        System.out.println(pilaEnteros.push(10));
        System.out.println(pilaEnteros.push(20));
        System.out.println(pilaEnteros.pila);

        System.out.println("\nContenido de la pila después de borrar algunos elementos:");
        System.out.println(pilaEnteros.pop());
        System.out.println(pilaEnteros.pila);

    }

    private ArrayList<T> pila;

    public Pila() {
        pila = new ArrayList<>();
    }

    @Override
    public T push(T elemento) {
        pila.add(elemento);
        return elemento;
    }

    @Override
    public T pop() {
        return pila.remove(pila.size() - 1);
    }

    @Override
    public int size() {
        return pila.size();
    }

    @Override
    public T top() {
        return pila.get(pila.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return pila.isEmpty();
    }
}
