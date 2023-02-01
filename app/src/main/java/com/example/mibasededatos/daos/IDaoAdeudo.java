package com.example.mibasededatos.daos;

import android.widget.ArrayAdapter;

import com.example.mibasededatos.entidades.AdeudoDto;
import com.example.mibasededatos.entidades.ClienteDto;

import java.util.ArrayList;

public interface IDaoAdeudo {
    long registrarNuevoAdeudo(AdeudoDto adeudoDto);

}
