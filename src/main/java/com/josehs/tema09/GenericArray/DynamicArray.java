package com.josehs.tema09.GenericArray;

import java.util.Arrays;

public class DynamicArray<T> {
    private Object[] data;
    private int size;
    private int capacidad;

    public DynamicArray() {
        capacidad = 10;
        data = new Object[capacidad];
        size = 0;
    }

    public void add(Object elemento) {
        if (size == capacidad) {
            capacidad *= 2;
            data = Arrays.copyOf(data, capacidad);
        }
        data[size++] = elemento;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return (Object) data[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
    }

    public int size() {
        return size;
    }

    //Vacia el array
    public void clear() {
        data = new Object[capacidad];
        size = 0;
    }

    //Crea una copia del array
    public DynamicArray<Object> clone() {
        DynamicArray<Object> copia = new DynamicArray<>();
        copia.data = Arrays.copyOf(this.data, this.capacidad);
        copia.size = this.size;
        return copia;
    }

    //devuelve el indice de la primera ocurrencia del elemento
    public int indexOf(Object elemento) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    //Reduce la capacidad interna al tamanyo original
    public void trimToSize() {
        if (size < capacidad) {
            data = Arrays.copyOf(data, size);
            capacidad = size;
        }
    }

    //Intercambia los elementos en las posiciones especificadas
    public boolean swap(int index1, int index2) {
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size) {
            return false;
        }
        Object temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
        return true;
    }

    @Override
    public String toString() {
        return "DynamicArray{" +
                "elementos=" + Arrays.toString(data) +
                ", tamaño=" + size +
                ", capacidad=" + capacidad +
                '}';
    }
}
