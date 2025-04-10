package com.josehs.tema09.benchmark;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Benchmark {
    /*
    private final int NANO_TO_SECOND = 1000000000;
    private final int repeticiones;
    private List<Ejecutable> tareas;
    private Map<Integer,Double> stats;

    public Benchmark(int repeticiones) {
        this.repeticiones = repeticiones;
        this.stats = new HashMap<>();
    }

    public void addEjecutable(Ejecutable ejecutable) {
        tareas.add(ejecutable);
    }

    public void iniciar() {
        long inicio, fin;
        for (int i=0; i < tareas.size(); i++) {
            Ejecutable ejecutable = tareas.get(i);
            for (int j = 0; j < repeticiones; j++)
                inicio=System.nanoTime();
                ejecutable.start();
                fin = System.nanoTime();
                stats.put(i, (double)(fin - inicio)/NANO_TO_SECOND);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer,Double> entry : stats.entrySet()) {
            int indice = entry.getKey();
            Ejecutable ejecutable = tareas.get(indice);
            sb.append(ejecutable.getDescription()).append();
            sb.append(entry.getValue()).append(" seconds ");
        }
    }
*/
}
