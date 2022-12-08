package com.etiya.ecommerscedemopair5.business.abstracts;

import com.etiya.ecommerscedemopair5.business.dtos.request.cargo.AddCargoRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.cargo.AddCargoResponse;
import com.etiya.ecommerscedemopair5.entities.concretes.Cargo;

import java.util.List;

public interface CargoService {

        List<Cargo> getAll();
       // List<Cargo> getAllByPrice(int price); ////????
        Cargo getById(int id);
        List<Cargo> getAllByPriceValueGreaterThan(int price);
        Cargo getByName(String name);

        AddCargoResponse addCargo(AddCargoRequest addCargoRequest);
}

