package com.etiya.ecommerscedemopair5.api.controllers;

import com.etiya.ecommerscedemopair5.business.abstracts.CategoryService;
import com.etiya.ecommerscedemopair5.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommerscedemopair5.entities.concretes.Category;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoriesController {
    private CategoryService categoryService;

    // GetCategoryResponse => id,name
    @GetMapping("/getAll")
    public List<Category> getAll(){
        return categoryService.getAll();
    }
    // client
    // server
    // DTO => Data Transfer Object
    // AddCategoryRequest => name,type
    // ResponseEntity
    @PostMapping("/add")
    public ResponseEntity<AddCategoryResponse> addCategory(@RequestBody @Valid AddCategoryRequest addCategoryRequest){
        return new ResponseEntity<AddCategoryResponse>(categoryService.addCategory(addCategoryRequest), HttpStatus.CREATED);
    }
}
