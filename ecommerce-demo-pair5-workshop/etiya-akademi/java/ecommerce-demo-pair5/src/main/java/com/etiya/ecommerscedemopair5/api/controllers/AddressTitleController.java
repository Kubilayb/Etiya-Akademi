package com.etiya.ecommerscedemopair5.api.controllers;

import com.etiya.ecommerscedemopair5.business.abstracts.AddressTitleService;
import com.etiya.ecommerscedemopair5.business.dtos.request.addresstitle.AddAddressTittleRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.addresstitle.AddAddressTitleResponse;
import com.etiya.ecommerscedemopair5.core.util.results.DataResult;
import com.etiya.ecommerscedemopair5.entities.concretes.AddressTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/addressTitle")
public class AddressTitleController {
    // DI
    @Autowired
    private AddressTitleService addressTitleService;

    public AddressTitleController(AddressTitleService addressTitleService) {
        this.addressTitleService = addressTitleService;
    }

    @GetMapping("/getAll")
    public DataResult<List<AddressTitle>> getAll() {
        return addressTitleService.getAll();}

    @GetMapping("/getById")
    public DataResult<AddressTitle> getById(@RequestParam("id") int id) {
        return addressTitleService.getById(id);
    }

    @GetMapping("{id}")
    public DataResult<AddressTitle> getByIdPath(@PathVariable int id) {
        return addressTitleService.getById(id);
    }


    @GetMapping("/getByName")
    public DataResult<AddressTitle> getByName(@RequestParam("name") String name) {
        return addressTitleService.getByName(name);
    }

    // client
    // server
    // DTO => Data Transfer Object
    // AddCategoryRequest => name,type
    // ResponseEntity
    @PostMapping("/add")
    public ResponseEntity<DataResult<AddAddressTitleResponse>> addAddressTitle(@RequestBody AddAddressTittleRequest addAddressTitleRequest) {
        return new ResponseEntity<DataResult<AddAddressTitleResponse>>(addressTitleService.addAddressTitle(addAddressTitleRequest), HttpStatus.CREATED);
    }
}