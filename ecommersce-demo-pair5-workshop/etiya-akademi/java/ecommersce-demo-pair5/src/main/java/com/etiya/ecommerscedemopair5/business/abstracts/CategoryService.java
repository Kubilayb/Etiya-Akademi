package com.etiya.ecommerscedemopair5.business.abstracts;

import com.etiya.ecommerscedemopair5.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommerscedemopair5.entities.concretes.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category getById(int id);
    AddCategoryResponse addCategory(AddCategoryRequest addCategoryRequest);
}