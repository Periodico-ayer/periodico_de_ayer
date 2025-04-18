package com.periodico.newspaper.Validation;

public class CategoryAlreadyExistsException extends RuntimeException{
    
    public CategoryAlreadyExistsException(String message){
        super(message);
    }

}
