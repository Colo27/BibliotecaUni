package com.example.guest.gestionebiblioteca;

public class Libro {

    private String mAutore;
    private String mTitolo;

    public Libro(String autore, String titolo) {
        this.mAutore = autore;
        this.mTitolo = titolo;
    }

    public Libro(){}

    public String getmAutore() {
        return mAutore;
    }

    public void setmAutore(String mAutore) {
        this.mAutore = mAutore;
    }

    public String getmTitolo() {
        return mTitolo;
    }

    public void setmTitolo(String mTitolo) {
        this.mTitolo = mTitolo;
    }
}
