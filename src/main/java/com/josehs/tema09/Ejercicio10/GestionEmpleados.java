package com.josehs.tema09.Ejercicio10;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GestionEmpleados {
    public static Scanner scanner = new Scanner(System.in);
    private List<Empleado> empleados = new ArrayList<>();

    public static void main(String[] args) {
        GestionEmpleados gestionEmpleados = new GestionEmpleados();

        while (true) {
            gestionEmpleados.mostrarMenuPrincipal();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    gestionEmpleados.nuevoEmpleado();
                    break;
                case 2:
                    gestionEmpleados.nuevoHijo();
                    break;
                case 3:
                    gestionEmpleados.modificarSueldo();
                    break;
                case 4:
                    gestionEmpleados.borrarEmpleado();
                    break;
                case 5:
                    gestionEmpleados.borrarHijo();
                    break;
                case 6:
                    gestionEmpleados.mostrarMenuConsultas();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, introduce una opción válida.");
            }
        }
    }

    private void mostrarMenuPrincipal() {
        System.out.println("*********************");
        System.out.println("* GESTIÓN EMPLEADOS *");
        System.out.println("*********************");
        System.out.println("1. Nuevo empleado");
        System.out.println("2. Nuevo hijo");
        System.out.println("3. Modificar sueldo");
        System.out.println("4. Borrar empleado");
        System.out.println("5. Borrar hijo");
        System.out.println("6. Consultas");
        System.out.println("---------------------");
        System.out.println("0. Salir");
        System.out.print("Introduce una opción: ");
    }

    private void mostrarMenuConsultas() {
        while (true) {
            System.out.println("***********************");
            System.out.println("* CONSULTAS EMPLEADOS *");
            System.out.println("***********************");
            System.out.println("1. Buscar por NIF");
            System.out.println("2. Buscar por nombre");
            System.out.println("3. Buscar por rango de edad");
            System.out.println("4. Buscar por rango de sueldo");
            System.out.println("5. Buscar por hijos menores de edad");
            System.out.println("-----------------------------");
            System.out.println("0. Volver al menú principal");
            System.out.print("Introduce una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    buscarPorNIF();
                    break;
                case 2:
                    buscarPorNombre();
                    break;
                case 3:
                    buscarPorRangoEdad();
                    break;
                case 4:
                    buscarPorRangoSueldo();
                    break;
                case 5:
                    buscarPorHijosMenoresEdad();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, introduce una opción válida.");
            }
        }
    }

    //metodos del main

    /**
     * Crea un nuevo empleado
     */
    private void nuevoEmpleado() {
        System.out.println("Introduce los datos del nuevo empleado:");
        System.out.print("DNI: ");
        String dni = scanner.nextLine();
        if (existeEmpleado(dni)) {
            System.out.println("Ya existe un empleado con ese DNI.");
            return;
        }
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Fecha de nacimiento: ");
        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());
        System.out.print("Sueldo: ");
        double sueldo = scanner.nextDouble();
        scanner.nextLine();

        Empleado nuevoEmpleado = new Empleado(dni, nombre, apellidos, fechaNacimiento, sueldo);
        empleados.add(nuevoEmpleado);
        System.out.println("Empleado añadido correctamente.");
    }

    /**
     * Crea un hijo para un empleado existente
     */
    private void nuevoHijo() {
        System.out.print("Introduce el DNI del empleado: ");
        String dniEmpleado = scanner.nextLine();
        Empleado empleado = buscarEmpleado(dniEmpleado);
        if (empleado == null) {
            System.out.println("No se encontró ningún empleado con ese DNI.");
            return;
        }
        System.out.println("Introduce los datos del nuevo hijo:");
        System.out.print("Nombre: ");
        String nombreHijo = scanner.nextLine();
        System.out.print("Edad: ");
        int edadHijo = scanner.nextInt();
        scanner.nextLine();

        Hijo nuevoHijo = new Hijo(nombreHijo, edadHijo);
        empleado.addHijo(nuevoHijo);
        System.out.println("Hijo añadido correctamente al empleado.");
    }

    /**
     * Modifica el sueldo de un empleado existente
     */
    private void modificarSueldo() {
        System.out.print("Introduce el DNI del empleado: ");
        String dniEmpleado = scanner.nextLine();
        Empleado empleado = buscarEmpleado(dniEmpleado);
        if (empleado == null) {
            System.out.println("No se encontró ningún empleado con ese DNI.");
            return;
        }
        System.out.print("Introduce el nuevo sueldo: ");
        double nuevoSueldo = scanner.nextDouble();
        scanner.nextLine();

        empleado.setSueldo(nuevoSueldo);
        System.out.println("Sueldo del empleado modificado correctamente.");
    }

    /**
     * Borra un usuario existente
     */
    private void borrarEmpleado() {
        System.out.print("Introduce el DNI del empleado: ");
        String dniEmpleado = scanner.nextLine();
        Empleado empleado = buscarEmpleado(dniEmpleado);
        if (empleado == null) {
            System.out.println("No se encontró ningún empleado con ese DNI.");
            return;
        }
        empleados.remove(empleado);
        System.out.println("Empleado borrado correctamente.");
    }

    /**
     * Borrar un hijo existente de un usuario existente
     */
    private void borrarHijo() {
        System.out.print("Introduce el DNI del empleado: ");
        String dniEmpleado = scanner.nextLine();
        Empleado empleado = buscarEmpleado(dniEmpleado);
        if (empleado == null) {
            System.out.println("No se encontró ningún empleado con ese DNI.");
            return;
        }
        System.out.print("Introduce el nombre del hijo: ");
        String nombreHijo = scanner.nextLine();
        empleado.removeHijo(nombreHijo);
        System.out.println("Hijo borrado correctamente del empleado.");
    }

    //metodos del menu Consultas

    /**
     * Pide el NIF de un empleado y muestra todos sus datos
     */
    private void buscarPorNIF() {
        System.out.print("Introduce el DNI del empleado: ");
        String dniEmpleado = scanner.nextLine();
        Empleado empleado = buscarEmpleado(dniEmpleado);
        if (empleado == null) {
            System.out.println("No se encontró ningún empleado con ese DNI.");
            return;
        }
        System.out.println(empleado);
    }

    /**
     * Pide el nombre y saca todos los empleados que tengan el mismo nombre o parecido
     */
    private void buscarPorNombre() {
        System.out.print("Introduce el nombre: ");
        String nombre = scanner.nextLine();
        boolean empleadoEncontrado = false;
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                System.out.println(empleado);
                empleadoEncontrado = true;
            }
        }
        if (!empleadoEncontrado) {
            System.out.println("No se encontraron empleados con ese nombre.");
        }
    }

    /**
     * Muestra los datos de los empleados que contengan las edades comprendidas en el rango
     */
    private void buscarPorRangoEdad() {
        System.out.print("Introduce la edad mínima: ");
        int edadMinima = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Introduce la edad máxima: ");
        int edadMaxima = scanner.nextInt();
        scanner.nextLine();

        boolean empleadoEncontrado = false;
        for (Empleado empleado : empleados) {
            int edad = Period.between(empleado.getFechaNacimiento(), LocalDate.now()).getYears();
            if (edad >= edadMinima && edad <= edadMaxima) {
                System.out.println(empleado);
                empleadoEncontrado = true;
            }
        }
        if (!empleadoEncontrado) {
            System.out.println("No se encontraron empleados en ese rango de edad.");
        }
    }

    /**
     * Saca los empleados que tengan sueldos que esten dentro de un determinado rango
     */
    private void buscarPorRangoSueldo() {
        System.out.print("Introduce el sueldo mínimo: ");
        double sueldoMinimo = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Introduce el sueldo máximo: ");
        double sueldoMaximo = scanner.nextDouble();
        scanner.nextLine();

        boolean empleadoEncontrado = false;
        for (Empleado empleado : empleados) {
            if (empleado.getSueldo() >= sueldoMinimo && empleado.getSueldo() <= sueldoMaximo) {
                System.out.println(empleado);
                empleadoEncontrado = true;
            }
        }
        if (!empleadoEncontrado) {
            System.out.println("No se encontraron empleados en ese rango de sueldo.");
        }
    }

    /**
     * Muestra los empleados que tengan hijos menores de edad
     */
    private void buscarPorHijosMenoresEdad() {
        boolean empleadoEncontrado = false;
        for (Empleado empleado : empleados) {
            for (Hijo hijo : empleado.getHijos()) {
                if (hijo.getEdad() < 18) {
                    System.out.println(empleado);
                    empleadoEncontrado = true;
                    break;
                }
            }
        }
        if (!empleadoEncontrado) {
            System.out.println("No se encontraron empleados con hijos menores de edad.");
        }
    }

    /**
     * Busca un empleado por el dni
     * @param dni
     * @return
     */
    private Empleado buscarEmpleado(String dni) {
        for (Empleado empleado : empleados) {
            if (empleado.getDni().equals(dni)) {
                return empleado;
            }
        }
        return null;
    }

    /**
     * Comprueba si existe el empleado
     * @param dni
     * @return
     */
    private boolean existeEmpleado(String dni) {
        return buscarEmpleado(dni) != null;
    }
}
