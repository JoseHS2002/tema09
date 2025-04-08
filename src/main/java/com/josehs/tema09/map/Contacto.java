package com.josehs.tema09.map;

public class Contacto {
    private final String numero;
    private final String nombre;
    private final String email;

    public Contacto(String numero, String nombre, String email) {
        this.numero = numero;
        this.nombre = nombre;
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Contacto contacto)) return false;

        return numero.equals(contacto.numero);
    }

    @Override
    public int hashCode() {
        return numero.hashCode();
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "numero='" + numero + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
