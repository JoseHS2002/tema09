package com.josehs.tema09.Ejercicio7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class divisas {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Map<String, Double> cambioEuro = new HashMap<>();

        cambioEuro.put("USD", 1.10);
        cambioEuro.put("GBP", 0.85);
        cambioEuro.put("INR", 94.10);
        cambioEuro.put("AUD", 1.81);
        cambioEuro.put("CAD", 1.56);
        cambioEuro.put("ARS", 1177.69);
        cambioEuro.put("BOB", 7.62);
        cambioEuro.put("CLP", 1047.51);
        cambioEuro.put("VEZ", 4584.20);
        cambioEuro.put("CRC", 558.00);
        cambioEuro.put("CUP", 26.47);
        cambioEuro.put("DOP", 69.66);
        cambioEuro.put("MXN", 22.66);

        System.out.println("Dime la cantidad de euros:");
        double euros = scanner.nextDouble();

        for (Map.Entry<String, Double> entrada : cambioEuro.entrySet()) {
            String moneda = entrada.getKey();
            double tasa = entrada.getValue();
            double cantidadConvertida = euros * tasa;
            System.out.println(euros + " EUR = " + cantidadConvertida + " " + moneda);
        }
    }
}
