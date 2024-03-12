package com.example.ecommerceproject.exception;

public class InsufficientQuantityException extends Exception{
    public InsufficientQuantityException(String message){
        super(message);
    }
}
