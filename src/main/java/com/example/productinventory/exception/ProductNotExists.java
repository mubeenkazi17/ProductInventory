package com.example.productinventory.exception;


public class ProductNotExists extends RuntimeException{

    public ProductNotExists(String message) {
        super(message);
    }
}
