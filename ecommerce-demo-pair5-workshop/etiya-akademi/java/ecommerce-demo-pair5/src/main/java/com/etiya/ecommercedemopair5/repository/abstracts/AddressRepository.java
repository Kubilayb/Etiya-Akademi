package com.etiya.ecommercedemopair5.repository.abstracts;

import com.etiya.ecommercedemopair5.business.dtos.AddressDTO;
import com.etiya.ecommercedemopair5.entities.concretes.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {

    @Query("Select a from Address as a WHERE street=:name")
    List<Address> findByName(String name);

    @Query("Select new com.etiya.ecommerscedemopair5.business.dtos.AddressDTO(a.id,a.street)" +
            " from Address a WHERE a.id=:id")
    List<AddressDTO> findByAddressExample(int id);

    boolean existsById(int id);


/*    @Query("Select c from City c join c.id=:id")
    List<Address> customAddress(int id);*/
}

