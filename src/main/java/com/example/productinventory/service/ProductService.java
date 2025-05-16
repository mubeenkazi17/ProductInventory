package com.example.productinventory.service;


import com.example.productinventory.dto.ProductDetail;
import com.example.productinventory.entity.Product;
import com.example.productinventory.exception.ProductAlreadyExists;
import com.example.productinventory.exception.ProductNotExists;
import com.example.productinventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ProductService {


    private List<ProductDetail> productDetailList;
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository, List<ProductDetail> productDetailList) {
        this.productRepository = productRepository;
        this.productDetailList = productDetailList;
    }

    /*public ProductDetail saveProduct(ProductDetail productDetail)
    {
        boolean found=productDetailList.stream().anyMatch(n->n.getProductId().equals(productDetail.getProductId()));
            if(found) {
                throw new ProductAlreadyExists("Product Already Exists "+productDetail.getProductId());
            }
            else {
                productDetailList.add(productDetail);
                productDetailList.forEach(n-> System.out.println(n));
                return productDetail;

            }
    }*/

    public ProductDetail saveProduct(ProductDetail productDetail)
    {
        Boolean isMatching=productDetailList.stream().anyMatch(n->n.getProductId().equals(productDetail.getProductId()));
        if (isMatching)
        {
            throw new ProductAlreadyExists("Product already Exists"+productDetail.getProductId());
        }
        productDetailList.add(productDetail);
        System.out.println("Product is added");
        return productDetail;
    }

    public ProductDetail getProduct(int productId)
    {
        List<ProductDetail> productDetailsList=productDetailList.stream().filter(n->n.getProductId().equals(productId)).toList();

        if(productDetailsList.isEmpty())
        {
            throw new ProductNotExists("product not exists: "+productId);
        }
        return productDetailsList.get(0);
    }

    public Product getProductByCount(int count)
    {
        productRepository.findByProductCountGreaterThan(count);
        productRepository.findQuantityBySQL(count);
        return productRepository.findQuantityByJPQL(count);

    }

    public String insertAllProduct()
    {



        List<Product> allProduct = Stream.of(
                new Product("iphone","mobile",10,"abc@email.com"),
                new Product("iwatch","watch",10,"abc@email.com"),
                new Product("ipad","Tablet",10,"abc@email.com"),
                new Product("macbook","laptop",10,"abc@email.com"),
                new Product("iTv","tv",10,"abc@email.com")).toList();

        List<Product> products = productRepository.saveAll(allProduct);
        return "All Records Stored";
    }

    public Optional<Product> getProductById(Integer id)
    {
        return productRepository.findById(id);

    }

    public List<Product> getAllProductFromDb()
    {

        return productRepository.findAll();

    }


    public List<Product> findByProductNameAndProductCount(String productName, int count)
    {
        return productRepository.findByProductNameAndProductCount(productName, count);
    }

    public List<Product> findByProductName(String productName)
    {
        return productRepository.findByProductName(productName);
    }

    public List<Product> findByProductCount(Integer productCount)
    {
        return productRepository.findByProductCount(productCount);
    }


    //Sorting
    public List<Product> sortByProductName(String productName)
    {
       return productRepository.findAll(Sort.by(productName));
    }


    //pageNumber is number of page start from 0
    //Page size is the number of records in 1 page
    public Page<Product> findProductWithPagination(int pageNumber, int pageSize)
    {
        return productRepository.findAll(PageRequest.of(pageNumber,pageSize));

    }
}
