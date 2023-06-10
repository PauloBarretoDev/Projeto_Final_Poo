package com.projetao.f1databasebackend.controller;
import com.projetao.f1databasebackend.exception.PilotoNotFoundException;
import com.projetao.f1databasebackend.model.Piloto;
import com.projetao.f1databasebackend.repository.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000/")
public class PilotoController {

    @Autowired
    private PilotoRepository pilotoRepository;

    @PostMapping("/piloto")
    Piloto newPiloto(@RequestBody Piloto newPiloto){
        return pilotoRepository.save(newPiloto);
    }

    @GetMapping("/pilotos")
    List<Piloto> getAllPilotos(){
        return pilotoRepository.findAll();
    }

    @GetMapping("/piloto/{id}")
    Piloto getPilotoById(@PathVariable Long id){
        return pilotoRepository.findById(id)
                .orElseThrow(()->new PilotoNotFoundException(id));
    }

    @PutMapping("/piloto/{id}")
    Piloto updatePiloto(@RequestBody Piloto newPiloto, @PathVariable Long id){
        return pilotoRepository.findById(id)
                .map(piloto -> {
                    piloto.setFoto(newPiloto.getFoto());
                    piloto.setNome(newPiloto.getNome());
                    piloto.setVitorias(newPiloto.getVitorias());
                    piloto.setEquipe(newPiloto.getEquipe());
                    piloto.setPais(newPiloto.getPais());
                    return pilotoRepository.save(piloto);
                }).orElseThrow(()->new PilotoNotFoundException(id));
    }

    @DeleteMapping("/piloto/{id}")
    String deletePiloto(@PathVariable Long id){
        if(!pilotoRepository.existsById(id)){
            throw new PilotoNotFoundException(id);
        }
        pilotoRepository.deleteById(id);
        return "Piloto com o  id " +id+ " foi deletado com sucesso!";
    }
}
