package com.example.michael.pruebatarcoles;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InformacionSalas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class InformacionSalas extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private ArrayList<Sala> listaSalas;
    private Button bt_anterior, bt_siguente;
    private TextView tv_titulo, tv_descripcion;
    private Spinner sp_infoSalas;
    private ImageView iv_sala;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public InformacionSalas() {
        // Required empty public constructor
        cargarSalas();

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment InformacionSalas.
     */
    // TODO: Rename and change types and number of parameters

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cargarElemntosVisuales();
        cargarSala();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_informacion_salas, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onClick(View v) {
        int posicion = sp_infoSalas.getSelectedItemPosition();
        switch (v.getId()){
            case R.id.bt_anterior:
                if(posicion>0){
                    sp_infoSalas.setSelection(posicion-1);
                }
                break;
            case R.id.bt_siguiente:
                if(posicion<5){
                    sp_infoSalas.setSelection(posicion+1);
                }
                break;
        }
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void cargarSalas(){
        listaSalas = new ArrayList<>();
        listaSalas.add(new Sala(R.drawable.salaa,"Sala A","Hucacion: por ahi\nCapacidad n personas"));
        listaSalas.add(new Sala(R.drawable.salab,"Sala B","Hucacion: por ahi\nCapacidad n personas"));
        listaSalas.add(new Sala(R.drawable.audiovisual,"Sala de Proyecciones","Hucacion: por ahi\nCapacidad n personas"));
        listaSalas.add(new Sala(R.drawable.auditorio,"Auditorio","Hucacion: por ahi\nCapacidad n personas"));
        listaSalas.add(new Sala(R.drawable.investigacion,"Sala de Investigacion","Hucacion: por ahi\nCapacidad n personas"));
        listaSalas.add(new Sala(R.drawable.idiomas,"Laboratorio de Idiomas","Hucacion: por ahi\nCapacidad n personas"));
    }



    public void cargarElemntosVisuales(){
        tv_descripcion = (TextView) getActivity().findViewById(R.id.tv_descripcion);
        tv_titulo = (TextView) getActivity().findViewById(R.id.tv_titulo);
        sp_infoSalas = (Spinner) getActivity().findViewById(R.id.sp_infoSalas);
        iv_sala = (ImageView) getActivity().findViewById(R.id.iv_sala);
        bt_anterior = (Button) getActivity().findViewById(R.id.bt_anterior);
        bt_anterior.setOnClickListener(this);
        bt_siguente = (Button) getActivity().findViewById(R.id.bt_siguiente);
        bt_siguente.setOnClickListener(this);
        setSp_infoSalas_changeItemListener();
    }

    public void setSp_infoSalas_changeItemListener(){
        sp_infoSalas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cargarSala();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void cargarSala(){
        Sala salaTemp = listaSalas.get(sp_infoSalas.getSelectedItemPosition());
        tv_descripcion.setText(salaTemp.getDescripcion());
        tv_titulo.setText(salaTemp.getTitulo());
        iv_sala.setImageResource(salaTemp.getImg());
    }
}
