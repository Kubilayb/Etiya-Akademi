package com.etiya.ecommercedemopair5.business.concretes;

import com.etiya.ecommercedemopair5.business.abstracts.SizeService;
import com.etiya.ecommercedemopair5.business.constants.Messages;
import com.etiya.ecommercedemopair5.business.dtos.request.size.AddSizeRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.size.AddSizeResponse;
import com.etiya.ecommercedemopair5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair5.entities.concretes.Size;
import com.etiya.ecommercedemopair5.repository.abstracts.ProductRepository;
import com.etiya.ecommercedemopair5.repository.abstracts.SizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SizeManager implements SizeService {

    private ModelMapperService modelMapperService;


    @Override
    public DataResult<List<Size>> getAll() {
        List<Size> response = this.sizeRepository.findAll();
        return new SuccessDataResult<List<Size>>(response, Messages.Size.getAllSizes);
    }

    @Override
    public DataResult<Size> getById(int id) {
        Size response = this.sizeRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Size>(response,Messages.Size.getBySizeId);
    }

    @Override
    public DataResult<List<Size>> getAllByStockGreaterThan(int stock) {
        List<Size> response= this.sizeRepository.findAllSizesByStockGreaterThanOrderByStockDesc(stock);
        return new SuccessDataResult<List<Size>>(response,Messages.Size.getBySizeStock);
    }

    @Override
    public DataResult<Size> getByName(String name) {
        Size response = this.sizeRepository.findByName(name);
        return new SuccessDataResult<Size>(response,Messages.Size.getBySizeName);
    }

    private SizeRepository sizeRepository;
    private final ProductRepository productRepository;

    @Override
    public DataResult<AddSizeResponse> addSize(AddSizeRequest addSizeRequest) {

        Size size =
                modelMapperService.forRequest().map(addSizeRequest,Size.class);
        AddSizeResponse addSizeResponse =
                modelMapperService.forResponse().map(sizeRepository.save(size),AddSizeResponse.class);
        return new SuccessDataResult<AddSizeResponse>(addSizeResponse,Messages.Size.addSize);
    }
}