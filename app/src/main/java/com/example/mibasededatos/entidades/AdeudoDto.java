package com.example.mibasededatos.entidades;

public class AdeudoDto {
    private long idAdeudo;
    private long idCLiente;
    private String tipoAdeudo;
    private double montoAdeudo;
    private String fechaAdeudo;
    private String estadoAdeudo;
    private String descripcion;

    public AdeudoDto(long idAdeudo, long idCLiente, String tipoAdeudo, double montoAdeudo, String fechaAdeudo, String estadoAdeudo, String descripcion) {
        this.idAdeudo = idAdeudo;
        this.idCLiente = idCLiente;
        this.tipoAdeudo = tipoAdeudo;
        this.montoAdeudo = montoAdeudo;
        this.fechaAdeudo = fechaAdeudo;
        this.estadoAdeudo = estadoAdeudo;
        this.descripcion = descripcion;
    }

    public AdeudoDto(long idCLiente, String tipoAdeudo, double montoAdeudo, String fechaAdeudo, String estadoAdeudo, String descripcion) {

        this.idCLiente = idCLiente;
        this.tipoAdeudo = tipoAdeudo;
        this.montoAdeudo = montoAdeudo;
        this.fechaAdeudo = fechaAdeudo;
        this.estadoAdeudo = estadoAdeudo;
        this.descripcion = descripcion;
    }

    public long getIdAdeudo() {
        return idAdeudo;
    }

    public void setIdAdeudo(long idAdeudo) {
        this.idAdeudo = idAdeudo;
    }

    public long getIdCLiente() {
        return idCLiente;
    }

    public void setIdCLiente(long idCLiente) {
        this.idCLiente = idCLiente;
    }

    public String getTipoAdeudo() {
        return tipoAdeudo;
    }

    public void setTipoAdeudo(String tipoAdeudo) {
        this.tipoAdeudo = tipoAdeudo;
    }

    public double getMontoAdeudo() {
        return montoAdeudo;
    }

    public void setMontoAdeudo(double montoAdeudo) {
        this.montoAdeudo = montoAdeudo;
    }

    public String getFechaAdeudo() {
        return fechaAdeudo;
    }

    public void setFechaAdeudo(String fechaAdeudo) {
        this.fechaAdeudo = fechaAdeudo;
    }

    public String getEstadoAdeudo() {
        return estadoAdeudo;
    }

    public void setEstadoAdeudo(String estadoAdeudo) {
        this.estadoAdeudo = estadoAdeudo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return
                idAdeudo + " " +idCLiente + " " + tipoAdeudo +
                        " " + montoAdeudo + " " + fechaAdeudo + " " + estadoAdeudo + " " + descripcion;
    }
}
