package com.etiya.ecommerscedemopair5.repository.abstracts;

import com.etiya.ecommerscedemopair5.entities.concretes.Cargo;
import com.etiya.ecommerscedemopair5.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CargoRepository extends JpaRepository<Cargo,Integer> {

    List<Cargo> findAllCargosByPriceGreaterThanOrderByPriceDesc(int price);

   // List<Cargo> findAllByPrice(int price);

    @Query("Select ca from Product as ca WHERE name=:name")
    Cargo findByName(String name);
}
