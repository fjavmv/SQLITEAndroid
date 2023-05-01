package com.example.mibasededatos.daos;

import com.example.mibasededatos.entidades.AdeudoDto;
import com.example.mibasededatos.entidades.ConsultaClienteAdeudoDto;

import java.util.ArrayList;

public interface IDaoConsultaClienteAdeudo {
    ArrayList<ConsultaClienteAdeudoDto> consultarAdeudosClientes();
    int actualizarEstadoDeAdeudo(ConsultaClienteAdeudoDto consultaClienteAdeudoDto);
}
