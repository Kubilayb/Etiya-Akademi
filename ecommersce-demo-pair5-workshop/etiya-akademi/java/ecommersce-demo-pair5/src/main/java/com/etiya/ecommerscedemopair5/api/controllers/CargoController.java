package com.etiya.ecommerscedemopair5.api.controllers;


import com.etiya.ecommerscedemopair5.business.abstracts.CargoService;
import com.etiya.ecommerscedemopair5.business.abstracts.ProductService;
import com.etiya.ecommerscedemopair5.entities.concretes.Cargo;
import com.etiya.ecommerscedemopair5.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/cargo")
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
    public List<Cargo> getAllByPrice(@RequestParam("price") int price){
        return cargoService.getAllByPriceValueGreaterThan(price);
        }
    @GetMapping("/getByName")
    public Cargo getByName(@RequestParam("Cargo Comp Name") String name){
        return cargoService.getByName(name);
    }

}
