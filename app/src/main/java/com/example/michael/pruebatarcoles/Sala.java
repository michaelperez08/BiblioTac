package com.example.michael.pruebatarcoles;

/**
 * Created by michael on 13/06/17.
 */

public class Sala {

    private int img;
    private String titulo;
    private String descripcion;

    public Sala(int img, String titulo, String descripcion) {
        this.img = img;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Sala() {
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
