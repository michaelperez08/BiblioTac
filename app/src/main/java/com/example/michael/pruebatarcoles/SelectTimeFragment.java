package com.example.michael.pruebatarcoles;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by michael on 28/04/17.
 */

public class SelectTimeFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

    public char h;
    public String fechainiciada;
    int indexminutos = 2;

    public SelectTimeFragment(char h, String fechainiciada) {
        this.h = h;
        this.fechainiciada = fechainiciada;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        populateSetTime(hourOfDay, minute);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int hora = getHoraSeleccionada();
        int minutos = getMinutosSeleccionados();

        return new TimePickerDialog(getActivity(), this, hora, minutos, DateFormat.is24HourFormat(getActivity()));
    }

    public void populateSetTime(int hora, int minutos) {
        int id = 0;

        if(h=='i'){
            id = R.id.et_inicio;
        }else{
            id = R.id.et_fin;
        }

        EditText et = (EditText) getActivity().findViewById(id);

        int horadeldia = hora % 12;
        if (horadeldia == 0)
            horadeldia = 12;

        et.setText(String.format("%02d:%02d %s", horadeldia, minutos,
                hora < 12 ? "am" : "pm"));
    }

    public int getHoraSeleccionada(){
        final Calendar calendar = Calendar.getInstance();
        int hora = 0;


        if (!fechainiciada.isEmpty()){
            hora = Integer.parseInt(fechainiciada.substring(0,2)+"");
            int largo = fechainiciada.length();
            String h = fechainiciada.substring(largo-2,largo);
            if(h.equals("pm")){
                hora=hora+12;
            }
        }else{
            hora = calendar.get(Calendar.HOUR);
        }
        return hora;
    }

    public int getMinutosSeleccionados(){
        final Calendar calendar = Calendar.getInstance();
        int minutos = 0;


        if (!fechainiciada.isEmpty()){
            //String m = fechainiciada.substring(3,5);
            minutos = Integer.parseInt(fechainiciada.substring(3,5)+"");
        }else{
            minutos = calendar.get(Calendar.MINUTE);
        }
        return minutos;
    }



}
