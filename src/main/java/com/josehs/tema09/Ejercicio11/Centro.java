package com.josehs.tema09.Ejercicio11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Centro {
    public static Scanner scanner = new Scanner(System.in);

    static int alumnoId = 1;
    static int asignaturaId = 1;
    static int grupoId = 1;
    static int aulaId = 1;

    static HashMap<Integer, Alumno> alumnos = new HashMap<>();
    static HashMap<Integer, Asignatura> asignaturas = new HashMap<>();
    static HashMap<Integer, Grupo> grupos = new HashMap<>();
    static HashMap<Integer, Aula> aulas = new HashMap<>();
    static HashMap<String, Profesor> profesores = new HashMap<>();

    public static void main(String[] args) {

        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    nuevoProfesor();
                    break;
                case 2:
                    nuevaAsignatura();
                    break;
                case 3:
                    nuevaAula();
                    break;
                case 4:
                    nuevoGrupo();
                    break;
                case 5:
                    nuevoAlumno();
                    break;
                case 6:
                    mostrarAlumnosPorGrupo();
                    break;
                case 7:
                    mostrarAlumnosPorProfesor();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, elige una opción válida.");
            }
        }
    }

    static void mostrarMenu() {
        System.out.println("--- Menú de Gestión de Alumnos ---");
        System.out.println("1. Nuevo Profesor");
        System.out.println("2. Nueva Asignatura");
        System.out.println("3. Nueva Aula");
        System.out.println("4. Nuevo Grupo");
        System.out.println("5. Nuevo Alumno");
        System.out.println("6. Mostrar Alumnos por Grupo");
        System.out.println("7. Mostrar Alumnos por Profesor");
        System.out.println("0. Salir");
        System.out.println("Elige una opción: ");
    }

    /**
     * Agrega nuevos profesores
     */
    static void nuevoProfesor() {
        System.out.println("Introduce el DNI del profesor: ");
        String dni = scanner.nextLine();
        System.out.println("Introduce el nombre del profesor: ");
        String nombre = scanner.nextLine();
        System.out.println("Introduce el sueldo del profesor: ");
        double sueldo = scanner.nextDouble();
        scanner.nextLine();

        Profesor profesor = new Profesor(dni, nombre, sueldo);
        profesores.put(dni, profesor);
        System.out.println("Profesor creado con éxito.");
    }

    /**
     * Agrega nuevas asignaturas y que profesor la imparte
     */
    static void nuevaAsignatura() {
        System.out.println("Introduce el nombre de la asignatura: ");
        String nombre = scanner.nextLine();
        System.out.println("Introduce el DNI del profesor que imparte la asignatura: ");
        String dniProfesor = scanner.nextLine();
        Profesor profesor = profesores.get(dniProfesor);
        if (profesor == null) {
            System.out.println("Profesor no encontrado.");
            return;
        }

        Asignatura asignatura = new Asignatura(asignaturaId++, nombre, profesor);
        asignaturas.put(asignatura.getId(), asignatura);
        System.out.println("Asignatura creada con éxito.");
    }

    /**
     * Indica el tamaño del aula
     */
    static void nuevaAula() {
        System.out.println("Introduce los metros cuadrados del aula: ");
        int metrosCuadrados = scanner.nextInt();
        scanner.nextLine();

        Aula aula = new Aula(aulaId++, metrosCuadrados);
        aulas.put(aula.getId(), aula);
        System.out.println("Aula creada con éxito.");
        System.out.println("Cantidad de mesas: " + aula.getCantidadMesas());
        System.out.println("Capacidad de estudiantes: " + aula.getCapacidadEstudiantes());


    }

    /**
     * Agrega nuevos grupos.
     */
    static void nuevoGrupo() {
        System.out.println("Introduce el nombre del grupo: ");
        String nombre = scanner.nextLine();
        System.out.println("Introduce el id del aula del grupo: ");
        int aulaId = scanner.nextInt();
        scanner.nextLine();
        Aula aula = aulas.get(aulaId);
        if (aula == null) {
            System.out.println("Aula no encontrada.");
            return;
        }

        Grupo grupo = new Grupo(grupoId++, nombre, aula);
        grupos.put(grupo.getId(), grupo);
        System.out.println("Grupo creado con éxito.");
    }

    /**
     * Agrega nuevos alumnos y que asignaturas asisten.
     */
    static void nuevoAlumno() {
        System.out.println("Introduce el nombre del alumno: ");
        String nombre = scanner.nextLine();
        System.out.println("Introduce el id del grupo del alumno: ");
        int grupoId = scanner.nextInt();
        scanner.nextLine();
        Grupo grupo = grupos.get(grupoId);
        if (grupo == null) {
            System.out.println("Grupo no encontrado.");
            return;
        }

        List<Asignatura> asignaturasAlumno = new ArrayList<>();
        System.out.print("Introduce el id de las asignaturas del alumno (separadas por coma): ");
        String asignaturasStr = scanner.nextLine();
        if (!asignaturasStr.isEmpty()) {
            String[] asignaturasIds = asignaturasStr.split(",");
            for (String asignaturaIdStr : asignaturasIds) {
                int asignaturaId = Integer.parseInt(asignaturaIdStr.trim());
                Asignatura asignatura = asignaturas.get(asignaturaId);
                if (asignatura != null) {
                    asignaturasAlumno.add(asignatura);
                } else {
                    System.out.println("Asignatura " + asignaturaId + " no encontrada.");
                }
            }
        }

        Alumno alumno = new Alumno(alumnoId++, nombre, grupo, asignaturasAlumno);
        alumnos.put(alumno.getId(), alumno);
        System.out.println("Alumno creado con éxito.");
    }

    /**
     * Muestra informacion de los alumnos que pertenecen a un grupo
     */
    static void mostrarAlumnosPorGrupo() {
        System.out.println("Introduce el código del grupo: ");
        int grupoId = scanner.nextInt();
        scanner.nextLine();
        Grupo grupo = grupos.get(grupoId);
        if (grupo == null) {
            System.out.println("Grupo no encontrado.");
            return;
        }

        System.out.println("--- Alumnos del grupo " + grupo.getNombre() + " ---");
        for (Alumno alumno : alumnos.values()) {
            if (alumno.getGrupo().getId() == grupoId) {
                System.out.println("ID: " + alumno.getId() + ", Nombre: " + alumno.getNombre());
            }
        }

    }

    /**
     * Muestra los alumnos de un profesor
     */
    static void mostrarAlumnosPorProfesor() {
        System.out.println("Introduce el DNI del profesor: ");
        String dniProfesor = scanner.nextLine();
        Profesor profesor = profesores.get(dniProfesor);
        if (profesor == null) {
            System.out.println("Profesor no encontrado.");
            return;
        }

        System.out.println("--- Alumnos del profesor " + profesor.getNombre() + " ---");
        for (Alumno alumno : alumnos.values()) {
            for (Asignatura asignatura : alumno.getAsignaturas()) {
                if (asignatura.getProfesor().getDni().equals(dniProfesor)) {
                    System.out.println("ID: " + alumno.getId() + ", Nombre: " + alumno.getNombre());
                    break;
                }
            }
        }
    }

}
