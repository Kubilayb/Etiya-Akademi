package com.etiya.ecommerscedemopair5.api.controllers;


import com.etiya.ecommerscedemopair5.business.abstracts.CargoService;
import com.etiya.ecommerscedemopair5.business.dtos.request.cargo.AddCargoRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.cargo.AddCargoResponse;
import com.etiya.ecommerscedemopair5.entities.concretes.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Cargo> getAll(){
        return cargoService.getAll();
    }

    @GetMapping("/getById")
    public Cargo getById(@RequestParam("id") int id){
        return cargoService.getById(id);
    }

    @GetMapping("{id}")
    public Cargo getByIdPath(@PathVariable int id){
        return cargoService.getById(id);
    }

    @GetMapping("/getByPriceValueGreaterThan")
    public List<Cargo> getAllByPrice(@RequestParam("price") int price){ ///?????
        return cargoService.getAllByPriceValueGreaterThan(price);
        }
    @GetMapping("/getByName")
    public Cargo getByName(@RequestParam("Cargo Comp Name") String name){
        return cargoService.getByName(name);
    }


    // client
    // server
    // DTO => Data Transfer Object
    // AddCategoryRequest => name,type
    // ResponseEntity

    @PostMapping("/add")
    public ResponseEntity<AddCargoResponse> addCargo(@RequestBody AddCargoRequest addCargoRequest){
        return new ResponseEntity<AddCargoResponse>
                (cargoService.addCargo(addCargoRequest), HttpStatus.CREATED);
    }

}
