package com.etiya.ecommerscedemopair5.business.abstracts;

import com.etiya.ecommerscedemopair5.business.dtos.CategoryDTO;
import com.etiya.ecommerscedemopair5.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommerscedemopair5.core.util.results.DataResult;
import com.etiya.ecommerscedemopair5.entities.concretes.Category;

import java.util.List;

public interface CategoryService {
    DataResult<List<Category>> getAll();
    DataResult<Category> getById(int id);
    DataResult<AddCategoryResponse> addCategory(AddCategoryRequest addCategoryRequest);

    DataResult<List<CategoryDTO>> findByCategoryExample(int id);
}