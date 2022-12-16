package com.etiya.ecommercedemopair5.business.concretes;

import com.etiya.ecommercedemopair5.business.abstracts.ColorSizeRelationService;
import com.etiya.ecommercedemopair5.business.constants.Messages;
import com.etiya.ecommercedemopair5.business.dtos.request.colorsizerelation.AddColorSizeRelationRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.colorsizerelation.AddColorSizeRelationResponse;
import com.etiya.ecommercedemopair5.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair5.entities.concretes.*;
import com.etiya.ecommercedemopair5.repository.abstracts.ColorRepository;
import com.etiya.ecommercedemopair5.repository.abstracts.ColorSizeRepository;
import com.etiya.ecommercedemopair5.repository.abstracts.SizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColorSizeRelationManager implements ColorSizeRelationService {

    private ColorSizeRepository colorSizeRepository;
    /*private SizeService sizeService;
    private ColorService colorService;*/
    private ColorRepository colorRepository;
    private MessageSource messageSource;
    private SizeRepository sizeRepository;

    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<ColorSizeRelation>> getAll() {
        List<ColorSizeRelation> response = this.colorSizeRepository.findAll();
        return new SuccessDataResult<List<ColorSizeRelation>>(response,Messages.ColorSizeRelation.getAllColorSize);
    }

    @Override
    public DataResult<ColorSizeRelation> getById(int id) {
        ColorSizeRelation response = this.colorSizeRepository.findById(id).orElseThrow();
        return new SuccessDataResult<ColorSizeRelation>(response,Messages.ColorSizeRelation.getByColorSizeId);
    }

    @Override
    public Page<ColorSizeRelation> findAllWithPagination(Pageable pageable) {
        return colorSizeRepository.findAll(pageable);
    }

    @Override
    public DataResult<AddColorSizeRelationResponse> addColorSizeRelation(AddColorSizeRelationRequest addColorSizeRelationRequest) {
        // MAPPING => AUTO MAPPER

        ColorSizeRelation colorSizeRelation =
                modelMapperService.forRequest().map(addColorSizeRelationRequest,ColorSizeRelation.class);
        AddColorSizeRelationResponse addColorSizeRelationResponse =
                modelMapperService.forResponse().map(colorSizeRepository.save(colorSizeRelation),AddColorSizeRelationResponse.class);
        return new SuccessDataResult<AddColorSizeRelationResponse>(addColorSizeRelationResponse,Messages.ColorSizeRelation.addColorSize);
    }

    public void checkIfExistsColorId(int id){
        boolean isExists = colorRepository.existsById(id);
        if (!isExists){
            throw new BusinessException(Messages.Color.runTimeExceptionColor);
        }
    }

    public void checkIfExistsSizeId(int id){
        boolean isExists = sizeRepository.existsById(id);
        if (!isExists){
            throw new BusinessException(Messages.Size.runTimeExceptionSize);
        }
    }

}
       /* ColorSizeRelation colorSizeRelation = new ColorSizeRelation();

        Color color = colorService.getById(addColorSizeRelationRequest.getColorId());
        colorSizeRelation.setColor(color);

        Size size = sizeService.getById(addColorSizeRelationRequest.getSizeId());
        colorSizeRelation.setSize(size);


        // Business Rules
        // Validation
        ColorSizeRelation savedColorSizeRelation = colorSizeRepository.save(colorSizeRelation);

        // MAPPING -> Category => AddCategoryResponse
        AddColorSizeRelationResponse response =
                new AddColorSizeRelationResponse(savedColorSizeRelation.getId(),
                        savedColorSizeRelation.getColor().getId(),
                        savedColorSizeRelation.getSize().getId());
        return response;*/

