package com.example.springbootcache.exception;

public class CustomerNotFoundException extends  RuntimeException {
    public CustomerNotFoundException(Long id){
        super(String.format("City with Id %d not found", id));
    }
}
