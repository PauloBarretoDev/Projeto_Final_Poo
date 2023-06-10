package com.projetao.f1databasebackend.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeEqp;
    private String fotoEqp;

    @OneToMany(mappedBy = "equipe")
    private List<Piloto> pilotos;

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
