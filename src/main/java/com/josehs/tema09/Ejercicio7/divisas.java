package com.josehs.tema09.Ejercicio7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class divisas {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Map<String, Double> tasasDeCambio = new HashMap<>();

        tasasDeCambio.put("USD", 1.10);
        tasasDeCambio.put("GBP", 0.85);
        tasasDeCambio.put("INR", 94.10);
        tasasDeCambio.put("AUD", 1.81);
        tasasDeCambio.put("CAD", 1.56);
        tasasDeCambio.put("ARS", 1177.69);
        tasasDeCambio.put("BOB", 7.62);
        tasasDeCambio.put("CLP", 1047.51);
        tasasDeCambio.put("VEZ", 4584.20);
        tasasDeCambio.put("CRC", 558.00);
        tasasDeCambio.put("CUP", 26.47);
        tasasDeCambio.put("DOP", 69.66);
        tasasDeCambio.put("MXN", 22.66);

        System.out.println("Dime cuantos euros");
        double euros = scanner.nextDouble();

        for (Map.Entry<String, Double> entrada : tasasDeCambio.entrySet()) {
            String moneda = entrada.getKey();
            double tasa = entrada.getValue();
            double cantidadConvertida = euros * tasa;
            System.out.println(euros + " EUR = " + cantidadConvertida + " " + moneda);
        }
    }
}
