package com.example.michael.pruebatarcoles;

/**
 * Created by victoru on 28/06/17.
 */

public class SolicitudLocalizacionLibro {
    private String nombre;
    private String correo;
    private String carnet;
    private String telefono;
    private String signatura;
    private String titulo;
    private String tituloRevista;
    private String autor;
    private String biblioteca;
    private String idioma;
    private String fecha;
    private String documento;
    private String tipoUsuario;
    private String ano;
    private String numero;
    private String paginas;
    private String volumen;
    private String otros;

    public static final String url = "http://perezmurillo.com/php/busqueda_libro.php";

    public SolicitudLocalizacionLibro(String nombre, String correo, String carnet, String telefono, String signatura, String titulo, String tituloRevista, String autor, String biblioteca, String idioma, String fecha, String documento, String tipoUsuario, String ano, String numero, String paginas, String volumen, String otros) {
        this.nombre = nombre;
        this.correo = correo;
        this.carnet = carnet;
        this.telefono = telefono;
        this.signatura = signatura;
        this.titulo = titulo;
        this.tituloRevista = tituloRevista;
        this.autor = autor;
        this.biblioteca = biblioteca;
        this.idioma = idioma;
        this.fecha = fecha;
        this.documento = documento;
        this.tipoUsuario = tipoUsuario;
        this.ano = ano;
        this.numero = numero;
        this.paginas = paginas;
        this.volumen = volumen;
        this.otros = otros;
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

    public String getTituloRevista() {
        return tituloRevista;
    }

    public void setTituloRevista(String tituloRevista) {
        this.tituloRevista = tituloRevista;
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

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public static String getUrl() {
        return url;
    }
}
