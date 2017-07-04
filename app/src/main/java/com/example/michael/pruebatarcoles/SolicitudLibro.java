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
 * Created by victoru on 27/06/17.
 */

public class SolicitudLibro {
    private String nombre;
    private String correo;
    private String carnet;
    private String telefono;
    private String signatura;
    private String titulo;
    private String autor;
    private String biblioteca;
    private String documento;
    private String titulorevista;
    private String ano;
    private String numero;
    private String paginas;
    private String volumen;

    public static final String url = "http://perezmurillo.com/php/solicitud_documento.php";

    public SolicitudLibro () {
    }

    public SolicitudLibro(String nombre, String correo, String carnet, String telefono, String signatura, String titulo, String autor, String biblioteca, String documento, String titulorevista, String ano, String numero, String paginas, String volumen) {
        this.nombre = nombre;
        this.correo = correo;
        this.carnet = carnet;
        this.telefono = telefono;
        this.signatura = signatura;
        this.titulo = titulo;
        this.autor = autor;
        this.biblioteca = biblioteca;
        this.documento = documento;
        this.titulorevista = titulorevista;
        this.ano = ano;
        this.numero = numero;
        this.paginas = paginas;
        this.volumen = volumen;
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

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSignatura() {
        return signatura;
    }

    public void setSignatura(String signatura) {
        this.signatura = signatura;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(String biblioteca) {
        this.biblioteca = biblioteca;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTitulorevista() {
        return titulorevista;
    }

    public void setTitulorevista(String titulorevista) {
        this.titulorevista = titulorevista;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public static String getUrl() {
        return url;
    }
}
