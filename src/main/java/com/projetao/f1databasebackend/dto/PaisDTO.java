package com.projetao.f1databasebackend.dto;

public class PaisDTO {
    private long id;
    private String nomePais;
    private String fotoPais;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    public String getFotoPais() {
        return fotoPais;
    }

    public void setFotoPais(String fotoPais) {
        this.fotoPais = fotoPais;
    }
}
