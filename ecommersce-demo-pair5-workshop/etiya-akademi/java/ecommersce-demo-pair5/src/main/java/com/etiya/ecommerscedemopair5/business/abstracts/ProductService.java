package com.etiya.ecommerscedemopair5.business.abstracts;

import com.etiya.ecommerscedemopair5.entities.concretes.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product getById(int id);
}
