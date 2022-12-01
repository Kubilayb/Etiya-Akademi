package com.etiya.ecommerscedemopair5.repository.abstracts;

import com.etiya.ecommerscedemopair5.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
