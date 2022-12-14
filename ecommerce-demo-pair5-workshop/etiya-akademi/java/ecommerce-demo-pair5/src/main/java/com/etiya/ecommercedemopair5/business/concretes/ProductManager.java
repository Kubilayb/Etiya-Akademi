package com.etiya.ecommercedemopair5.business.concretes;


import com.etiya.ecommercedemopair5.business.abstracts.ProductService;
import com.etiya.ecommercedemopair5.business.constants.Messages;
import com.etiya.ecommercedemopair5.business.dtos.ProductDTO;
import com.etiya.ecommercedemopair5.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemopair5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair5.entities.concretes.Product;
import com.etiya.ecommercedemopair5.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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
        List<Product> response= this.productRepository.findAll();
        return new SuccessDataResult<List<Product>>(response,Messages.Product.getAllProducts);
    }

    @Override
    public DataResult<Product> getById(int id) {
        Product response = this.productRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Product>(response,Messages.Product.getByProductId);
    }
    @Override
    public DataResult<List<Product>> getAllByStockGreaterThan(double stock) {
        List<Product> response = this.productRepository.findAllProductsByStockGreaterThanOrderByStockDesc(stock);
        return new SuccessDataResult<List<Product>>(response,Messages.Product.getByProductStock);
    }
    @Override
    public DataResult<Product> getByName(String name) {
        Product response = this.productRepository.findByName(name);
        return new SuccessDataResult<Product>(response,Messages.Product.getByProductName);
    }

    @Override
    public DataResult<List<ProductDTO>> findByExample(int id) {
        List<ProductDTO> response = productRepository.findByExample(id);
        return new SuccessDataResult<List<ProductDTO>>(response); // mesaj yazınca gelmiyor

        //ProductDTO response = productRepository.findByExample(id);
        // return new SuccessDataResult<ProductDTO>(response,"Bu ürün listelendi"); (this.productRepository.findByExample(id)
    }

    @Override
    public Page<Product> findAllWithPagination(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Slice<Product> findAllWithSlice(Pageable pageable) {
        return productRepository.getAllWithSlice(pageable);
    }



    /*  @Override
      public List<Product> findTopSellingProductById(int id, int addressid) {
          return productRepository.findTopSellingProductById(id,addressid);
      }
     */


    @Override
    public DataResult<AddProductResponse> addProduct(AddProductRequest addProductRequest) {
        // MAPPING => AUTO MAPPER

        Product product =
                modelMapperService.forRequest().map(addProductRequest,Product.class);
        AddProductResponse addProductResponse =
                modelMapperService.forResponse().map(productRepository.save(product),AddProductResponse.class);
        return new SuccessDataResult<AddProductResponse>(addProductResponse,Messages.Product.addProduct);
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
