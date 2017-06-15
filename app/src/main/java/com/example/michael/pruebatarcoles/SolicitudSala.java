package com.example.michael.pruebatarcoles;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by michael on 24/05/17.
 */

public class SolicitudSala {

    private String nombre;
    private String correo;
    private String carnet;
    private String horaI;
    private String horaF;
    private String fecha;
    private String sala;

    public static final String url = "http://perezmurillo.com/php/enviar_solicitud.php";

    public SolicitudSala(String nombre, String correo, String horaI, String horaF, String fecha, String sala, String carnet) {
        this.nombre = nombre;
        this.correo = correo;
        this.horaI = horaI;
        this.horaF = horaF;
        this.fecha = fecha;
        this.sala = sala;
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getHoraI() {
        return horaI;
    }

    public void setHoraI(String horaI) {
        this.horaI = horaI;
    }

    public String getHoraF() {
        return horaF;
    }

    public void setHoraF(String horaF) {
        this.horaF = horaF;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public static String getUrl() {
        return url;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }
}
