package com.josehs.tema09.map;

import java.util.HashMap;
import java.util.Map;

public class MainMap {
    public static void main(String[] args) {
        AgendaContactos agendaContactos = new AgendaContactos();
        System.out.println(agendaContactos.getContactos());
        agendaContactos.add(new Contacto("225345", "Pepe", "email1"));
        agendaContactos.add(new Contacto("225346", "Antonio", "email2"));

        System.out.println(agendaContactos.buscar("225345"));
        System.out.println(agendaContactos.getContactos());
        System.out.println(agendaContactos.getAgenda());
    }
}
