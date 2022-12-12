package com.etiya.ecommerscedemopair5.api.controllers;

import com.etiya.ecommerscedemopair5.business.abstracts.AddressService;
import com.etiya.ecommerscedemopair5.business.dtos.AddressDTO;
import com.etiya.ecommerscedemopair5.business.dtos.CategoryDTO;
import com.etiya.ecommerscedemopair5.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommerscedemopair5.core.util.results.DataResult;
import com.etiya.ecommerscedemopair5.core.util.results.Result;
import com.etiya.ecommerscedemopair5.entities.concretes.Address;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/address")
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService){
        this.addressService=addressService;
    }
    @GetMapping("/getAll")
    public List<Address> getAll() {
        return addressService.getAll();
    }

    @GetMapping("{id}")
    public Address getById(@PathVariable int id){
        return addressService.getById(id);
    }

    @GetMapping("/findByAddressExampleDTO")
    public DataResult<List<AddressDTO>> findByAddressExample(int id){
        return this.addressService.findByAddressExample(id);
    }




    @PostMapping("/add")
   public ResponseEntity<AddAddressResponse> addAddress(@RequestBody AddAddressRequest addAddressRequest){
        return new ResponseEntity<AddAddressResponse>(addressService.addAddress(addAddressRequest), HttpStatus.CREATED);
   }

}