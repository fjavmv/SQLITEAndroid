package com.example.mibasededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    private EditText mEditTextTitulo;
    private EditText mEditTextFecha; // campo a enlazar con el DatePicker
    private EditText mEditTextContenido;
    //private Spinner mSpinnerTipoNota;
    private Button mButtonGuardar;
    private Button mButtonCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditTextTitulo = findViewById(R.id.edt_titulo);
        mEditTextFecha = findViewById(R.id.edt_fecha);
        //mSpinnerTipoNota = rootView.findViewById(R.id.tipo_mensaje);
        mEditTextContenido = findViewById(R.id.edt_contenido);
        mButtonGuardar = findViewById(R.id.btn_guardar);
        mButtonCancelar = findViewById(R.id.btn_cancelar);

        mEditTextFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarCalendario();
            }
        });

    }

    private void mostrarCalendario(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,R.style.DatePickerStyle, this, Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        String date = month + "/" + dayOfMonth + "/" + year;
        mEditTextFecha.setText(date);
    }
}