package com.etiya.ecommerscedemopair5.repository.abstracts;

import com.etiya.ecommerscedemopair5.entities.concretes.Cargo;
import com.etiya.ecommerscedemopair5.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CargoRepository extends JpaRepository<Cargo,Integer> {


    List<Cargo> findAllCargosByPriceGreaterThanOrderByPriceDesc(int price);

    @Query("Select c from Product as c WHERE name=:name")
    Cargo findByName(String name);
}
