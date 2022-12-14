package com.etiya.ecommercedemopair5.repository.abstracts;

import com.etiya.ecommercedemopair5.entities.concretes.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    //  DataResult<List<ProductCategory>> findAll();

        // ProductCategory findById(int id);

    //  List<ProductCategory> findAllProductCategoryById(int id);
    //  ProductCategory findByProductId(int productId);

    //  ProductCategory findByCategoryId(int categoryId);


}
