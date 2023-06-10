package com.projetao.f1databasebackend.exception;

public class PaisNotFoundException extends RuntimeException{
    public  PaisNotFoundException(Long id){
        super("Não foi possível encontrar o país com o id " + id);
    }
}
