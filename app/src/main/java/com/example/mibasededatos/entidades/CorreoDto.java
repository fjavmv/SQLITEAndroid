package com.example.mibasededatos.entidades;

public class CorreoDto {
    private long idCorreo;
    private String correo;
    private long idCLiente;

    public CorreoDto(long idCorreo, String correo, long idCLiente) {
        this.idCorreo = idCorreo;
        this.correo = correo;
        this.idCLiente = idCLiente;
    }
    public CorreoDto(String correo, long idCLiente) {
        this.correo = correo;
        this.idCLiente = idCLiente;
    }


    public long getIdCorreo() {
        return idCorreo;
    }

    public void setIdCorreo(long idCorreo) {
        this.idCorreo = idCorreo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getIdCLiente() {
        return idCLiente;
    }

    public void setIdCLiente(long idCLiente) {
        this.idCLiente = idCLiente;
    }

    @Override
    public String toString() {
        return "Correo{" +
                "idCorreo=" + idCorreo +
                ", correo='" + correo + '\'' +
                ", idCLiente=" + idCLiente +
                '}';
    }
}
