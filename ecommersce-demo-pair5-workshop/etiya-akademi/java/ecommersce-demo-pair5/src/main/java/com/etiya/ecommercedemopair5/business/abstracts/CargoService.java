package com.etiya.ecommercedemopair5.business.abstracts;

import com.etiya.ecommercedemopair5.business.dtos.request.cargo.AddCargoRequest;
import com.etiya.ecommercedemopair5.business.dtos.response.cargo.AddCargoResponse;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.entities.concretes.Cargo;

import java.util.List;

public interface CargoService {

        DataResult<List<Cargo>> getAll();
       // List<Cargo> getAllByPrice(int price); ////????
        DataResult<Cargo> getById(int id);
        DataResult<List<Cargo>> getAllByPriceValueGreaterThan(int price);
        DataResult<Cargo> getByName(String name);
        DataResult<AddCargoResponse> addCargo(AddCargoRequest addCargoRequest);

}

