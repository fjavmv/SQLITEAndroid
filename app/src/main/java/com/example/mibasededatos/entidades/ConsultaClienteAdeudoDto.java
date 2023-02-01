package com.example.mibasededatos.entidades;

public class ConsultaClienteAdeudoDto {
    private String nombreCLiente;
    private String apellidoP;
    private String apellidoM;
    private String tipoDeAdeudo;
    private int precio;
    private String fecha;

    public ConsultaClienteAdeudoDto(String nombreCLiente, String apellidoP, String apellidoM, String tipoDeAdeudo, int precio, String fecha) {
        this.nombreCLiente = nombreCLiente;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.tipoDeAdeudo = tipoDeAdeudo;
        this.precio = precio;
        this.fecha = fecha;
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

    @Override
    public String toString() {
        return nombreCLiente +" " + apellidoP + " " + apellidoM + " " + tipoDeAdeudo + '\'' +
                " " + precio +
                " " + fecha;
    }
}
