package com.projetao.f1databasebackend.controller;
import com.projetao.f1databasebackend.exception.EquipeNotFoundException;
import com.projetao.f1databasebackend.model.Equipe;
import com.projetao.f1databasebackend.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000/")
public class EquipeController {

    @Autowired
    private EquipeRepository equipeRepository;

    @PostMapping("/equipe")
    Equipe newEquipe(@RequestBody Equipe newEquipe){
        return equipeRepository.save(newEquipe);
    }

    @GetMapping("/equipes")
    List<Equipe> getAllEquipes(){
        return equipeRepository.findAll();
    }

    @GetMapping("/equipe/{id}")
    Equipe getEquipeById(@PathVariable Long id){
        return equipeRepository.findById(id)
                .orElseThrow(()->new EquipeNotFoundException(id));
    }

    @PutMapping("/equipe/{id}")
    Equipe updateEquipe(@RequestBody Equipe newEquipe, @PathVariable Long id){
        return equipeRepository.findById(id)
                .map(equipe -> {
                    equipe.setFotoEqp(newEquipe.getFotoEqp());
                    equipe.setNomeEqp(newEquipe.getNomeEqp());
                    return equipeRepository.save(equipe);
                }).orElseThrow(()->new EquipeNotFoundException(id));
    }

    @DeleteMapping("/equipe/{id}")
    String deleteEquipe(@PathVariable Long id){
        if(!equipeRepository.existsById(id)){
            throw new EquipeNotFoundException(id);
        }
        equipeRepository.deleteById(id);
        return "Equipe com o  id " +id+ " foi deletada com sucesso!";
    }
}
