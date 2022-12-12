package com.etiya.ecommerscedemopair5.business.concretes;


import com.etiya.ecommerscedemopair5.business.abstracts.ProductService;
import com.etiya.ecommerscedemopair5.business.dtos.ProductDTO;
import com.etiya.ecommerscedemopair5.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommerscedemopair5.core.util.mapping.ModelMapperService;
import com.etiya.ecommerscedemopair5.core.util.results.DataResult;
import com.etiya.ecommerscedemopair5.core.util.results.SuccessDataResult;
import com.etiya.ecommerscedemopair5.entities.concretes.Product;
import com.etiya.ecommerscedemopair5.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private ProductRepository productRepository;

   // private ModelMapper modelMapper;
    private ModelMapperService modelMapperService;

    // colorsizerelation private ile çağırcaz

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(productRepository.findAll(),"Data Listelendi");
    }

    @Override
    public Product getById(int id) {
        return productRepository.findById(id).orElseThrow();
    }
    @Override
    public List<Product> getAllByStockGreaterThan(double stock) {
        return productRepository.findAllProductsByStockGreaterThanOrderByStockDesc(stock);
    }
    @Override
    public Product getByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public DataResult<List<ProductDTO>> findByExample(int id) {
        List<ProductDTO> response = productRepository.findByExample(id);
        return new SuccessDataResult<List<ProductDTO>>(response); // mesaj yazınca gelmiyor

        //ProductDTO response = productRepository.findByExample(id);
        // return new SuccessDataResult<ProductDTO>(response,"Bu ürün listelendi"); (this.productRepository.findByExample(id)
    }

    /*  @Override
      public List<Product> findTopSellingProductById(int id, int addressid) {
          return productRepository.findTopSellingProductById(id,addressid);
      }
  */
    @Override
    public AddProductResponse addProduct(AddProductRequest addProductRequest) {
        // MAPPING => AUTO MAPPER

        Product product =
                modelMapperService.forRequest().map(addProductRequest,Product.class);
        AddProductResponse addProductResponse =
                modelMapperService.forResponse().map(productRepository.save(product),AddProductResponse.class);
        return addProductResponse;
    }
}
        /* Product product = new Product();

        product.setName(addProductRequest.getName());
        product.setUnitprice(addProductRequest.getUnitprice());
        product.setStock(addProductRequest.getStock());


        // Business Rules
        // Validation
        Product savedProduct = productRepository.save(product);

        // MAPPING -> Product => AddProductResponse

        AddProductResponse response =
                new AddProductResponse(savedProduct.getId(), savedProduct.getName(), savedProduct.getUnitprice(),
                        savedProduct.getStock(),savedProduct.getColorSizeRelation().getId());
        return response;
              */
