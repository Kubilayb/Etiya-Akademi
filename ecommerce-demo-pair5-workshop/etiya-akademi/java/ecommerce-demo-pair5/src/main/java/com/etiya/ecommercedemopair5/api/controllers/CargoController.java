package com.etiya.ecommercedemopair5.api.controllers;


import com.etiya.ecommercedemopair5.business.abstracts.CargoService;
import com.etiya.ecommercedemopair5.business.dtos.request.cargo.AddCargoRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.cargo.AddCargoResponse;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.entities.concretes.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;


    public CargoController(CargoService cargoService ) {
        this.cargoService = cargoService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Cargo>> getAll(){
        return cargoService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Cargo> getById(@RequestParam("id") int id){
        return cargoService.getById(id);
    }

    @GetMapping("{id}")
    public DataResult<Cargo> getByIdPath(@PathVariable int id){
        return cargoService.getById(id);
    }

    @GetMapping("/getByPriceValueGreaterThan")
    public DataResult<List<Cargo>> getAllByPrice(@RequestParam("price") int price){ ///?????
        return cargoService.getAllByPriceValueGreaterThan(price);
        }
    @GetMapping("/getByName")
    public DataResult<Cargo> getByName(@RequestParam("Cargo Comp Name") String name){
        return cargoService.getByName(name);
    }


    // client
    // server
    // DTO => Data Transfer Object
    // AddCategoryRequest => name,type
    // ResponseEntity

    @PostMapping("/add")
    public ResponseEntity<DataResult<AddCargoResponse>> addCargo(AddCargoRequest addCargoRequest){
        return new ResponseEntity<DataResult<AddCargoResponse>>(cargoService.addCargo(addCargoRequest),HttpStatus.CREATED);

    }

    @GetMapping("getWithPagination")
    // RequestParam => page, pageSize
    public Page<Cargo> getWithPagination(@RequestParam("page")int page, @RequestParam("pageSize")int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);

        return cargoService.findAllWithPagination(pageable);
    }

}
