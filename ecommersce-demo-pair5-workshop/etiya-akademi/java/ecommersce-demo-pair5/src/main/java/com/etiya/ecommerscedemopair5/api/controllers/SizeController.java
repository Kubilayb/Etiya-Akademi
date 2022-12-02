package com.etiya.ecommerscedemopair5.api.controllers;


import com.etiya.ecommerscedemopair5.business.abstracts.ProductService;
import com.etiya.ecommerscedemopair5.business.abstracts.SizeService;
import com.etiya.ecommerscedemopair5.entities.concretes.Product;
import com.etiya.ecommerscedemopair5.entities.concretes.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/size")
public class SizeController {

    @Autowired
    private SizeService sizeService;

    public SizeController(SizeService sizeService) {
        this.sizeService = sizeService;
    }

    @GetMapping("/getAll")
    public List<Size> getAll(){
        return sizeService.getAll();
    }

    @GetMapping("/getById")
    public Size getById(@RequestParam("id") int id){
        return sizeService.getById(id);
    }
    @GetMapping("{id}")
    public Size getByIdPath(@PathVariable int id){
        return sizeService.getById(id);
    }

    @GetMapping("/getByStockGreaterThan")
    public List<Size> getAllByStock(@RequestParam("stock") int stock){
        return sizeService.getAllByStockGreaterThan(stock);
    }

    @GetMapping("/getByName")
    public Size getByName(@RequestParam("name") String name){
        return sizeService.getByName(name);
    }
}
