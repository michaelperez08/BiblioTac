package com.example.michael.pruebatarcoles;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alberto on 25/05/17.
 */
public class SolicitudSalaTest {
    @Test
    public void getNombre() throws Exception {
        SolicitudSala solicitud = new SolicitudSala("Victor","victor@gmail.com","10:00","12:00","10/7/2017","Sala A","A9****");
        String nombre =solicitud.getNombre();
        String nombre2 = "Victor";
        assertEquals(nombre, nombre2);
    }

    @Test
    public void setNombre() throws Exception {
        SolicitudSala solicitud = new SolicitudSala("Victor","victor@gmail.com","10:00","12:00","10/7/2017","Sala A","A9****");
        solicitud.setNombre("Alberto");
        String nombre =solicitud.getNombre();
        String nombre2 = "Alberto";
        assertEquals(nombre, nombre2);
    }

    @Test
    public void getCorreo() throws Exception {
        SolicitudSala solicitud = new SolicitudSala("Victor","victor@gmail.com","10:00","12:00","10/7/2017","Sala A","A9****");
        String correo = solicitud.getCorreo();
        String correo2 = "victor@gmail.com";
        assertEquals(correo, correo2);
    }

    @Test
    public void setCorreo() throws Exception {
        SolicitudSala solicitud = new SolicitudSala("Victor","victor@gmail.com","10:00","12:00","10/7/2017","Sala A","A9****");
        solicitud.setCorreo("alberto@gmail.com");
        String correo = solicitud.getCorreo();
        String correo2 = "alberto@gmail.com";
        assertEquals(correo, correo2);
    }

    @Test
    public void getHoraI() throws Exception {
        SolicitudSala solicitud = new SolicitudSala("Victor","victor@gmail.com","10:00","12:00","10/7/2017","Sala A","A9****");
        String horaI = solicitud.getHoraI();
        String horaI2 = "10:00";
        assertEquals(horaI, horaI2);
    }

    @Test
    public void setHoraI() throws Exception {
        SolicitudSala solicitud = new SolicitudSala("Victor","victor@gmail.com","10:00","12:00","10/7/2017","Sala A","A9****");
        solicitud.setHoraI("11:00");
        String horaI = solicitud.getHoraI();
        String horaI2 = "11:00";
        assertEquals(horaI, horaI2);
    }

    @Test
    public void getHoraF() throws Exception {
        SolicitudSala solicitud = new SolicitudSala("Victor","victor@gmail.com","10:00","12:00","10/7/2017","Sala A","A9****");
        String horaF =solicitud.getHoraF();
        String horaF2 = "12:00";
        assertEquals(horaF, horaF2);
    }

    @Test
    public void setHoraF() throws Exception {
        SolicitudSala solicitud = new SolicitudSala("Victor","victor@gmail.com","10:00","12:00","10/7/2017","Sala A","A9****");
        solicitud.setHoraF("13:00");
        String horaF =solicitud.getHoraF();
        String horaF2 = "13:00";
        assertEquals(horaF, horaF2);
    }

    @Test
    public void getFecha() throws Exception {
        SolicitudSala solicitud = new SolicitudSala("Victor","victor@gmail.com","10:00","12:00","10/7/2017","Sala A","A9****");
        String fecha = solicitud.getFecha();
        String fecha2 = "10/7/2017";
        assertEquals(fecha, fecha2);
    }

    @Test
    public void setFecha() throws Exception {
        SolicitudSala solicitud = new SolicitudSala("Victor","victor@gmail.com","10:00","12:00","10/7/2017","Sala A","A9****");
        solicitud.setFecha("12/7/2017");
        String fecha = solicitud.getFecha();
        String fecha2 = "12/7/2017";
        assertEquals(fecha, fecha2);
    }

    @Test
    public void getSala() throws Exception {
        SolicitudSala solicitud = new SolicitudSala("Victor","victor@gmail.com","10:00","12:00","10/7/2017","Sala A","A9****");
        String sala = solicitud.getSala();
        String sala2 = "Sala A";
        assertEquals(sala, sala2);
    }

    @Test
    public void setSala() throws Exception {
        SolicitudSala solicitud = new SolicitudSala("Victor","victor@gmail.com","10:00","12:00","10/7/2017","Sala A","A9****");
        solicitud.setSala("Sala B");
        String sala = solicitud.getSala();
        String sala2 = "Sala B";
        assertEquals(sala, sala2);
    }

    @Test
    public void getUrl() throws Exception {
        SolicitudSala solicitud = new SolicitudSala("Victor","victor@gmail.com","10:00","12:00","10/7/2017","Sala A","A9****");
        String url = solicitud.getUrl();
        String url2 = "http://perezmurillo.com/php/enviar_solicitud.php";
        assertEquals(url, url2);
    }

    @Test
    public void getCarnet() throws Exception {
        SolicitudSala solicitud = new SolicitudSala("Victor","victor@gmail.com","10:00","12:00","10/7/2017","Sala A","A9****");
        String carnet = solicitud.getCarnet();
        String carnet2 = "A9****";
        assertEquals(carnet, carnet2);
    }

    @Test
    public void setCarnet() throws Exception {
        SolicitudSala solicitud = new SolicitudSala("Victor","victor@gmail.com","10:00","12:00","10/7/2017","Sala A","A9****");
        solicitud.setCarnet("B2****");
        String carnet = solicitud.getCarnet();
        String carnet2 = "B2****";
        assertEquals(carnet, carnet2);
    }

    @Test
    public void getRequest() throws Exception {
        SolicitudSala sala = new SolicitudSala("nombre","sala","correo_solicitante","horaincial", "horafinal", "fecha", "b3****");
    }

}