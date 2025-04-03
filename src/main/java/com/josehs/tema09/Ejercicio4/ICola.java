package com.josehs.tema09.Ejercicio4;

public interface ICola<T> {
    boolean add(T e);
    T remove();
    int size();
    T peek();
    boolean isEmpty();
}
