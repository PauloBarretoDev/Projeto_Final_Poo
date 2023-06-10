package com.projetao.f1databasebackend.exception;

public class PilotoNotFoundException extends RuntimeException{
    public  PilotoNotFoundException(Long id){
        super("Não foi possível encontrar o piloto com o id " + id);
    }
}
