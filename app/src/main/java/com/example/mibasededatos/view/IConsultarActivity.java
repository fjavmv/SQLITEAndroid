package com.example.mibasededatos.view;

import com.example.mibasededatos.entidades.AdeudoDto;
import com.example.mibasededatos.entidades.ConsultaClienteAdeudoDto;

import java.util.ArrayList;

public interface IConsultarActivity {
    ArrayList<ConsultaClienteAdeudoDto> consultarAdeudosClientes();
    void construirRecyclerElementos();
    long actualizarEstadoDeAdeudo(ConsultaClienteAdeudoDto consultaClienteAdeudoDto);

}
