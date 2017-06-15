package com.example.michael.pruebatarcoles;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by michael on 28/04/17.
 */

public class SelectDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private String fechainiciada;
    final Calendar calendar = Calendar.getInstance();

    public SelectDateFragment(String fechainiciada) {
        this.fechainiciada = fechainiciada;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        populateSetDate(year, month, dayOfMonth);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        int yy = getAno();
        int mm = getMes();
        int dd = getDia();
        return new DatePickerDialog(getActivity(), this, yy, mm, dd);
    }

    public void populateSetDate(int year, int month, int day) {
        EditText et_fecha = (EditText) getActivity().findViewById(R.id.et_fecha);
        et_fecha.setText(String.format("%02d/%02d/%s", day, month, year));
    }

    public int getAno(){
        if(!fechainiciada.isEmpty()) {
            String m = fechainiciada.substring(6, 10);
            return Integer.parseInt(fechainiciada.substring(6, 10));
        }else{
            return calendar.get(Calendar.YEAR);
        }
    }

    public int getMes(){
        if(!fechainiciada.isEmpty()) {
            String m = fechainiciada.substring(3, 5);
            return Integer.parseInt(fechainiciada.substring(3, 5));
        }else{
            return calendar.get(Calendar.MONTH);
        }
    }

    public int getDia(){
        if(!fechainiciada.isEmpty()) {
            String m = fechainiciada.substring(0, 2);
            return Integer.parseInt(fechainiciada.substring(0, 2));
        }else{
            return calendar.get(Calendar.DAY_OF_MONTH);
        }
    }

}
