package com.projetao.f1databasebackend.service;

import com.projetao.f1databasebackend.exception.PaisNotFoundException;
import com.projetao.f1databasebackend.model.Pais;
import com.projetao.f1databasebackend.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    public List<Pais> getAllPaises() {
        return paisRepository.findAll();
    }

    public Pais getPaisById(Long id) {
        return paisRepository.findById(id)
                .orElseThrow(() -> new PaisNotFoundException(id));
    }

    public Pais createPais(Pais pais) {
        return paisRepository.save(pais);
    }

    public Pais updatePais(Long id, Pais pais) {
        Pais existingPais = paisRepository.findById(id)
                .orElseThrow(() -> new PaisNotFoundException(id));
        existingPais.setNomePais(pais.getNomePais());
        existingPais.setFotoPais(pais.getFotoPais());
        return paisRepository.save(existingPais);
    }
    public void deletePais(Long id) {
        paisRepository.deleteById(id);
    }
}
