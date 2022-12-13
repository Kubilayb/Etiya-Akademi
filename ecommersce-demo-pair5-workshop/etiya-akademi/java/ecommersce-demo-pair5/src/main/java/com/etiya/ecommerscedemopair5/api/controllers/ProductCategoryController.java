package com.etiya.ecommerscedemopair5.api.controllers;

import com.etiya.ecommerscedemopair5.business.abstracts.ProductCategoryService;
import com.etiya.ecommerscedemopair5.business.dtos.request.productcategory.AddProductCategoryRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.productcategory.AddProductCategoryResponse;
import com.etiya.ecommerscedemopair5.core.util.results.DataResult;
import com.etiya.ecommerscedemopair5.entities.concretes.ProductCategory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/productCategory")
public class ProductCategoryController {

    private ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService){
        this.productCategoryService=productCategoryService;
    }
    @GetMapping("/getAll")
    public DataResult<List<ProductCategory>> getAll() {
        return productCategoryService.getAll();
    }

    @GetMapping("{id}")
    public DataResult<ProductCategory> getById(@PathVariable int id){
        return productCategoryService.getById(id);
    }

    //@GetMapping("/getByProductCategory")
   // public List<ProductCategory> getByAllProductCategory(@RequestParam("id giriniz") int id);

    @PostMapping("/add")
    public ResponseEntity<DataResult<AddProductCategoryResponse>>addProductCategory
            (@RequestBody AddProductCategoryRequest addProductCategoryRequest){
        return new ResponseEntity<DataResult<AddProductCategoryResponse>>(productCategoryService.addProductCategory(addProductCategoryRequest), HttpStatus.CREATED);
    }
}
