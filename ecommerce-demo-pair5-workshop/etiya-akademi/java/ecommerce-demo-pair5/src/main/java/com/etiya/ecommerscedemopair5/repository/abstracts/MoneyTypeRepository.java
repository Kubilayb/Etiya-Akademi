package com.etiya.ecommerscedemopair5.repository.abstracts;

import com.etiya.ecommerscedemopair5.entities.concretes.MoneyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MoneyTypeRepository extends JpaRepository<MoneyType,Integer> {

    @Query("Select mt from Product as mt WHERE name=:name")
    MoneyType findByName(String name);
}
