package com.example.mibasededatos.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;

import com.example.mibasededatos.R;

public class AdeudoActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adeudo);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}