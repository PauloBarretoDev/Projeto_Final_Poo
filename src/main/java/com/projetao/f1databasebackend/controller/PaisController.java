package com.projetao.f1databasebackend.controller;
import com.projetao.f1databasebackend.exception.PaisNotFoundException;
import com.projetao.f1databasebackend.model.Pais;
import com.projetao.f1databasebackend.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000/")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping("/pais")
    Pais newPais(@RequestBody Pais newPais) { return paisRepository.save(newPais); }

    @GetMapping("/paises")
    List<Pais> getAllPaises() { return paisRepository.findAll(); }

    @GetMapping("/pais/{id}")
    Pais getPaisById(@PathVariable Long id){
        return paisRepository.findById(id)
                .orElseThrow(()->new PaisNotFoundException(id));
    }

    @PutMapping("/pais/{id}")
    Pais updatePais(@RequestBody Pais newPais, @PathVariable Long id){
        return paisRepository.findById(id)
                .map(pais -> {
                    pais.setFotoPais(newPais.getFotoPais());
                    pais.setNomePais(newPais.getNomePais());
                    return paisRepository.save(pais);
                }).orElseThrow(()->new PaisNotFoundException(id));
    }

    @DeleteMapping("/pais/{id}")
    String deletePais(@PathVariable Long id){
        if(!paisRepository.existsById(id)){
            throw new PaisNotFoundException(id);
        }
        paisRepository.deleteById(id);
        return "País com o  id " +id+ " foi deletada com sucesso!";
    }
}
