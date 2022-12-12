package com.etiya.ecommerscedemopair5.api.controllers;


import com.etiya.ecommerscedemopair5.business.abstracts.ProductService;
import com.etiya.ecommerscedemopair5.business.dtos.ProductDTO;
import com.etiya.ecommerscedemopair5.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommerscedemopair5.core.util.results.DataResult;
import com.etiya.ecommerscedemopair5.core.util.results.SuccessDataResult;
import com.etiya.ecommerscedemopair5.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductsController {
    // DI
    @Autowired
    private ProductService productService;


    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Product>> getAll(){
        return this.productService.getAll();
    }

    @GetMapping("/getById")
    public Product getById(@RequestParam("id") int id){
        return productService.getById(id);
    }
    @GetMapping("{id}")
    public Product getByIdPath(@PathVariable int id){
        return productService.getById(id);
    }

    @GetMapping("/getByStockGreaterThan")
    public List<Product> getAllByStock(@RequestParam("stock") double stock){
        return productService.getAllByStockGreaterThan(stock);
    }

    @GetMapping("/getByName")
    public Product getByName(@RequestParam("name") String name){
        return productService.getByName(name);
    }

 /*   @GetMapping("/getTopSellingProductById")
    public List<Product> findTopSellingProductById(int id, int addressid){
        return productService.findTopSellingProductById(id,addressid);
    }
*/
    @PostMapping("/add")
    public ResponseEntity<AddProductResponse> addProduct(@RequestBody @Valid AddProductRequest addProductRequest){
        return new ResponseEntity<AddProductResponse>(productService.addProduct(addProductRequest), HttpStatus.CREATED);
    }

    @GetMapping("/findByExampleDTO")
    public DataResult<List<ProductDTO>> findByExample(int id){
        return this.productService.findByExample(id);
    }

}

