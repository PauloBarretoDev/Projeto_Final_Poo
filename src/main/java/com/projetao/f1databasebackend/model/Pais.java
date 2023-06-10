package com.projetao.f1databasebackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomePais;
    private String fotoPais;
    @OneToMany(mappedBy = "pais")
    private List<Piloto> pilotos;

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
