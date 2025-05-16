package com.example.productinventory.exception;


import com.example.productinventory.dto.ErrorResponse;
import com.example.productinventory.dto.ProductDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionHandler {

 /*   @ExceptionHandler(ProductAlreadyExists.class)
    public ProblemDetail duplicateProduct(ProductAlreadyExists ex)
    {
       return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_GATEWAY, ex.getMessage());
       *//*return ErrorResponse.builder().message(ex.getMessage()).
               statusCode(HttpStatus.BAD_GATEWAY)
               .status("FAIL").build();*//*
    }

    @ExceptionHandler(ProductNotExists.class)
    public ErrorResponse noProduct(ProductNotExists ex)
    {
        return ErrorResponse.builder().message(ex.getMessage()).
                statusCode(HttpStatus.BAD_GATEWAY)
                .status("FAIL").build();
    }*/
    @ExceptionHandler(ProductAlreadyExists.class)
    public ProblemDetail duplicateProduct(ProductAlreadyExists ex)
    {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
       //return ErrorResponse.builder().message(ex.getMessage()).statusCode(HttpStatus.BAD_GATEWAY).status("Fail").build();
    }
}
