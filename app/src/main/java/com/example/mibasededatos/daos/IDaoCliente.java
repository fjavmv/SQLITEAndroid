package com.example.mibasededatos.daos;

import com.example.mibasededatos.entidades.ClienteDto;

import java.util.ArrayList;

public interface IDaoCliente {

    long registrarNuevoCLiente(ClienteDto cliente);
    ArrayList<ClienteDto> consultarCLientes();

}
