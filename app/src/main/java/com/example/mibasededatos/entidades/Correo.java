package com.example.mibasededatos.entidades;

public class Correo {
    private int idCorreo;
    private String correo;
    private Cliente idCLiente;

    public Correo(int idCorreo, String correo, Cliente idCLiente) {
        this.idCorreo = idCorreo;
        this.correo = correo;
        this.idCLiente = idCLiente;
    }

    public int getIdCorreo() {
        return idCorreo;
    }

    public void setIdCorreo(int idCorreo) {
        this.idCorreo = idCorreo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Cliente getIdCLiente() {
        return idCLiente;
    }

    public void setIdCLiente(Cliente idCLiente) {
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
