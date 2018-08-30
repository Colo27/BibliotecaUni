package com.example.guest.gestionebiblioteca;

public class Libro {

    private String mAutore;
    private String mTitolo;
    private String mStart;
    private String mEnd;

    public Libro(String autore, String titolo) {
        this.mAutore = autore;
        this.mTitolo = titolo;
    }

    public Libro(){}

    public Libro(String mAutore, String mTitolo, String mStart, String mEnd) {
        this.mAutore = mAutore;
        this.mTitolo = mTitolo;
        this.mStart = mStart;
        this.mEnd = mEnd;
    }

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

    public String getmStart() {
        return mStart;
    }

    public void setmStart(String mStart) {
        this.mStart = mStart;
    }

    public String getmEnd() {
        return mEnd;
    }

    public void setmEnd(String mEnd) {
        this.mEnd = mEnd;
    }
}
