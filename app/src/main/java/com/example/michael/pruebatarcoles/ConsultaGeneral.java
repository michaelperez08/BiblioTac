package com.example.michael.pruebatarcoles;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

import java.util.HashMap;
import java.util.Map;

import static com.example.michael.pruebatarcoles.SolicitudSala.url;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ConsultaGeneral.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ConsultaGeneral#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsultaGeneral extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button bt_enviar_cg;
    private final String url = "http://perezmurillo.com/php/consulta_general.php";
    private Conexion conexion;

    private OnFragmentInteractionListener mListener;

    public ConsultaGeneral() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConsultaGeneral.
     */
    // TODO: Rename and change types and number of parameters
    public static ConsultaGeneral newInstance(String param1, String param2) {
        ConsultaGeneral fragment = new ConsultaGeneral();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        bt_enviar_cg = (Button) getActivity().findViewById(R.id.bt_enviar_cg);
        bt_enviar_cg.setOnClickListener(this);
        conexion = new Conexion();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_consulta_general, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onClick(View v) {
        obtenerDatos();
    }

    public void obtenerDatos(){
        String nombre = ((EditText) getActivity().findViewById(R.id.et_nombre_cg)).getText().toString();
        String correo = ((EditText) getActivity().findViewById(R.id.et_correo_cg)).getText().toString();
        String telefono = ((EditText) getActivity().findViewById(R.id.et_telefono_cg)).getText().toString();
        String consulta = ((EditText) getActivity().findViewById(R.id.et_consulta_general)).getText().toString();
        if(conexion.verificarConexion(this.getContext())) {
            if (!nombre.isEmpty() && !correo.isEmpty() && !telefono.isEmpty() && !consulta.isEmpty()) {
                Request<?> request = getRequest(nombre, correo, consulta, telefono);
                AppController.getInstance().addToRequestQueue(request);
                Toast.makeText(getActivity().getApplicationContext(), "Enviando... Solicitud", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity().getApplicationContext(), "Por favor llene todos los campos", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getActivity().getApplicationContext(), "No tiene Conección", Toast.LENGTH_SHORT).show();
        }

    }

    public StringRequest getRequest(final String nombre, final String correo, final String consulta, final String telefono){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("true")) {
                            Toast.makeText(getActivity().getApplicationContext(), "Consulta Enviada", Toast.LENGTH_SHORT).show();
                            limpiarCampos();
                        }else{
                            Toast.makeText(getActivity().getApplicationContext(), "Fallo al enviar la consulta, intente de nuevo mas tarde", Toast.LENGTH_SHORT).show();
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
                datosCorreo.put("nombre",nombre);
                datosCorreo.put("telefono",telefono);
                datosCorreo.put("correo_solicitante",correo);
                datosCorreo.put("consulta",consulta);
                //returning parameter
                return datosCorreo;
            }
        };
        stringRequest.setRetryPolicy(new LongTimeoutAndTryRetryPolicy(LongTimeoutAndTryRetryPolicy.RETRIES_PHONE_ISP));
        return stringRequest;
    }

    public void limpiarCampos(){
        ((EditText) getActivity().findViewById(R.id.et_nombre_cg)).setText("");
        ((EditText) getActivity().findViewById(R.id.et_correo_cg)).setText("");
        ((EditText) getActivity().findViewById(R.id.et_consulta_general)).setText("");
        ((EditText) getActivity().findViewById(R.id.et_telefono_cg)).setText("");
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
