package com.etiya.ecommerscedemopair5.api.controllers;


import com.etiya.ecommerscedemopair5.business.abstracts.ProductService;
import com.etiya.ecommerscedemopair5.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class ProductsController {

    private ProductService productService;
    /*
    public ProductsController(ProductService productService) {
        this.productService =productService;
    }
    */
    @GetMapping("/getAll")
    public List<Product> getAll() {return productService.getAll();}

    @GetMapping("{id}")
    public Product getById(@PathVariable int id ) {return productService.getById(id);}


    @GetMapping("/getById")
    public Product getByIdParam(@RequestParam int id ) {return productService.getById(id);}


}
