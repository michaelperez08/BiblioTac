package com.example.michael.pruebatarcoles;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;


public class BusquedaLibro extends Fragment implements View.OnClickListener, Response.ErrorListener, Response.Listener<String>, AdapterView.OnItemSelectedListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText et_fecha;
    private Button bt_reservar, bt_fecha;
    private EditText otros;
    private EditText nombre;
    private EditText correo;
    private EditText carnet;
    private EditText telefono;
    private EditText fecha;
    private EditText signatura;
    private EditText titulo;
    private Spinner tipoUsuario;
    private Spinner documento;
    private EditText titulorevista;
    private EditText autor;
    private EditText biblioteca;
    private EditText idioma;
    private EditText ano;
    private EditText numero;
    private EditText paginas;
    private EditText volumen;
    private Conexion conexion;



    private ReservaLibros.OnFragmentInteractionListener mListener;

    public BusquedaLibro() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_busqueda_libro, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        otros = ((EditText) getActivity().findViewById(R.id.et_otros_ss));
        nombre = ((EditText) getActivity().findViewById(R.id.et_nombre_ss));
        correo = ((EditText) getActivity().findViewById(R.id.et_correo_ss));
        carnet = ((EditText) getActivity().findViewById(R.id.et_carnet_ss));
        telefono = ((EditText) getActivity().findViewById(R.id.et_telefono_ss));
        fecha = ((EditText) getActivity().findViewById(R.id.et_fecha));
        signatura = ((EditText) getActivity().findViewById(R.id.et_signatura_ss));
        titulo = ((EditText) getActivity().findViewById(R.id.et_titulo_ss));
        tipoUsuario = ((Spinner) getActivity().findViewById(R.id.sp_tipousuario));
        documento = ((Spinner) getActivity().findViewById(R.id.sp_documentos));
        titulorevista = ((EditText) getActivity().findViewById(R.id.et_titulorevista_ss));
        autor = ((EditText) getActivity().findViewById(R.id.et_autor_ss));
        biblioteca = ((EditText) getActivity().findViewById(R.id.et_biblioteca_ss));
        idioma = ((EditText) getActivity().findViewById(R.id.et_idioma_ss));
        ano = ((EditText) getActivity().findViewById(R.id.et_ano_ss));
        numero = ((EditText) getActivity().findViewById(R.id.et_numero_ss));
        paginas = ((EditText) getActivity().findViewById(R.id.et_paginas_ss));
        volumen = ((EditText) getActivity().findViewById(R.id.et_volumen_ss));
        bt_fecha = (Button) view.findViewById(R.id.bt_fecha);
        bt_reservar = (Button) view.findViewById(R.id.busqueda_libro);
        conexion = new Conexion();
        bt_fecha.setOnClickListener(this);
        bt_reservar.setOnClickListener(this);

        //desabilitar edicion de camapos de texto
        ((EditText) view.findViewById(R.id.et_fecha)).setEnabled(false);
        ((Spinner) getActivity().findViewById(R.id.sp_documentos)).setOnItemSelectedListener(this);

    }

    @Override
    public void onClick(View v) {
        DialogFragment dg = null;
        SolicitudLocalizacionLibro ss = null;
        String fs = ((EditText) getActivity().findViewById(R.id.et_fecha)).getText().toString();

        switch (v.getId()){
            case R.id.bt_fecha:{
                dg =  new SelectDateFragment(fs);
                break;
            }case R.id.busqueda_libro:{
                obtenerDatos( );
                break;
            }
        }
        if(dg!=null){
            dg.show(getFragmentManager(), "DatePicker");
        }
    }


    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        String documento2 = documento.getSelectedItem().toString();
        if(documento2 != null && documento2.equals("Artículo de Revista")){

            otros.setVisibility(View.GONE);
            signatura.setVisibility(View.VISIBLE);
            titulorevista.setVisibility(View.VISIBLE);
            ano.setVisibility(View.VISIBLE);
            numero.setVisibility(View.VISIBLE);
            paginas.setVisibility(View.VISIBLE);
            volumen.setVisibility(View.VISIBLE);
        } else {
            if (documento2 != null && documento2.equals("Otro")){
                otros.setVisibility(View.VISIBLE);
                titulorevista.setVisibility(View.GONE);
                ano.setVisibility(View.VISIBLE);
                numero.setVisibility(View.GONE);
                paginas.setVisibility(View.GONE);
                volumen.setVisibility(View.GONE);
                signatura.setVisibility(View.GONE);
            } else {
                signatura.setVisibility(View.VISIBLE);
                otros.setVisibility(View.GONE);
                titulorevista.setVisibility(View.GONE);
                ano.setVisibility(View.GONE);
                numero.setVisibility(View.GONE);
                paginas.setVisibility(View.GONE);
                volumen.setVisibility(View.GONE);
            }
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("Error", error.getMessage());
    }

    @Override
    public void onResponse(String response) {
        GsonBuilder builder = new GsonBuilder();
        builder.setExclusionStrategies(new DefaultExclusionStrategy());
        Gson gson = builder.create();

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void obtenerDatos(){
        String nombre2 = nombre.getText().toString();
        String correo2 = correo.getText().toString();
        String carnet2 = carnet.getText().toString();
        String telefono2 = telefono.getText().toString();
        String tipoUsuario2 = tipoUsuario.getSelectedItem().toString();
        String fecha2 = fecha.getText().toString();
        String signatura2 = signatura.getText().toString();
        String titulo2 = titulo.getText().toString();
        String titulorevista2 = titulorevista.getText().toString();
        String autor2 = autor.getText().toString();
        String biblioteca2 = biblioteca.getText().toString();
        String idioma2 = idioma.getText().toString();
        String documento2 = documento.getSelectedItem().toString();
        String ano2 = ano.getText().toString();
        String numero2 = numero.getText().toString();
        String paginas2 = paginas.getText().toString();
        String volumen2 = volumen.getText().toString();
        String otro2 = otros.getText().toString();
        if(conexion.verificarConexion(this.getContext())) {
            if ((!nombre2.isEmpty() && !correo2.isEmpty() && !carnet2.isEmpty() && !fecha2.isEmpty() && !telefono2.isEmpty()
                    && !titulo2.isEmpty() && !autor2.isEmpty() && !biblioteca2.isEmpty() && !idioma2.isEmpty() && !signatura2.isEmpty()) ||
                    (!nombre2.isEmpty() && !correo2.isEmpty() && !carnet2.isEmpty() && !telefono2.isEmpty() && !titulo2.isEmpty() && !autor2.isEmpty()
                            && !idioma2.isEmpty() && !signatura2.isEmpty() && !titulorevista2.isEmpty() && !ano2.isEmpty() && !numero2.isEmpty() && !paginas2.isEmpty() && !volumen2.isEmpty()) || (!nombre2.isEmpty() && !correo2.isEmpty() && !carnet2.isEmpty() && !fecha2.isEmpty() && !telefono2.isEmpty()
                    && !titulo2.isEmpty() && !autor2.isEmpty() && !biblioteca2.isEmpty() && !idioma2.isEmpty() && !otro2.isEmpty() && !ano2.isEmpty())) {
                Request<?> request = getRequest(new SolicitudLocalizacionLibro(nombre2, correo2, carnet2, telefono2, signatura2, titulo2, titulorevista2, autor2, biblioteca2,
                        idioma2, fecha2, documento2, tipoUsuario2, ano2, numero2, paginas2, volumen2, otro2));
                AppController.getInstance().addToRequestQueue(request);
                Toast.makeText(getActivity().getApplicationContext(), "Enviando... Solicitud", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity().getApplicationContext(), "Por favor llene todos los campos", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getActivity().getApplicationContext(), "No tiene Conección", Toast.LENGTH_SHORT).show();
        }

    }

    public StringRequest getRequest(final SolicitudLocalizacionLibro ss){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, SolicitudLocalizacionLibro.getUrl(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("true")) {
                            Toast.makeText(getActivity().getApplicationContext(), "Busqueda de Documento Enviada", Toast.LENGTH_SHORT).show();
                            limpiarCampos();
                        }else{
                            Toast.makeText(getActivity().getApplicationContext(), "Fallo la busqueda del documento, intente de nuevo mas tarde", Toast.LENGTH_SHORT).show();
                        }
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
                datosCorreo.put("tipo_usuario",ss.getTipoUsuario());
                datosCorreo.put("nombre",ss.getNombre());
                datosCorreo.put("tipo_documento",ss.getDocumento());
                datosCorreo.put("asignatura",ss.getSignatura());
                datosCorreo.put("titulo",ss.getTitulo());
                datosCorreo.put("titulo_revista",ss.getTituloRevista());
                datosCorreo.put("autor",ss.getAutor());
                datosCorreo.put("idioma",ss.getIdioma());
                datosCorreo.put("biblioteca",ss.getBiblioteca());
                datosCorreo.put("correo_solicitante",ss.getCorreo());
                datosCorreo.put("telefono",ss.getTelefono());
                datosCorreo.put("carnet",ss.getCarnet());
                datosCorreo.put("fecha",ss.getFecha());
                datosCorreo.put("ano", ss.getAno());
                datosCorreo.put("numero", ss.getNumero());
                datosCorreo.put("paginas", ss.getPaginas());
                datosCorreo.put("volumen", ss.getVolumen());
                datosCorreo.put("otros", ss.getOtros());
                //returning parameter
                return datosCorreo;
            }
        };
        stringRequest.setRetryPolicy(new LongTimeoutAndTryRetryPolicy(LongTimeoutAndTryRetryPolicy.RETRIES_PHONE_ISP));
        return stringRequest;
    }

    public void limpiarCampos(){
        nombre.setText("");
        correo.setText("");
        carnet.setText("");
        telefono.setText("");
        signatura.setText("");
        titulo.setText("");
        titulorevista.setText("");
        idioma.setText("");
        autor.setText("");
        biblioteca.setText("");
        ano.setText("");
        numero.setText("");
        volumen.setText("");
        paginas.setText("");
        otros.setText("");
        documento.setSelection(0);
        tipoUsuario.setSelection(0);
    }
}
