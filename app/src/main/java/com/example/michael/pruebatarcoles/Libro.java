package com.example.michael.pruebatarcoles;

/**
 * Created by victoru on 27/06/17.
 */

public class Libro {

    private String signatura;
    private String titulo;
    private String autor;
    private String biblioteca;

    public Libro(String signatura, String titulo, String autor, String biblioteca){
        this.signatura = signatura;
        this.titulo = titulo;
        this.autor = autor;
        this.biblioteca = biblioteca;
    }

    public Libro() {

    }

    public void setSignatura(String signatura) {
        this.signatura = signatura;
    }

    public String getSignatura() {
        return signatura;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setBiblioteca(String biblioteca) {
        this.biblioteca = biblioteca;
    }

    public String getBiblioteca() {
        return biblioteca;
    }
}
