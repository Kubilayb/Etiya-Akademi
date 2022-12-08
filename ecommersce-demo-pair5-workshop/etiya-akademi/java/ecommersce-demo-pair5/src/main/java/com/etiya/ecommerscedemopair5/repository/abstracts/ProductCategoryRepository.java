package com.etiya.ecommerscedemopair5.repository.abstracts;

import com.etiya.ecommerscedemopair5.entities.concretes.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {


   /* List<ProductCategory> findAll();

    ProductCategory findById(int id);

    List<ProductCategory> findAllProductCategoryById(int id);
    ProductCategory findByProductId(int productId);

    ProductCategory findByCategoryId(int categoryId);

    */
}
