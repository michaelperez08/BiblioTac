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
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        populateSetTime(hourOfDay, minute);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int hora = calendar.get(Calendar.HOUR_OF_DAY);
        int minutos = calendar.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, hora, minutos, DateFormat.is24HourFormat(getActivity()));
    }

    public void populateSetTime(int hora, int minutos) {
        EditText et_inicio = (EditText) getActivity().findViewById(R.id.et_inicio);
        et_inicio.setText(hora+":"+minutos);
    }
}
