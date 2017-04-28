package com.example.michael.pruebatarcoles;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class ReservaSala extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText et_fecha;
    private Button bt_fecha, bt_inico, bt_fin;
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
        bt_fecha.setOnClickListener(this);
        bt_inico.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        DialogFragment dg = null;
        switch (v.getId()){
            case R.id.bt_fecha:{
                dg =  new SelectDateFragment();
                break;
            }case R.id.bt_inicio:{
                dg = new SelectTimeFragment();
                break;
            }
        }
        dg.show(getFragmentManager(), "DatePicker");
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
