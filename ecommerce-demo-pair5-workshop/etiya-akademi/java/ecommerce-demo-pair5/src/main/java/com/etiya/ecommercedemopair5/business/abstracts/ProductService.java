package com.etiya.ecommercedemopair5.business.abstracts;

import com.etiya.ecommercedemopair5.business.dtos.ProductDTO;
import com.etiya.ecommercedemopair5.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.entities.concretes.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;


import java.util.List;


public interface ProductService {
    DataResult<List<Product>> getAll();
    DataResult<Product> getById(int id);
    DataResult<List<Product>> getAllByStockGreaterThan(double stock);
    DataResult<Product> getByName(String name);

   /* List<Product> findTopSellingProductById(int id,int addressid);*/
    DataResult<AddProductResponse> addProduct(AddProductRequest addProductRequest);
    DataResult<List<ProductDTO>> findByExample(int id);

    Page<Product> findAllWithPagination(Pageable pageable); //parametre olarak aldık (Page page)

    Slice<Product> findAllWithSlice(Pageable pageable);

   // Page<ProductDTO> findAllWithPaginationDto(Pageable pageable);

}
