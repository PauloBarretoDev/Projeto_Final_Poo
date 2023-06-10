package com.projetao.f1databasebackend.service;

import com.projetao.f1databasebackend.exception.EquipeNotFoundException;
import com.projetao.f1databasebackend.model.Equipe;
import com.projetao.f1databasebackend.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;

    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    public Equipe getEquipeById(Long id) {
        return equipeRepository.findById(id)
                .orElseThrow(() -> new EquipeNotFoundException(id));
    }

    public Equipe createEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    public Equipe updateEquipe(Long id, Equipe equipe) {
        Equipe existingEquipe = equipeRepository.findById(id)
                .orElseThrow(() -> new EquipeNotFoundException(id));
        existingEquipe.setNomeEqp(equipe.getNomeEqp());
        existingEquipe.setFotoEqp(equipe.getFotoEqp());
        return equipeRepository.save(existingEquipe);
    }
    public void deleteEquipe(Long id) {
        equipeRepository.deleteById(id);
    }
}
