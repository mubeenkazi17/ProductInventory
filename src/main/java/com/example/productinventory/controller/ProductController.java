package com.example.productinventory.controller;


import com.example.productinventory.dto.ErrorResponse;
import com.example.productinventory.dto.ProductDetail;
import com.example.productinventory.entity.Product;
import com.example.productinventory.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/saveProduct")
    public ResponseEntity<Object> saveProduct(@RequestBody @Valid ProductDetail productDetail, BindingResult result) {
        List<String> errorList = null;
        if (result.hasErrors()) {
            errorList = result.getAllErrors().stream().map(n -> n.getDefaultMessage()).toList();
            return ResponseEntity.badRequest().body(errorList);
        }


        ProductDetail productDetailResponse = productService.saveProduct(productDetail);
        return ResponseEntity.ok().body(productDetailResponse);
    }



    @GetMapping("/getProduct/{id}")
    public ProductDetail getProduct(@PathVariable Integer id)
    {
        return productService.getProduct(id);
    }

    //------- JPA

    @GetMapping("/insertAll")
    public String insertAllProduct()
    {
        return productService.insertAllProduct();
    }

    @GetMapping("/getAllRecords")
    public List<Product> getAllProducts()
    {
        return productService.getAllProductFromDb();
    }
    @GetMapping("/getByProductNameAndCount/{productName}/{count}")
    public List<Product> getProductsByName(@PathVariable String productName, @PathVariable int count)
    {
        return productService.findByProductNameAndProductCount(productName, count);
       // return productService. sortByProductName(productName);
    }
    
    @GetMapping("/getProductById/{id}")
    public Optional<Product> getById(@PathVariable Integer id)
    {
       return productService.getProductById(id);
    }
    
    
    @GetMapping("/getByProductCount/{count}")
    public List<Product> getProductByCount(@PathVariable Integer count)
    {
        return productService.findByProductCount(count);
    }

    @GetMapping("/getProductByProductCount/{id}")
    public Product getById(@PathVariable int id)
    {
        return productService.getProductByCount(id);
    }




}
