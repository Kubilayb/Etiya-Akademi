package com.etiya.ecommercedemopair5.business.concretes;


import com.etiya.ecommercedemopair5.business.abstracts.CityService;
import com.etiya.ecommercedemopair5.business.constants.Messages;
import com.etiya.ecommercedemopair5.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommercedemopair5.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair5.entities.concretes.City;
import com.etiya.ecommercedemopair5.repository.abstracts.CityRepository;
import com.etiya.ecommercedemopair5.repository.abstracts.SizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityManager implements CityService {
    private CityRepository cityRepository;
    private MessageSource messageSource;

    private ModelMapperService modelMapperService;
    private final SizeRepository sizeRepository;

    @Override
    public DataResult<List<City>> getAll() {
        List<City> response = this.cityRepository.findAll();
        return new SuccessDataResult<List<City>>(response,Messages.City.getAllCity);
    }

    @Override
    public DataResult<City> getById(int id) {
        City response = this.cityRepository.findById(id).orElseThrow();
        return new SuccessDataResult<City>(response,Messages.City.getByCityId);
    }


    @Override
    public DataResult<City> getByName(String name) {
        City response = this.cityRepository.findByName(name);
        return new SuccessDataResult<City>(response,Messages.City.getByCityName);
    }

    @Override
    public Page<City> findAllWithPagination(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Override
    public DataResult<AddCityResponse> addCity(AddCityRequest addCityRequest) {

        checkIfExistsCityName(addCityRequest.getName());

        // MAPPING => AUTO MAPPER
        City city =
                modelMapperService.forRequest().map(addCityRequest,City.class);
        AddCityResponse addCityResponse =
                modelMapperService.forResponse().map(cityRepository.save(city),AddCityResponse.class);
        return new SuccessDataResult<AddCityResponse>(addCityResponse, Messages.City.addCity);
    }

    private void checkIfExistsCityName(String name){
        boolean isExists=cityRepository.existsCityByName(name);
        if (isExists){
            throw new BusinessException(messageSource.getMessage
                    (Messages.City.checkIfExistsCityName,null, LocaleContextHolder.getLocale()));
        }
    }




}




/* City city = new City();
        city.setName(addCityRequest.getName());

        //
        // Business Rules
        // Validation
        City savedCargo = cityRepository.save(city);

        // MAPPING -> Category => AddCategoryResponse
        AddCityResponse response =
                new AddCityResponse(savedCargo.getId(), savedCargo.getName());
        //
        return response;*/