package com.example.productinventory.exception;

public class ProductAlreadyExists extends RuntimeException{

    public ProductAlreadyExists(String message) {
        super(message);
    }

}
