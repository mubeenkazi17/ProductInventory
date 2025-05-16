package com.example.productinventory.repository;

import com.example.productinventory.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<> {

    //Method Based
     List<Product> findByProductName(String productName);

    List<Product> findByProductCount(Integer productCount);

    List<Product> findByProductNameAndProductCount(String productName, int count);



     //3 Ways
    //Native SQL Query
    //JPQL
    //MethodBased

    @Query(value= "SELECT * from Product where product_count > ?1", nativeQuery = true)
    List<Product> findQuantityBySQL(int count);

    @Query(value="SELECT p  from Product p where p.productCount > ?1" )
    Product findQuantityByJPQL(int count);

    List<Product> findByProductCountGreaterThan(int count);


}
