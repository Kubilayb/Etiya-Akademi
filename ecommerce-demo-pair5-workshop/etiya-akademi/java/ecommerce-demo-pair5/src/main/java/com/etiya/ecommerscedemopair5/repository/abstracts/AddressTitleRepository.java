package com.etiya.ecommerscedemopair5.repository.abstracts;

import com.etiya.ecommerscedemopair5.entities.concretes.AddressTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressTitleRepository extends JpaRepository<AddressTitle,Integer> {

    @Query("Select at from AddressTitle as at WHERE name=:name")
    AddressTitle findByName(String name);
}
