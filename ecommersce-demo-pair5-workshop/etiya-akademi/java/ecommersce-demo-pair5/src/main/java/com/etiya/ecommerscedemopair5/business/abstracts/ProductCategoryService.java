package com.etiya.ecommerscedemopair5.business.abstracts;

import com.etiya.ecommerscedemopair5.business.dtos.request.productcategory.AddProductCategoryRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.productcategory.AddProductCategoryResponse;
import com.etiya.ecommerscedemopair5.entities.concretes.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

     List<ProductCategory> getAll();
     ProductCategory getById(int id);
     AddProductCategoryResponse addProductCategory(AddProductCategoryRequest addProductCategoryRequest);


    //List<ProductCategory> getByAllProductCategoryId(int id);
    //List<ProductCategory> getByCategoryId(int id);


}
