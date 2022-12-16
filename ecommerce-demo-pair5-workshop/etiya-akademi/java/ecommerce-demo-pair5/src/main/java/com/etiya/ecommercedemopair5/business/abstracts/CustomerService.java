package com.etiya.ecommercedemopair5.business.abstracts;

import com.etiya.ecommercedemopair5.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.customer.AddCustomerResponse;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.entities.concretes.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    DataResult<List<Customer>> getAll();
    DataResult<Customer> getById(int id);

    DataResult<Customer> getByFirstName(String name);

    DataResult<Customer> getByLastName(String name);
    Page<Customer> findAllWithPagination(Pageable pageable);

  //  DataResult<List<Customer>> getAllNameAsc(int id);

    DataResult<AddCustomerResponse> addCustomer(AddCustomerRequest addCustomerRequest);
}
