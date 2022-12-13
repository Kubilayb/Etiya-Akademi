package com.etiya.ecommerscedemopair5.business.concretes;


import com.etiya.ecommerscedemopair5.business.abstracts.CityService;
import com.etiya.ecommerscedemopair5.business.constants.Messages;
import com.etiya.ecommerscedemopair5.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommerscedemopair5.business.dtos.response.size.AddSizeResponse;
import com.etiya.ecommerscedemopair5.core.util.mapping.ModelMapperService;
import com.etiya.ecommerscedemopair5.core.util.results.DataResult;
import com.etiya.ecommerscedemopair5.core.util.results.SuccessDataResult;
import com.etiya.ecommerscedemopair5.entities.concretes.City;
import com.etiya.ecommerscedemopair5.entities.concretes.Size;
import com.etiya.ecommerscedemopair5.repository.abstracts.CityRepository;
import com.etiya.ecommerscedemopair5.repository.abstracts.SizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.rmi.MarshalException;
import java.util.List;

@Service
@AllArgsConstructor
public class CityManager implements CityService {
    private CityRepository cityRepository;

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
    public DataResult<AddCityResponse> addCity(AddCityRequest addCityRequest) {
        // MAPPING => AUTO MAPPER
        City city =
                modelMapperService.forRequest().map(addCityRequest,City.class);
        AddCityResponse addCityResponse =
                modelMapperService.forResponse().map(cityRepository.save(city),AddCityResponse.class);
        return new SuccessDataResult<AddCityResponse>(addCityResponse, Messages.City.addCity);
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