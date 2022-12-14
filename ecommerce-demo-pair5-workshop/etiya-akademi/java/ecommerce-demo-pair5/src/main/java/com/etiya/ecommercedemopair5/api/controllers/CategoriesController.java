package com.etiya.ecommercedemopair5.api.controllers;

import com.etiya.ecommercedemopair5.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair5.business.dtos.CategoryDTO;
import com.etiya.ecommercedemopair5.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.entities.concretes.Category;
import com.etiya.ecommercedemopair5.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public DataResult<List<Category>> getAll(){
        return categoryService.getAll();
    }
    // client
    // server
    // DTO => Data Transfer Object

    @GetMapping("/findByCategoryExampleDTO")
    public DataResult<List<CategoryDTO>> findByCategoryExample(int id){
        return this.categoryService.findByCategoryExample(id);
    }



    // AddCategoryRequest => name,type
    // ResponseEntity
    @PostMapping("/add")
    public ResponseEntity<DataResult<AddCategoryResponse>> addCategory(@RequestBody @Valid AddCategoryRequest addCategoryRequest){
        return new ResponseEntity<DataResult<AddCategoryResponse>>(categoryService.addCategory(addCategoryRequest), HttpStatus.CREATED);
    }

    @GetMapping("getWithPagination")
    // RequestParam => page, pageSize
    public Page<Category> getWithPagination(@RequestParam("page")int page, @RequestParam("pageSize")int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);

            return categoryService.findAllWithPagination(pageable);
    }
}
