package com.etiya.ecommerscedemopair5.repository.abstracts;

import com.etiya.ecommerscedemopair5.business.dtos.ProductDTO;
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

    // com.etiya.ecommerscedemopair5.business.dtos.ProductDTO
    @Query("Select new com.etiya.ecommerscedemopair5.business.dtos.ProductDTO(p.id,p.name)" +
            " from Product p WHERE p.id=:id")
    List<ProductDTO> findByExample(int id);


    // findAll-Products-By-Stock-GreaterThan(int stock)

    // Adres id'si 3 olan en çok sipariş edilen ürünler veya ürün

  /*  @Query(value = "select * from products p \n" +
            "inner join orders o \n" +
            "on o.productid=p.id\n" +
            "where o.addressid=:addressid and p.id=:id",nativeQuery = true)
    List<Product> findTopSellingProductById(int id,int addressid);*/

}
