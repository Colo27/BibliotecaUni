package com.example.guest.gestionebiblioteca;

import java.util.Date;

public class Prenotazione {

    Libro libro;
    String inizio;
    String fine;

    public Prenotazione (Libro libro, String inizio, String fine) {
        this.libro = libro;
        this.inizio = inizio;
        this.fine = fine;
    }

    public Libro getLibro() {
        return libro;
    }

    public String getInizio() {
        return inizio;
    }

    public String getFine() {
        return fine;
    }
}
