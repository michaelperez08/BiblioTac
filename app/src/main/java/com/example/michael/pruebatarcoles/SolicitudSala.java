package com.example.michael.pruebatarcoles;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

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

        String url = "http://llantasyreencauchesgriegos.com/php/enviar_solicitud.php";
        StringRequest request = new StringRequest(Request.Method.POST, url, responseListener, errorListener){
            @Override
            public String getBodyContentType() {
                return "application/json charset="+getParamsEncoding();
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return  new JSONObject(datosCorreo).toString().getBytes(getParamsEncoding());
                }catch (UnsupportedEncodingException e){
                    return null;
                }

            }
        };

        request.setRetryPolicy(new LongTimeoutAndTryRetryPolicy(LongTimeoutAndTryRetryPolicy.RETRIES_PHONE_ISP));
        return  request;

    }

}
