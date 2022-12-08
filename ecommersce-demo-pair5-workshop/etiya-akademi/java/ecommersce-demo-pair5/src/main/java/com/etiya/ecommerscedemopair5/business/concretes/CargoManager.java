package com.etiya.ecommerscedemopair5.business.concretes;

import com.etiya.ecommerscedemopair5.business.abstracts.CargoService;
import com.etiya.ecommerscedemopair5.business.dtos.request.cargo.AddCargoRequest;

import com.etiya.ecommerscedemopair5.business.dtos.response.cargo.AddCargoResponse;
import com.etiya.ecommerscedemopair5.business.dtos.response.size.AddSizeResponse;
import com.etiya.ecommerscedemopair5.core.util.mapping.ModelMapperService;
import com.etiya.ecommerscedemopair5.entities.concretes.Cargo;
import com.etiya.ecommerscedemopair5.entities.concretes.Size;
import com.etiya.ecommerscedemopair5.repository.abstracts.CargoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor

public class CargoManager implements CargoService {

    private CargoRepository cargoRepository;

    private ModelMapperService modelMapperService;

    @Override
    public List<Cargo> getAll() {
        return cargoRepository.findAll();
    }

    @Override
    public Cargo getById(int id) {
        return cargoRepository.findById(id).orElseThrow();
    }
    @Override
    public List<Cargo> getAllByPriceValueGreaterThan(int price) {
        return cargoRepository.findAllCargosByPriceGreaterThanOrderByPriceDesc(price);
    }

   /* @Override
    public List<Cargo> getAllByPrice(int price) {
        return cargoRepository.findAllByPrice(price);
    }
*/
    @Override
    public Cargo getByName(String name) {
        return cargoRepository.findByName(name);
    }



    @Override
    public AddCargoResponse addCargo(AddCargoRequest addCargoRequest) {
        // MAPPING => AUTO MAPPER
        Cargo cargo =
                modelMapperService.getMapper().map(addCargoRequest,Cargo.class);
        AddCargoResponse addCargoResponse =
                modelMapperService.getMapper().map(cargoRepository.save(cargo),AddCargoResponse.class);
        return addCargoResponse;
    }
}
       /* Cargo cargo = new Cargo();
        cargo.setName(addCargoRequest.getName());
        cargo.setPrice(addCargoRequest.getPrice());

        Cargo savedCargo = cargoRepository.save(cargo);
        // MAPPING -> Cargo => AddCargoResponse
        AddCargoResponse response =
                new AddCargoResponse(savedCargo.getId(), savedCargo.getName(), savedCargo.getPrice());
        return response;*/