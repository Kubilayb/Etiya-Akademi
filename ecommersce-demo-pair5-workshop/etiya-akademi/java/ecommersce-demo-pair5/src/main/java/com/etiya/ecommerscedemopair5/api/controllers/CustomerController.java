package com.etiya.ecommerscedemopair5.api.controllers;

import com.etiya.ecommerscedemopair5.business.abstracts.CustomerService;
import com.etiya.ecommerscedemopair5.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.customer.AddCustomerResponse;
import com.etiya.ecommerscedemopair5.entities.concretes.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    // DI
    @Autowired
    private CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getAll")
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    @GetMapping("/getById")
    public Customer getById(@RequestParam("id") int id){
        return customerService.getById(id);
    }
    @GetMapping("{id}")
    public Customer getByIdPath(@PathVariable int id){
        return customerService.getById(id);
    }

    @GetMapping("/getByFirstName")
    public Customer getByFirstName(@RequestParam("firstname") String name){
        return customerService.getByFirstName(name);
    }

    @GetMapping("/getByLastName")
    public Customer getByLastName(@RequestParam("lastname") String name){
        return customerService.getByLastName(name);
    }

    @GetMapping("/getCustomerInfo")
    public List<Customer> getAllNameAsc(@RequestParam("id giriniz") int id){
        return customerService.getAllNameAsc(id);
    }

    @PostMapping("/add")
    public ResponseEntity<AddCustomerResponse> addCustomer(@RequestBody AddCustomerRequest addCustomerRequest){
        return new ResponseEntity<AddCustomerResponse>
                (customerService.addCustomer(addCustomerRequest),HttpStatus.CREATED);
    }
}
