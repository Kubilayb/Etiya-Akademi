package com.etiya.ecommercedemopair5.business.concretes;

import com.etiya.ecommercedemopair5.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair5.business.constants.Messages;
import com.etiya.ecommercedemopair5.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.customer.AddCustomerResponse;
import com.etiya.ecommercedemopair5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair5.entities.concretes.Customer;
import com.etiya.ecommercedemopair5.repository.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;

    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<Customer>> getAll() {
        List<Customer> response = this.customerRepository.findAll();
        return new SuccessDataResult<List<Customer>>(response, Messages.Customer.getAllCustomers);
    }

    @Override
    public DataResult<Customer> getById(int id) {
        Customer response = this.customerRepository.findById(id);
        return new SuccessDataResult<Customer>(response,Messages.Customer.getByCustomerId);
    }

    @Override
    public DataResult<Customer> getByFirstName(String name) {
        Customer response= this.customerRepository.findByCustomerFirstName(name);
        return new SuccessDataResult<Customer>(response,Messages.Customer.getCustomerFirstName);
    }

    @Override
    public DataResult<Customer> getByLastName(String name) {
        Customer response = this.customerRepository.findByCustomerLastName(name);
        return new SuccessDataResult<Customer>(response,Messages.Customer.getCustomerLastName);
    }

    @Override
    public Page<Customer> findAllWithPagination(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

   /* @Override
    public DataResult<List<Customer>> getAllNameAsc(int id) {
        List<Customer> response = this.customerRepository.findByAllName(id);
        return new SuccessDataResult<List<Customer>>(response,Messages.Customer.getAllNameAsc);
    }*/

    @Override
    public DataResult<AddCustomerResponse> addCustomer(AddCustomerRequest addCustomerRequest) {

        Customer customer =
                modelMapperService.forRequest().map(addCustomerRequest,Customer.class);
        AddCustomerResponse addCustomerResponse =
                modelMapperService.forResponse().map(customerRepository.save(customer),AddCustomerResponse.class);
        return new SuccessDataResult<AddCustomerResponse>(addCustomerResponse,Messages.Customer.addCustomer);
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