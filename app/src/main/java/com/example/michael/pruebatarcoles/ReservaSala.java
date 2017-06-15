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

import static com.example.michael.pruebatarcoles.SolicitudSala.url;


public class ReservaSala extends Fragment implements View.OnClickListener, Response.ErrorListener, Response.Listener<String> {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText et_fecha;
    private Button bt_fecha, bt_inico, bt_fin, bt_reservar;
    private int dia, mes, ano, hora, minutos;

    private OnFragmentInteractionListener mListener;

    public ReservaSala() {
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reserva_sala, container, false);
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
        bt_fecha = (Button) view.findViewById(R.id.bt_fecha);
        bt_inico = (Button) view.findViewById(R.id.bt_inicio);
        bt_fin = (Button) view.findViewById(R.id.bt_fin);
        bt_reservar = (Button) view.findViewById(R.id.reservar_sala);

        bt_fecha.setOnClickListener(this);
        bt_inico.setOnClickListener(this);
        bt_fin.setOnClickListener(this);
        bt_reservar.setOnClickListener(this);

        //desabilitar edicion de camapos de texto
        ((EditText) view.findViewById(R.id.et_fecha)).setEnabled(false);
        ((EditText) view.findViewById(R.id.et_inicio)).setEnabled(false);
        ((EditText) view.findViewById(R.id.et_fin)).setEnabled(false);

    }

    @Override
    public void onClick(View v) {
        DialogFragment dg = null;
        SolicitudSala ss = null;
        String hi = ((EditText) getActivity().findViewById(R.id.et_inicio)).getText().toString();
        String hf = ((EditText) getActivity().findViewById(R.id.et_fin)).getText().toString();
        String fs = ((EditText) getActivity().findViewById(R.id.et_fecha)).getText().toString();

        switch (v.getId()){
            case R.id.bt_fecha:{
                dg =  new SelectDateFragment(fs);
                break;
            }case R.id.bt_inicio:{
                dg = new SelectTimeFragment('i',hi);
                break;
            }case R.id.bt_fin:{
                dg = new SelectTimeFragment('f',hf);
                break;
            }case R.id.reservar_sala:{
                obtenerDatos( );
                break;
            }
        }
        if(dg!=null){
            dg.show(getFragmentManager(), "DatePicker");
        }
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
        String nombre = ((EditText) getActivity().findViewById(R.id.et_nombre_ss)).getText().toString();
        String correo = ((EditText) getActivity().findViewById(R.id.et_correo_ss)).getText().toString();
        String carnet = ((EditText) getActivity().findViewById(R.id.et_carnet_ss)).getText().toString();
        String fecha = ((EditText) getActivity().findViewById(R.id.et_fecha)).getText().toString();
        String horaInicio = ((EditText) getActivity().findViewById(R.id.et_inicio)).getText().toString();
        String horaFin = ((EditText) getActivity().findViewById(R.id.et_fin)).getText().toString();
        String sala = ((Spinner) getActivity().findViewById(R.id.sp_salas)).getSelectedItem().toString();

        if(!nombre.isEmpty() && !correo.isEmpty() && !carnet.isEmpty() && !fecha.isEmpty() && !horaInicio.isEmpty() && !horaFin.isEmpty()){
            Request<?> request = getRequest(new SolicitudSala(nombre, correo, horaInicio, horaFin, fecha, sala, carnet));
            AppController.getInstance().addToRequestQueue(request);
        }else{
            Toast.makeText(getActivity().getApplicationContext(), "Por favor llene todos los campos", Toast.LENGTH_SHORT).show();
        }

    }

    public StringRequest getRequest(final SolicitudSala ss){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("true")) {
                            Toast.makeText(getActivity().getApplicationContext(), "Solicitud de Reserva Enviada", Toast.LENGTH_SHORT).show();
                            limpiarCampos();
                        }else{
                            Toast.makeText(getActivity().getApplicationContext(), "Solicitud de Reserva Fallo, intente de nievo mas tarde", Toast.LENGTH_SHORT).show();
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
                datosCorreo.put("sala",ss.getSala());
                datosCorreo.put("correo_solicitante",ss.getCorreo());
                datosCorreo.put("horaincial",ss.getHoraI());
                datosCorreo.put("horafinal",ss.getHoraF());
                datosCorreo.put("fecha",ss.getFecha());
                datosCorreo.put("carnet",ss.getCarnet());
                //returning parameter
                return datosCorreo;
            }
        };
        stringRequest.setRetryPolicy(new LongTimeoutAndTryRetryPolicy(LongTimeoutAndTryRetryPolicy.RETRIES_PHONE_ISP));
        return stringRequest;
    }

    public void limpiarCampos(){
        ((EditText) getActivity().findViewById(R.id.et_nombre_ss)).setText("");
        ((EditText) getActivity().findViewById(R.id.et_correo_ss)).setText("");
        ((EditText) getActivity().findViewById(R.id.et_carnet_ss)).setText("");
        ((EditText) getActivity().findViewById(R.id.et_fecha)).setText("");
        ((EditText) getActivity().findViewById(R.id.et_inicio)).setText("");
        ((EditText) getActivity().findViewById(R.id.et_fin)).setText("");
        ((Spinner) getActivity().findViewById(R.id.sp_salas)).setSelection(0);
    }

}
