package com.etiya.ecommercedemopair5.api.controllers;


import com.etiya.ecommercedemopair5.business.abstracts.ProductService;
import com.etiya.ecommercedemopair5.business.dtos.ProductDTO;
import com.etiya.ecommercedemopair5.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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
    public DataResult<Product> getById(@RequestParam("id") int id){
        return productService.getById(id);
    }
    @GetMapping("{id}")
    public DataResult<Product>  getByIdPath(@PathVariable int id){
        return productService.getById(id);
    }

    @GetMapping("/getByStockGreaterThan")
    public DataResult<List<Product>> getAllByStock(@RequestParam("stock") double stock){
        return productService.getAllByStockGreaterThan(stock);
    }

    @GetMapping("/getByName")
    public DataResult<Product> getByName(@RequestParam("name") String name){
        return productService.getByName(name);
    }

 /*   @GetMapping("/getTopSellingProductById")
    public List<Product> findTopSellingProductById(int id, int addressid){
        return productService.findTopSellingProductById(id,addressid);
    }
*/
    @PostMapping("/add")
    public ResponseEntity<DataResult<AddProductResponse>> addProduct(@RequestBody @Valid AddProductRequest addProductRequest){
        return new ResponseEntity<DataResult<AddProductResponse>>(productService.addProduct(addProductRequest), HttpStatus.CREATED);
    }

    @GetMapping("/findByExampleDTO")
    public DataResult<List<ProductDTO>> findByExample(int id){
        return this.productService.findByExample(id);
    }


    @GetMapping("getWithPagination")
    // RequestParam => page, pageSize
    public Page<Product> getWithPagination(@RequestParam("page")int page,@RequestParam("pageSize")int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);

        return productService.findAllWithPagination(pageable);
    }
    public Slice<Product> getWithSlice(@RequestParam("page")int page, @RequestParam("pageSize")int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);

        return productService.findAllWithSlice(pageable);
    }

    /*
    public Page<ProductDTO>
            getAllProductDTO(@RequestParam("page")int page, @RequestParam("pageSize")int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);

        return productService.findAllWithPaginationDto(pageable);
    }*/


}

