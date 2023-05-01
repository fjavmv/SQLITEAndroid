package com.example.mibasededatos.entidades;

import androidx.annotation.NonNull;

public class ConsultaClienteAdeudoDto {
    private long idAdeudo;
    private String nombreCLiente;
    private String apellidoP;
    private String apellidoM;
    private String tipoDeAdeudo;
    private int precio;
    private String fecha;
    private String updateAt;
    private String estadoAdeudo;


    public ConsultaClienteAdeudoDto(String nombreCLiente, String apellidoP, String apellidoM, String tipoDeAdeudo, int precio, String fecha) {
        this.nombreCLiente = nombreCLiente;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.tipoDeAdeudo = tipoDeAdeudo;
        this.precio = precio;
        this.fecha = fecha;
    }

    public ConsultaClienteAdeudoDto(long idAdeudo, String nombreCLiente, String apellidoP, String apellidoM, String tipoDeAdeudo, int precio, String fecha) {
        this.idAdeudo = idAdeudo;
        this.nombreCLiente = nombreCLiente;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.tipoDeAdeudo = tipoDeAdeudo;
        this.precio = precio;
        this.fecha = fecha;
    }

    public ConsultaClienteAdeudoDto(long idAdeudo,  String estadoAdeudo,String updateAt) {
        this.idAdeudo = idAdeudo;
        this.updateAt = updateAt;
        this.estadoAdeudo = estadoAdeudo;
    }

    public long getIdAdeudo() {
        return idAdeudo;
    }

    public void setIdAdeudo(long idAdeudo) {
        this.idAdeudo = idAdeudo;
    }

    public String getEstadoAdeudo() {
        return estadoAdeudo;
    }

    public void setEstadoAdeudo(String estadoAdeudo) {
        this.estadoAdeudo = estadoAdeudo;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }


    public String getNombreCLiente() {
        return nombreCLiente;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public String getTipoDeAdeudo() {
        return tipoDeAdeudo;
    }

    public int getPrecio() {
        return precio;
    }

    public String getFecha() {
        return fecha;
    }

    @NonNull
    @Override
    public String toString() {
        return idAdeudo + " " + nombreCLiente + " " + apellidoP + " " + apellidoM + " " + tipoDeAdeudo + " " + precio +
                " " + fecha;
    }
}
