package com.example.ecommerceproject.exception;

public class EmptyCartException extends Exception{
    public EmptyCartException(String message){
        super(message);
    }
}
