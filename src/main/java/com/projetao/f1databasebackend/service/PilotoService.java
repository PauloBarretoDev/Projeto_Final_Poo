package com.projetao.f1databasebackend.service;

import com.projetao.f1databasebackend.exception.PilotoNotFoundException;
import com.projetao.f1databasebackend.model.Piloto;
import com.projetao.f1databasebackend.repository.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotoService {

    @Autowired
    private PilotoRepository pilotoRepository;

    public List<Piloto> getAllPilotos() {
        return pilotoRepository.findAll();
    }

    public Piloto getPilotoById(Long id) {
        return pilotoRepository.findById(id)
                .orElseThrow(() -> new PilotoNotFoundException(id));
    }

    public Piloto createPiloto(Piloto piloto) {
        return pilotoRepository.save(piloto);
    }

    public Piloto updatePiloto(Long id, Piloto piloto) {
        Piloto existingPiloto = pilotoRepository.findById(id)
                .orElseThrow(() -> new PilotoNotFoundException(id));
        existingPiloto.setNome(piloto.getNome());
        existingPiloto.setFoto(piloto.getFoto());
        existingPiloto.setVitorias(piloto.getVitorias());
        existingPiloto.setPais(piloto.getPais());
        existingPiloto.setEquipe(piloto.getEquipe());
        return pilotoRepository.save(existingPiloto);
    }
    public void deletePiloto(Long id) {
        pilotoRepository.deleteById(id);
    }
}
