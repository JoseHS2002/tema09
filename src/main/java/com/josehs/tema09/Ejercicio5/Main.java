package com.josehs.tema09.Ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PacientesEstadisticas> pacientes = new ArrayList<>();
        pacientes.add(new PacientesEstadisticas("Ana", "12/02/1980", 'F', 1.63, 57));
        pacientes.add(new PacientesEstadisticas("Laura", "07/03/1990", 'F', 1.74, 60.5));
        pacientes.add(new PacientesEstadisticas("Maria", "20/03/1967", 'F', 1.62, 50.8));
        pacientes.add(new PacientesEstadisticas("Juan", "20/04/1972", 'M', 1.78, 72.5));
        pacientes.add(new PacientesEstadisticas("Pedro", "29/02/1960", 'M', 1.8, 85.2));

        int[] posiciones = PacientesEstadisticas.mayorMenor(pacientes);
        System.out.println("Paciente mayor de edad: " + pacientes.get(posiciones[1]).calcularEdad() + " Sexo: " + pacientes.get(posiciones[1]).getSexo());
        System.out.println("Paciente menor edad: " + pacientes.get(posiciones[0]).calcularEdad() + " Sexo: " + pacientes.get(posiciones[0]).getSexo());

        int[] cantidadPorSexo = PacientesEstadisticas.pacientesPorSexo(pacientes);
        System.out.println("Cantidad de pacientes por sexo:");
        System.out.println("Hombres: " + cantidadPorSexo[0] + " Mujeres: " + cantidadPorSexo[1]);

        for (PacientesEstadisticas paciente : pacientes) {
            System.out.println(paciente);
        }
    }
}
