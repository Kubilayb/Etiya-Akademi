package com.etiya.ecommerscedemopair5.repository.abstracts;

import com.etiya.ecommerscedemopair5.entities.concretes.Address;
import com.etiya.ecommerscedemopair5.entities.concretes.AddressTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {

    @Query("Select a from Address as a WHERE street=:name")
    List<Address> findByName(String name);



}
