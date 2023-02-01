package com.example.mibasededatos.entidades;

public class TelefonoDto {

    private long idTelefono;
    private String telefono;
    private long idCliente;

    public TelefonoDto(long idTelefono, String telefono, long idCliente) {
        this.idTelefono = idTelefono;
        this.telefono = telefono;
        this.idCliente = idCliente;
    }

    public TelefonoDto(String telefono, long idCliente) {
        this.telefono = telefono;
        this.idCliente = idCliente;
    }

    public long getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(long idTelefono) {
        this.idTelefono = idTelefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "idTelefono=" + idTelefono +
                ", telefono='" + telefono + '\'' +
                ", idCliente=" + idCliente +
                '}';
    }
}
