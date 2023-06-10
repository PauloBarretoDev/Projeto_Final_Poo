package com.projetao.f1databasebackend.repository;

import com.projetao.f1databasebackend.model.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PilotoRepository extends JpaRepository<Piloto, Long> {
    Piloto findByNome(String nome);
    List<Piloto> findByVitoriasLessThan(int vitorias);
    List<Piloto> findByVitoriasGreaterThan(int vitorias);
    List<Piloto> findByNomeIsNull();
    List<Piloto> findByNomeIsNotNull();
    List<Piloto> findByNomeLike(String nome);
    List<Piloto> findByNomeNotLike(String nome);
    List<Piloto> findByNomeOrderByVitoriasDesc(String nome);
}
