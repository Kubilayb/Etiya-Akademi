package com.etiya.ecommerscedemopair5.business.abstracts;

import com.etiya.ecommerscedemopair5.entities.concretes.City;
import com.etiya.ecommerscedemopair5.entities.concretes.Product;
import com.etiya.ecommerscedemopair5.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;


public interface ProductService {
    List<Product> getAll();
    Product getById(int id);
    List<Product> getAllByStockGreaterThan(double stock);
    Product getByName(String name);



}
