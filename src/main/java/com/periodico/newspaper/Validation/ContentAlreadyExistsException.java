package com.periodico.newspaper.Validation;

public class ContentAlreadyExistsException extends RuntimeException{
    
    public ContentAlreadyExistsException(String message){
        super(message);
    }

}
