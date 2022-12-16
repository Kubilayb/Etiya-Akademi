package com.etiya.ecommercedemopair5.business.abstracts;

import com.etiya.ecommercedemopair5.business.dtos.request.productcategory.AddProductCategoryRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.productcategory.AddProductCategoryResponse;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.entities.concretes.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductCategoryService {

     DataResult<List<ProductCategory>> getAll();
     DataResult<ProductCategory> getById(int id);
     DataResult<AddProductCategoryResponse> addProductCategory(AddProductCategoryRequest addProductCategoryRequest);

     Page<ProductCategory> findAllWithPagination(Pageable pageable);
    //List<ProductCategory> getByAllProductCategoryId(int id);
    //List<ProductCategory> getByCategoryId(int id);


}
