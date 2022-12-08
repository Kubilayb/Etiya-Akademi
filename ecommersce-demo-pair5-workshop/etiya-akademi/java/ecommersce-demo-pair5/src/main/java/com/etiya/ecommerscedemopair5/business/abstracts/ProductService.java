package com.etiya.ecommerscedemopair5.business.abstracts;

import com.etiya.ecommerscedemopair5.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommerscedemopair5.entities.concretes.Product;



import java.util.List;


public interface ProductService {
    List<Product> getAll();
    Product getById(int id);
    List<Product> getAllByStockGreaterThan(double stock);
    Product getByName(String name);

    AddProductResponse addProduct(AddProductRequest addProductRequest);

}
