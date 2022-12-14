package com.etiya.ecommercedemopair5.repository.abstracts;

import com.etiya.ecommercedemopair5.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

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
