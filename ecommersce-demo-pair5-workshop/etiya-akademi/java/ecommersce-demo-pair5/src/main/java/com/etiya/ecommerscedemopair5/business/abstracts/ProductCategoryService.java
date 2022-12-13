package com.etiya.ecommerscedemopair5.business.abstracts;

import com.etiya.ecommerscedemopair5.business.dtos.request.productcategory.AddProductCategoryRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.productcategory.AddProductCategoryResponse;
import com.etiya.ecommerscedemopair5.core.util.results.DataResult;
import com.etiya.ecommerscedemopair5.entities.concretes.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

     DataResult<List<ProductCategory>> getAll();
     DataResult<ProductCategory> getById(int id);
     DataResult<AddProductCategoryResponse> addProductCategory(AddProductCategoryRequest addProductCategoryRequest);


    //List<ProductCategory> getByAllProductCategoryId(int id);
    //List<ProductCategory> getByCategoryId(int id);


}
