package com.etiya.ecommerscedemopair5.business.concretes;

import com.etiya.ecommerscedemopair5.business.abstracts.CustomerService;
import com.etiya.ecommerscedemopair5.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.customer.AddCustomerResponse;
import com.etiya.ecommerscedemopair5.business.dtos.response.payment.AddPaymentResponse;
import com.etiya.ecommerscedemopair5.core.util.mapping.ModelMapperService;
import com.etiya.ecommerscedemopair5.entities.concretes.Customer;
import com.etiya.ecommerscedemopair5.entities.concretes.Payment;
import com.etiya.ecommerscedemopair5.repository.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;

    private ModelMapperService modelMapperService;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer getByFirstName(String name) {
        return customerRepository.findByCustomerFirstName(name);
    }

    @Override
    public Customer getByLastName(String name) {
        return customerRepository.findByCustomerLastName(name);
    }

    @Override
    public List<Customer> getAllNameAsc(int id) {
        return customerRepository.findAllById(id);
    }

    @Override
    public AddCustomerResponse addCustomer(AddCustomerRequest addCustomerRequest) {

        Customer customer =
                modelMapperService.forRequest().map(addCustomerRequest,Customer.class);
        AddCustomerResponse addCustomerResponse =
                modelMapperService.forResponse().map(customerRepository.save(customer),AddCustomerResponse.class);
        return addCustomerResponse;
    }
}

/*Customer customer = new Customer();

        customer.setFirstname(addCustomerRequest.getFirstname());
        customer.setLastname(addCustomerRequest.getLastname());
        customer.setPhonenumber(addCustomerRequest.getPhonenumber());
        customer.setBirthday(addCustomerRequest.getBirthday());

        Customer savedCustomer = customerRepository.save(customer);

        AddCustomerResponse response = new AddCustomerResponse(savedCustomer.getId(),savedCustomer.getFirstname(),
                savedCustomer.getLastname(),savedCustomer.getPhonenumber(),savedCustomer.getBirthday());
        return response;*/