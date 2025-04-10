package com.josehs.tema09.benchmark;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Benchmark {

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
            for (int j = 0; j < repeticiones; j++) {
                inicio = System.nanoTime();
                ejecutable.start();
                fin = System.nanoTime();
                stats.put(i, (double) (fin - inicio) / NANO_TO_SECOND);
                ejecuciones
            }
            stats.put(i, ejecuciones);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer,List<Double>> entry : stats.entrySet()) {
            int indice = entry.getKey();
            double suma = 0;
            List<Double> ejecuciones = entry.getValue();
            Ejecutable ejecutable = tareas.get(indice);
            sb.append(ejecutable.getDescription()).append(": ");
            for (Double tiempo: ejecuciones) {
                sb.append(String.format("%4s"," ")).append(tiempo).append(" seconds ").append("\n");
            }
            sb.append(String.format("Media: %.2f\n", suma / ejecuciones.size()));
        }
        return sb.toString();
    }
}

