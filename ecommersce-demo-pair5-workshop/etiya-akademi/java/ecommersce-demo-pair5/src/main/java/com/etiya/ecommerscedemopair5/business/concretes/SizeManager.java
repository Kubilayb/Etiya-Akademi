package com.etiya.ecommerscedemopair5.business.concretes;

import com.etiya.ecommerscedemopair5.business.abstracts.SizeService;
import com.etiya.ecommerscedemopair5.business.dtos.request.size.AddSizeRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.size.AddSizeResponse;
import com.etiya.ecommerscedemopair5.core.util.mapping.ModelMapperService;
import com.etiya.ecommerscedemopair5.entities.concretes.Size;
import com.etiya.ecommerscedemopair5.repository.abstracts.ProductRepository;
import com.etiya.ecommerscedemopair5.repository.abstracts.SizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SizeManager implements SizeService {

    private ModelMapperService modelMapperService;


    @Override
    public List<Size> getAll() {
        return sizeRepository.findAll();
    }

    @Override
    public Size getById(int id) {
        return sizeRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Size> getAllByStockGreaterThan(int stock) {
        return sizeRepository.findAllSizesByStockGreaterThanOrderByStockDesc(stock);
    }

    @Override
    public Size getByName(String name) {
        return sizeRepository.findByName(name);
    }

    private SizeRepository sizeRepository;
    private final ProductRepository productRepository;

    @Override
    public AddSizeResponse addSize(AddSizeRequest addSizeRequest) {

        Size size =
                modelMapperService.getMapper().map(addSizeRequest,Size.class);
        AddSizeResponse addSizeResponse =
                modelMapperService.getMapper().map(sizeRepository.save(size),AddSizeResponse.class);
        return addSizeResponse;
    }
}