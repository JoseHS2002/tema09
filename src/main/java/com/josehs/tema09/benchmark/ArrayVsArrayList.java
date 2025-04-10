package com.josehs.tema09.benchmark;

import java.util.ArrayList;
import java.util.List;

public class ArrayVsArrayList implements Ejecutable {
    @Override
    public void start(int size, int times, int seekValue) {
        List<Integer> datos = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < size; j++) {
                datos.add(0);
            }
        }
    }

    @Override
    public String getDescription() {
        return "Array Vs ArrayList";
    }
}
