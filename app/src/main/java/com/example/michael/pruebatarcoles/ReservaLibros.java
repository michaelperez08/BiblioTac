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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
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

import static com.example.michael.pruebatarcoles.SolicitudLibro.url;

public class ReservaLibros extends Fragment implements View.OnClickListener, Response.ErrorListener, Response.Listener<String>{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button bt_reservar;
    private Spinner sp_documentos;
    private EditText nombre;
    private EditText correo;
    private EditText carnet;
    private EditText telefono;
    private EditText signatura;
    private EditText titulo;
    private EditText titulorevista;
    private EditText autor;
    private EditText biblioteca;
    private EditText ano;
    private EditText numero;
    private EditText paginas;
    private EditText volumen;
    private Conexion conexion;

    private ReservaLibros.OnFragmentInteractionListener mListener;

    public ReservaLibros() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }



    public void formatoFormulario() {
        String documento = sp_documentos.getSelectedItem().toString();
        if(documento != null && documento.equals("Artículo de Revista")){
            biblioteca.setVisibility(View.GONE);
            titulorevista.setVisibility(View.VISIBLE);
            ano.setVisibility(View.VISIBLE);
            numero.setVisibility(View.VISIBLE);
            paginas.setVisibility(View.VISIBLE);
            volumen.setVisibility(View.VISIBLE);
        } else {
            biblioteca.setVisibility(View.VISIBLE);
            titulorevista.setVisibility(View.GONE);
            ano.setVisibility(View.GONE);
            numero.setVisibility(View.GONE);
            paginas.setVisibility(View.GONE);
            volumen.setVisibility(View.GONE);
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reserva_libros, container, false);
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
        conexion = new Conexion();
        cargarElemntosVisuales();
    }

    public void cargarElemntosVisuales(){
        nombre = ((EditText) getActivity().findViewById(R.id.et_nombre_ss));
        correo = ((EditText) getActivity().findViewById(R.id.et_correo_ss));
        carnet = ((EditText) getActivity().findViewById(R.id.et_carnet_ss));
        telefono = ((EditText) getActivity().findViewById(R.id.et_telefono_ss));;
        signatura = ((EditText) getActivity().findViewById(R.id.et_signatura_ss));
        titulo = ((EditText) getActivity().findViewById(R.id.et_titulo_ss));
        sp_documentos = ((Spinner) getActivity().findViewById(R.id.sp_documentos));
        titulorevista = ((EditText) getActivity().findViewById(R.id.et_titulorevista_ss));
        autor = ((EditText) getActivity().findViewById(R.id.et_autor_ss));
        biblioteca = ((EditText) getActivity().findViewById(R.id.et_biblioteca_ss));
        ano = ((EditText) getActivity().findViewById(R.id.et_ano_ss));
        numero = ((EditText) getActivity().findViewById(R.id.et_numero_ss));
        paginas = ((EditText) getActivity().findViewById(R.id.et_paginas_ss));
        volumen = ((EditText) getActivity().findViewById(R.id.et_volumen_ss));

        bt_reservar = (Button) getActivity().findViewById(R.id.reservar_libro);
        bt_reservar.setOnClickListener(this);
        sp_documentos = (Spinner) getActivity().findViewById(R.id.sp_documentos);
        listenerSpinner();
    }


    public void listenerSpinner(){
        sp_documentos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                formatoFormulario();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        SolicitudLibro ss = null;
        obtenerDatos( );
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
        String nombre1 = nombre.getText().toString();
        String correo1 = correo.getText().toString();
        String carnet1 = carnet.getText().toString();
        String telefono1 = telefono.getText().toString();
        String signatura1 = signatura.getText().toString();
        String titulo1 = titulo.getText().toString();
        String autor1 = autor.getText().toString();
        String biblioteca1 = biblioteca.getText().toString();
        String documento1 = sp_documentos.getSelectedItem().toString();
        String ano1 = ano.getText().toString();
        String numero1 = numero.getText().toString();
        String paginas1 = paginas.getText().toString();
        String volumen1 = volumen.getText().toString();
        String titulorevista1 = titulorevista.getText().toString();
        if(conexion.verificarConexion(this.getContext())) {
            if ((!nombre1.isEmpty() && !correo1.isEmpty() && !carnet1.isEmpty() && !telefono1.isEmpty() && !signatura1.isEmpty() && !titulo1.isEmpty() &&
                    !autor1.isEmpty() && !biblioteca1.isEmpty() && !documento1.isEmpty()) || (!nombre1.isEmpty() && !correo1.isEmpty() && !carnet1.isEmpty() && !telefono1.isEmpty() && !signatura1.isEmpty() && !titulo1.isEmpty() &&
                    !autor1.isEmpty() && !ano1.isEmpty() && !numero1.isEmpty() && !paginas1.isEmpty() && !volumen1.isEmpty() && !titulorevista1.isEmpty())) {
                Request<?> request = getRequest(new SolicitudLibro(nombre1, correo1, carnet1, telefono1, signatura1, titulo1, autor1, biblioteca1, documento1, titulorevista1, ano1, numero1, paginas1, volumen1));
                AppController.getInstance().addToRequestQueue(request);
            } else {
                Toast.makeText(getActivity().getApplicationContext(), "Por favor llene todos los campos", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getActivity().getApplicationContext(), "No tiene Conección", Toast.LENGTH_SHORT).show();
        }

    }

    public StringRequest getRequest(final SolicitudLibro ss){
        Toast.makeText(getActivity().getApplicationContext(), "Enviando... Solicitud", Toast.LENGTH_SHORT).show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("true")) {
                            Toast.makeText(getActivity().getApplicationContext(), "Solicitud de Documento Enviada", Toast.LENGTH_SHORT).show();
                            limpiarCampos();
                        }else{
                            Toast.makeText(getActivity().getApplicationContext(), "Solicitud de Documento Fallo, intente de nuevo mas tarde", Toast.LENGTH_SHORT).show();
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
                datosCorreo.put("nombre",ss.getNombre());
                datosCorreo.put("documneto",ss.getDocumento());
                datosCorreo.put("signatura",ss.getSignatura());
                datosCorreo.put("titulo",ss.getTitulo());
                datosCorreo.put("titulo_revista",ss.getTitulorevista());
                datosCorreo.put("autor",ss.getAutor());
                datosCorreo.put("biblioteca",ss.getBiblioteca());
                datosCorreo.put("correo_solicitante",ss.getCorreo());
                datosCorreo.put("telefono_solicitante",ss.getTelefono());
                datosCorreo.put("ano", ss.getAno());
                datosCorreo.put("numero", ss.getNumero());
                datosCorreo.put("paginas", ss.getPaginas());
                datosCorreo.put("volumen", ss.getVolumen());
                datosCorreo.put("carnet",ss.getCarnet());
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
        autor.setText("");
        biblioteca.setText("");
        sp_documentos.setSelection(0);
        ano.setText("");
        numero.setText("");
        volumen.setText("");
        paginas.setText("");
    }

}
