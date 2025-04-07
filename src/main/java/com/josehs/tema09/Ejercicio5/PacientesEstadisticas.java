package com.josehs.tema09.Ejercicio5;

import com.josehs.tema09.Ejercicio4.Cola;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PacientesEstadisticas {
    private static int contador = 1;
    private final int id;
    private final String nombre;
    private final LocalDate fechaNacimiento;
    private final char sexo;
    private double altura;
    private double peso;

    public PacientesEstadisticas(String nombre, String fechaNacimiento, char sexo, double altura, double peso) {
        this.id = contador++;
        this.nombre = nombre;
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }

    public PacientesEstadisticas(String nombre, String fechaNacimiento, double altura, double peso) {
        this(nombre, fechaNacimiento, 'M', altura, peso);
    }

    public double calcularIMC() {
        return peso / (altura * altura);
    }

    public int calcularEdad() {
        LocalDate fechaActual = LocalDate.now();
        return fechaActual.getYear() - fechaNacimiento.getYear();
    }

    public String obtenerMensajeIMC() {
        double imc = calcularIMC();
        if (imc < 18.5) {
            return "IMC: <18.5; Mensaje: Peso insuficiente";
        } else if (imc >= 18.5 && imc <= 24.9) {
            return "IMC: 18.5-24.9; Mensaje: Peso normal";
        } else if (imc >= 25 && imc <= 26.9) {
            return "IMC: 25-26,9; Mensaje: Sobrepeso grado I";
        } else if (imc >= 27 && imc <= 29.9) {
            return "IMC: 27-29.9; Mensaje: Sobrepeso grado II";
        } else {
            return "IMC: >29,9; Mensaje: Sobrepeso grado III";
        }
    }

    public static int[] mayorMenor(List<PacientesEstadisticas> pacientes) {
        int[] mEdad = new int[2];
        if (pacientes.isEmpty()) {
            return mEdad;
        }
        mEdad[0] = 0;
        mEdad[1] = 0;
        int edadMenor = pacientes.get(0).calcularEdad();
        int edadMayor = pacientes.get(0).calcularEdad();
        for (int i = 1; i < pacientes.size(); i++) {
            int edadActual = pacientes.get(i).calcularEdad();
            if (edadActual < edadMenor) {
                edadMenor = edadActual;
                mEdad[0] = i;
            }
            if (edadActual > edadMayor) {
                edadMayor = edadActual;
                mEdad[1] = i;
            }
        }
        return mEdad;
    }

    public static int[] pacientesPorSexo(List<PacientesEstadisticas> pacientes) {
        int[] genero = new int[2];
        for (PacientesEstadisticas paciente : pacientes) {
            if (paciente.sexo == 'M') {
                genero[0]++;
            } else {
                genero[1]++;
            }
        }
        return genero;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public char getSexo() {
        return sexo;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Paciente número " + id + ": " + obtenerMensajeIMC() + ".";
    }
}
