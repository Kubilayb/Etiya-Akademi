package com.etiya.ecommercedemopair5.api.controllers;

import com.etiya.ecommercedemopair5.business.abstracts.AddressService;
import com.etiya.ecommercedemopair5.business.dtos.AddressDTO;
import com.etiya.ecommercedemopair5.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.entities.concretes.Address;
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
    public DataResult<List<Address>> getAll() {
        return addressService.getAll();
    }

    @GetMapping("{id}")
    public DataResult<Address> getById(@PathVariable int id){
        return addressService.getById(id);
    }

    @GetMapping("/findByAddressExampleDTO")
    public DataResult<List<AddressDTO>> findByAddressExample(int id){
        return this.addressService.findByAddressExample(id);
    }

   /* @GetMapping("/customAddress")
    public List<Address> customAddress(int id){
        return addressService.customAddress(id);
    }*/

    @PostMapping("/add")
   public ResponseEntity<DataResult<AddAddressResponse>> addAddress(@RequestBody AddAddressRequest addAddressRequest){
        return new ResponseEntity<DataResult<AddAddressResponse>>(addressService.addAddress(addAddressRequest), HttpStatus.CREATED);
   }

}
