package com.etiya.ecommerscedemopair5.business.concretes;

import com.etiya.ecommerscedemopair5.business.abstracts.CategoryService;
import com.etiya.ecommerscedemopair5.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommerscedemopair5.core.util.mapping.ModelMapperService;
import com.etiya.ecommerscedemopair5.entities.concretes.Category;
import com.etiya.ecommerscedemopair5.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {

    private CategoryRepository categoryRepository;
  //  private ModelMapper modelMapper; //implament ettik

    private ModelMapperService modelMapperService;

    @Override
    public List<Category> getAll() {
        // SAYFALAMA
        // FİLTRELEME
        return categoryRepository.findAll();
    }
    @Override
    public Category getById(int id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    // JPA Repository SAVE methodu, eklenen veriyi geri döner.
    @Override
    public AddCategoryResponse addCategory(AddCategoryRequest addCategoryRequest) {
        // MAPPING => AUTO MAPPER
          //  Category category = new Category();
        categoryCanNotExistWithSameName(addCategoryRequest.getName());

        //category.setName(addCategoryRequest.getName());
          //category.setType(addCategoryRequest.getType());
        Category category = modelMapperService.getMapper().map(addCategoryRequest,Category.class);

        //
        // Business Rules
        //veritabanınında aynı isim bulunamaz
       //////// categoryCanNotExistWithSameName();

        // Validation
        Category savedCategory = categoryRepository.save(category);

        // MAPPING -> Category => AddCategoryResponse
        AddCategoryResponse response = modelMapperService.getMapper().map(savedCategory,AddCategoryResponse.class);

        //
        return response;
    }

    private void categoryCanNotExistWithSameName(String name){

        boolean isExists = categoryRepository.existsCategoryByName(name);
        if(isExists) // Veritabanımda bu isimde bir kategori mevcut!!

            throw new RuntimeException("Bu isimle bir kategori zaten mevcut!");
    }

   // private void categoryCanNotExistWithSameName(String name){
        //exception fırlat }
}