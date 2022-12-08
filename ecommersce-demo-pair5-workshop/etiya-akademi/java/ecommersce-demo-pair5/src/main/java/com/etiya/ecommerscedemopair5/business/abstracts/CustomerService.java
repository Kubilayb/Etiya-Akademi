package com.etiya.ecommerscedemopair5.business.abstracts;

import com.etiya.ecommerscedemopair5.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.customer.AddCustomerResponse;
import com.etiya.ecommerscedemopair5.entities.concretes.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAll();
    Customer getById(int id);

    Customer getByFirstName(String name);

    Customer getByLastName(String name);

    List<Customer> getAllNameAsc(int id);

    AddCustomerResponse addCustomer(AddCustomerRequest addCustomerRequest);
}
