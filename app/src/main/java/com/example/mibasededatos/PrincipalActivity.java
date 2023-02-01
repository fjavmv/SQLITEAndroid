package com.example.mibasededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mibasededatos.view.AdeudoActivity;
import com.example.mibasededatos.view.ClienteActivity;
import com.example.mibasededatos.view.ConsultarActivity;

public class PrincipalActivity extends AppCompatActivity {
    /*private EditText mEditTextTitulo;
    private EditText mEditTextFecha; // campo a enlazar con el DatePicker
    private EditText mEditTextContenido;
    //private Spinner mSpinnerTipoNota;*/
    private Button mButtonRegistrarCliente;
    private Button mButtonRegistrarAdeudo;
    private Button mButtonConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        mButtonRegistrarCliente = findViewById(R.id.btn_registra_cliente);
        mButtonRegistrarAdeudo = findViewById(R.id.btn_registra_adeudo);
        mButtonConsultar = findViewById(R.id.btn_consultar_adeudos);

        mButtonRegistrarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ClienteActivity.class);
                startActivity(intent);
            }
        });

        mButtonRegistrarAdeudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdeudoActivity.class);
                startActivity(intent);
            }
        });

        mButtonConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ConsultarActivity.class);
                startActivity(intent);
            }
        });



       /* mEditTextTitulo = findViewById(R.id.edt_titulo);
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
        });*/

    }
/*
    private void mostrarCalendario(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(getApplicationContext(),R.style.DatePickerStyle, this, Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        String date = month + "/" + dayOfMonth + "/" + year;
        mEditTextFecha.setText(date);
    }
    }*/
}