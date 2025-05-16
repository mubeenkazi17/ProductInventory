package com.example.productinventory.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductDetail {

    @NotNull(message = "Product Id should not be null")
    @Min(value = 1, message = "Please Enter product id above 1")
    private Integer productId;
    @NotNull(message = "Product Name should not be null")
    //@Size()
    private String productName;
    @NotNull(message = "Product Type should not be null")
    private String productType;
    @NotNull(message = "Product Count should not be null")
    @Min(value = 1, message = "Please Enter product id above 1")
    private int productCount;
    @NotNull(message = "Product Email should not be null")
    @Email(message = "Please Enter proper Email")
    private String productOwnerEmail;

    public String getProductOwnerEmail() {
        return productOwnerEmail;
    }

    public void setProductOwnerEmail(String productOwnerEmail) {
        this.productOwnerEmail = productOwnerEmail;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }
}
