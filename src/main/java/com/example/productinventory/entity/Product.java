package com.example.productinventory.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
//@Table(name="PRODUCT_TBL")
public class Product {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   private Integer productId;
   private String productName;
   private String productType;
   private int productCount;
   private String productOwnerEmail;

    public Product(String productName, String productType, int productCount, String productOwnerEmail) {
        this.productName = productName;
        this.productType = productType;
        this.productCount = productCount;
        this.productOwnerEmail = productOwnerEmail;
    }
}
