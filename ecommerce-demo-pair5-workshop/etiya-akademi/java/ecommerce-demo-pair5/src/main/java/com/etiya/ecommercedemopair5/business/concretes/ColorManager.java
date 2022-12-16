package com.etiya.ecommercedemopair5.business.concretes;

import com.etiya.ecommercedemopair5.business.abstracts.ColorService;
import com.etiya.ecommercedemopair5.business.constants.Messages;
import com.etiya.ecommercedemopair5.business.dtos.request.colors.AddColorsRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.colors.AddColorsResponse;
import com.etiya.ecommercedemopair5.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair5.entities.concretes.Color;
import com.etiya.ecommercedemopair5.repository.abstracts.ColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {
    private ColorRepository colorRepository;
    private ModelMapperService modelMapperService;
    private MessageSource messageSource;

    // SAYFALAMA
    // FİLTRELEME

    @Override
    public DataResult<List<Color>> getAll() {
        List<Color> response=this.colorRepository.findAll();
        return new SuccessDataResult<List<Color>>(response, Messages.Color.getAllColors);
    }

    @Override
    public DataResult<Color> getById(int id) {
        Color response = this.colorRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Color>(response,Messages.Color.getByColorId);
    }

    @Override
    public Page<Color> findAllWithPagination(Pageable pageable) {
        return colorRepository.findAll(pageable);
    }

    // JPA Repository SAVE methodu, eklenen veriyi geri döner.
    @Override
    public DataResult<AddColorsResponse> addColor(AddColorsRequest addColorRequest) {

        colorCanNotExistWithSameName(addColorRequest.getName());

        // MAPPING => AUTO MAPPER
        Color color =
                modelMapperService.forRequest().map(addColorRequest,Color.class);
        AddColorsResponse addColorsResponse =
                modelMapperService.forResponse().map(colorRepository.save(color),AddColorsResponse.class);
        return new SuccessDataResult<AddColorsResponse>(addColorsResponse,Messages.Color.addColor);
    }

    private void colorCanNotExistWithSameName(String name){

        boolean isExists = colorRepository.existsColorByName(name);
        if(isExists) // Veritabanımda bu isimde bir renk mevcut!!
            // add custom business exception
            throw new BusinessException(messageSource.getMessage
                    (Messages.Color.CheckIfExistsColorName,null, LocaleContextHolder.getLocale())
            );
    }

}
        /*Color color = new Color();
        color.setName(addColorRequest.getName());

        //
        // Business Rules
        // Validation
        Color savedColor = colorRepository.save(color);

        // MAPPING -> Category => AddCategoryResponse
        AddColorsResponse response =
                new AddColorsResponse(savedColor.getId(), savedColor.getName());
        //
        return response;*/