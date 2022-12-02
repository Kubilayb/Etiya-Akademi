package com.etiya.ecommerscedemopair5.repository.abstracts;

import com.etiya.ecommerscedemopair5.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    // Stock sayısına göre stock alanı gelen int değerden fazla olan productlar.

    // findAll-Products-By-Stock(int stock)
    // findAll-Products-By-Stock-GreaterThan(int stock)
    List<Product> findAllProductsByStockGreaterThanOrderByStockDesc(double stock);


    // default olarak native SQL DEĞİL!
    // JPQL
    // :parametreIsmi
    @Query("Select p from Product as p WHERE name=:name")
    Product findByName(String name);

    // findAll-Products-By-Stock-GreaterThan(int stock)

}
