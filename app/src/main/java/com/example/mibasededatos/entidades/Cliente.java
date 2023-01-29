package com.example.mibasededatos.entidades;

public class Cliente {
    private int idCliente;
    private String nombre;
    private String apellidoPaterno;
    private String getApellidoMaterno;

    public Cliente(int idCliente, String nombre, String apellidoPaterno, String getApellidoMaterno) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.getApellidoMaterno = getApellidoMaterno;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getGetApellidoMaterno() {
        return getApellidoMaterno;
    }

    public void setGetApellidoMaterno(String getApellidoMaterno) {
        this.getApellidoMaterno = getApellidoMaterno;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", getApellidoMaterno='" + getApellidoMaterno + '\'' +
                '}';
    }
}

