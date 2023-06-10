package com.projetao.f1databasebackend.exception;

public class EquipeNotFoundException extends RuntimeException{
    public  EquipeNotFoundException(Long id){
        super("Não foi possível encontrar a equipe com o id " + id);
    }
}
