package com.example.michael.pruebatarcoles;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alberto on 25/05/17.
 */
public class SolicitudSalaTest {
    @Test
    public void getRequest() throws Exception {
        SolicitudSala sala = new SolicitudSala("nombre","sala","correo_solicitante","horaincial", "horafinal", "fecha","");
    }

}