package com.etiya.ecommercedemopair5.business.concretes;

import com.etiya.ecommercedemopair5.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair5.business.constants.Messages;
import com.etiya.ecommercedemopair5.business.dtos.CategoryDTO;
import com.etiya.ecommercedemopair5.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommercedemopair5.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair5.entities.concretes.Category;
import com.etiya.ecommercedemopair5.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {

    private CategoryRepository categoryRepository;
    // private ModelMapper modelMapper; //implament ettik

    private MessageSource messageSource;
    private ModelMapperService modelMapperService;
    // SAYFALAMA
    // FİLTRELEME
    @Override
    public DataResult<List<Category>> getAll() {
       List<Category> response =this.categoryRepository.findAll();
        return new SuccessDataResult<List<Category>>(response,Messages.Category.getAllCategory);
    }
    @Override
    public DataResult<Category> getById(int id) {
        Category response = this.categoryRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Category>(response,Messages.Category.getByCategoryId);
    }


    // JPA Repository SAVE methodu, eklenen veriyi geri döner.
    @Override
    public DataResult<AddCategoryResponse> addCategory(AddCategoryRequest addCategoryRequest) {
        // MAPPING => AUTO MAPPER
        // Business Rules
        categoryCanNotExistWithSameName(addCategoryRequest.getName());
        Category category = modelMapperService.getMapper().map(addCategoryRequest,Category.class);

        //veritabanınında aynı isim bulunamaz
       //////// categoryCanNotExistWithSameName();
        // Validation
        Category savedCategory = categoryRepository.save(category);
        // MAPPING -> Category => AddCategoryResponse
        AddCategoryResponse response =
                modelMapperService.getMapper().map(savedCategory,AddCategoryResponse.class);

        return new SuccessDataResult<AddCategoryResponse>(response,Messages.Category.addCategory);
    }
    @Override
    public DataResult<List<CategoryDTO>> findByCategoryExample(int id) {
        List<CategoryDTO> response = categoryRepository.findByCategoryExample(id);
        return new SuccessDataResult<List<CategoryDTO>>(response);
    }
    private void categoryCanNotExistWithSameName(String name){

        boolean isExists = categoryRepository.existsCategoryByName(name);
        if(isExists) // Veritabanımda bu isimde bir kategori mevcut!!
                // add custom business exception
            throw new BusinessException(messageSource.getMessage
                    (Messages.Category.CategoryExistsWithSameName,null, LocaleContextHolder.getLocale())
            );
    }
}

/*

     Category category = new Category();

     //category.setName(addCategoryRequest.getName());
          //category.setType(addCategoryRequest.getType());


     private void categoryCanNotExistWithSameName(String name){
        //exception fırlat }*/