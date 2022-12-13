package com.etiya.ecommerscedemopair5.repository.abstracts;

import com.etiya.ecommerscedemopair5.core.util.results.DataResult;
import com.etiya.ecommerscedemopair5.entities.concretes.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    //  DataResult<List<ProductCategory>> findAll();

        // ProductCategory findById(int id);

    //  List<ProductCategory> findAllProductCategoryById(int id);
    //  ProductCategory findByProductId(int productId);

    //  ProductCategory findByCategoryId(int categoryId);


}
