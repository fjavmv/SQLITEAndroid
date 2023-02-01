package com.example.mibasededatos.view;

import com.example.mibasededatos.entidades.AdeudoDto;
import com.example.mibasededatos.entidades.ClienteDto;

import java.util.ArrayList;

public interface IAdeudoActivityVIew {
    long registrarNuevoAdeudo(AdeudoDto adeudoDto);
    ArrayList<ClienteDto> consultarCLientes();
    void construirRecyclerElementos();
}
