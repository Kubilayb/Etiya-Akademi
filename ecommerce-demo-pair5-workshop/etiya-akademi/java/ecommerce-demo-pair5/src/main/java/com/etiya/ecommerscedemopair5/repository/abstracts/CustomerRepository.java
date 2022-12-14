package com.etiya.ecommerscedemopair5.repository.abstracts;

import com.etiya.ecommerscedemopair5.entities.concretes.Customer;
import com.etiya.ecommerscedemopair5.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    List <Customer> findAllById(int id);
   // List<Customer> findByAllName(int id);

    @Query("Select c From Customer as c WHERE firstname=:name")
    Customer findByCustomerFirstName(String name);

    @Query("Select c From Customer as c WHERE lastname=:name")
    Customer findByCustomerLastName(String name);

    List<Customer> findAll();

    Customer findById(int id);

}
