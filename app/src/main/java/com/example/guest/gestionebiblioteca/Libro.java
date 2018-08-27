package com.example.guest.gestionebiblioteca;

public class Libro {

    private String mAutore;
    private String mTitolo;

    public Libro(String autore, String titolo) {
        this.mAutore = autore;
        this.mTitolo = titolo;
    }

    public String getmAutore() {
        return mAutore;
    }

    public String getmTitolo() {
        return mTitolo;
    }


}
