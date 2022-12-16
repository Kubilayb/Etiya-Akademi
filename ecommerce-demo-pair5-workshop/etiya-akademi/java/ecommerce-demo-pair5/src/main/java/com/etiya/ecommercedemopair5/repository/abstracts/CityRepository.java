package com.etiya.ecommercedemopair5.repository.abstracts;

import com.etiya.ecommercedemopair5.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends JpaRepository<City,Integer> {
    @Query("Select c from City as c WHERE name=:name")

    City findByName(String name);

    boolean existsCityByName(String name);

}
