package com.etiya.ecommercedemopair5.business.abstracts;

import com.etiya.ecommercedemopair5.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.entities.concretes.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CityService {
    DataResult<List<City>> getAll();
    DataResult<City> getById(int id);
    DataResult<City> getByName(String name);
    Page<City> findAllWithPagination(Pageable pageable);

    DataResult<AddCityResponse> addCity(AddCityRequest addCityRequest);
}
