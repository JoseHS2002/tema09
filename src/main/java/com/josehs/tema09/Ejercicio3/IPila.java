package com.josehs.tema09.Ejercicio3;

public interface IPila<T> {
    T push(T e);
    T pop();
    int size();
    T top();
    boolean isEmpty();
}
