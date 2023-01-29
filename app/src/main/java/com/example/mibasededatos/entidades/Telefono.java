package com.example.mibasededatos.entidades;

public class Telefono {

    private int idTelefono;
    private String telefono;
    private Cliente idCliente;

    public Telefono(int idTelefono, String telefono, Cliente idCliente) {
        this.idTelefono = idTelefono;
        this.telefono = telefono;
        this.idCliente = idCliente;
    }

    public int getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(int idTelefono) {
        this.idTelefono = idTelefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
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
