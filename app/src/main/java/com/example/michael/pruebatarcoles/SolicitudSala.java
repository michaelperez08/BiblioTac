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
    private String horaI;
    private String horaF;
    private String fecha;
    private String sala;

    public static final String url = "http://llantasyreencauchesgriegos.com/php/enviar_solicitud.php";

    public SolicitudSala(String nombre, String correo, String horaI, String horaF, String fecha, String sala) {
        this.nombre = nombre;
        this.correo = correo;
        this.horaI = horaI;
        this.horaF = horaF;
        this.fecha = fecha;
        this.sala = sala;
    }

    public StringRequest getRequest (Response.Listener<String> responseListener, Response.ErrorListener errorListener){
        final HashMap<String,String> datosCorreo = new HashMap<>();
        datosCorreo.put("nombre",nombre);
        datosCorreo.put("sala",sala);
        datosCorreo.put("correo_solicitante",correo);
        datosCorreo.put("horaincial",horaI);
        datosCorreo.put("horafinal",horaF);
        datosCorreo.put("fecha",fecha);

        StringRequest request = getStringRequestSalas();

        request.setRetryPolicy(new LongTimeoutAndTryRetryPolicy(LongTimeoutAndTryRetryPolicy.RETRIES_PHONE_ISP));
        return  request;

    }

    public StringRequest getStringRequestSalas(){
        //Creating a string request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //If we are getting success from server

                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> datosCorreo = new HashMap<>();
                //Adding parameters to request
                datosCorreo.put("nombre",nombre);
                datosCorreo.put("sala",sala);
                datosCorreo.put("correo_solicitante",correo);
                datosCorreo.put("horaincial",horaI);
                datosCorreo.put("horafinal",horaF);
                datosCorreo.put("fecha",fecha);

                //returning parameter
                return datosCorreo;
            }
        };
        return stringRequest;
        //Adding the string request to the queue
    }



}
