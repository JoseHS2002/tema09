package com.josehs.tema09.Ejercicio10;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private final String dni;
    private final String nombre;
    private final String apellidos;
    private final LocalDate fechaNacimiento;
    private double sueldo;
    private List<Hijo> hijos = new ArrayList<>();

    public Empleado(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, double sueldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldo = sueldo;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public double getSueldo() {
        return sueldo;
    }

    public List<Hijo> getHijos() {
        return hijos;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void addHijo(Hijo hijo) {
        hijos.add(hijo);
    }

    public void removeHijo(String nombreHijo) {
        hijos.removeIf(hijo -> hijo.getNombre().equals(nombreHijo));
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", sueldo=" + sueldo +
                ", hijos=" + hijos +
                '}';
    }
}
