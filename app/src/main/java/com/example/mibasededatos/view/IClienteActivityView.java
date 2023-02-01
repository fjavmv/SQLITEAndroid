package com.example.mibasededatos.view;

import com.example.mibasededatos.entidades.ClienteDto;
import com.example.mibasededatos.entidades.CorreoDto;
import com.example.mibasededatos.entidades.TelefonoDto;

public interface IClienteActivityView {

    long registrarNuevoCLiente(ClienteDto cliente);
    long registrarNuevoCorreo(CorreoDto correoDto);
    long registrarNuevoTelefono(TelefonoDto telefonoDto);



}
