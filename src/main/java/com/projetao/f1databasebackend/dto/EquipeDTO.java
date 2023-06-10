package com.projetao.f1databasebackend.dto;

public class EquipeDTO {
    private long id;
    private String nomeEqp;
    private String fotoEqp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeEqp() {
        return nomeEqp;
    }

    public void setNomeEqp(String nomeEqp) {
        this.nomeEqp = nomeEqp;
    }

    public String getFotoEqp() {
        return fotoEqp;
    }

    public void setFotoEqp(String fotoEqp) {
        this.fotoEqp = fotoEqp;
    }
}
