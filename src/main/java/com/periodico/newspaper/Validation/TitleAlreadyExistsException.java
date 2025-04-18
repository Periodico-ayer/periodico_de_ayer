package com.periodico.newspaper.Validation;

public class TitleAlreadyExistsException extends RuntimeException{
    
    public TitleAlreadyExistsException(String message){
        super(message);
    }

}
