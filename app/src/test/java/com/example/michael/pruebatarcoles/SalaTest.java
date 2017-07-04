package com.example.michael.pruebatarcoles;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by victoru on 15/06/17.
 */
public class SalaTest {
    @Test
    public void getImg() throws Exception {
        Sala sala = new Sala(1,"Sala A","todos los dias");
        int img = sala.getImg();
        int img2 = 1;
        assertEquals(img, img2);
    }

    @Test
    public void setImg() throws Exception {
        Sala sala = new Sala(1,"Sala A","todos los dias");
        sala.setImg(2);
        int img = sala.getImg();
        int img2 = 2;
        assertEquals(img, img2);
    }

    @Test
    public void getTitulo() throws Exception {
        Sala sala = new Sala(1,"Sala A","todos los dias");
        String titulo = sala.getTitulo();
        String titulo2 = "Sala A";
        assertEquals(titulo, titulo2);
    }

    @Test
    public void setTitulo() throws Exception {
        Sala sala = new Sala(1,"Sala A","todos los dias");
        sala.setTitulo("Sala B");
        String titulo2 = "Sala B";
        String titulo = sala.getTitulo();
        assertEquals(titulo, titulo2);
    }

    @Test
    public void getDescripcion() throws Exception {
        Sala sala = new Sala(1,"Sala A","todos los dias");
        String descripcion = sala.getDescripcion();
        String descripcion2 = "todos los dias";
        assertEquals(descripcion, descripcion2);
    }

    @Test
    public void setDescripcion() throws Exception {
        Sala sala = new Sala(1,"Sala A","todos los dias");
        sala.setDescripcion("algunos dias");
        String descripcion = sala.getDescripcion();
        String descripcion2 = "algunos dias";
        assertEquals(descripcion, descripcion2);
    }

}