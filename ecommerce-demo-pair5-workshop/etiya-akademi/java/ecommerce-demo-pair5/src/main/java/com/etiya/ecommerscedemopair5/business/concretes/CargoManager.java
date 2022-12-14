package com.etiya.ecommerscedemopair5.business.concretes;

import com.etiya.ecommerscedemopair5.business.abstracts.CargoService;
import com.etiya.ecommerscedemopair5.business.constants.Messages;
import com.etiya.ecommerscedemopair5.business.dtos.request.cargo.AddCargoRequest;

import com.etiya.ecommerscedemopair5.business.dtos.response.cargo.AddCargoResponse;
import com.etiya.ecommerscedemopair5.core.util.mapping.ModelMapperService;
import com.etiya.ecommerscedemopair5.core.util.results.DataResult;
import com.etiya.ecommerscedemopair5.core.util.results.SuccessDataResult;
import com.etiya.ecommerscedemopair5.entities.concretes.Cargo;
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
    public DataResult<List<Cargo>> getAll() {
        List<Cargo> response = this.cargoRepository.findAll();
        return new SuccessDataResult<List<Cargo>>(response, Messages.Cargo.getAllCargo);

    }

    @Override
    public DataResult<Cargo> getById(int id) {
        Cargo response = this.cargoRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Cargo>(response,Messages.Cargo.getByCargoId);

    }
    @Override
    public DataResult<List<Cargo>> getAllByPriceValueGreaterThan(int price) {
        List<Cargo> response = this.cargoRepository.findAllCargosByPriceGreaterThanOrderByPriceDesc(price);
        return new SuccessDataResult<List<Cargo>>(response,Messages.Cargo.getByCargoPrice);

    }

   /* @Override
    public List<Cargo> getAllByPrice(int price) {
        return cargoRepository.findAllByPrice(price);
    }
    */
    @Override
    public DataResult<Cargo> getByName(String name) {
        Cargo response = this.cargoRepository.findByName(name);
        return new SuccessDataResult<Cargo>(response,Messages.Cargo.getByCargoName);
    }


    @Override
    public DataResult<AddCargoResponse> addCargo(AddCargoRequest addCargoRequest) {
        // MAPPING => AUTO MAPPER
        Cargo cargo =
                modelMapperService.forRequest().map(addCargoRequest,Cargo.class);
        AddCargoResponse addCargoResponse =
                modelMapperService.getMapper().map(cargoRepository.save(cargo),AddCargoResponse.class);
        return new SuccessDataResult<AddCargoResponse>(addCargoResponse,Messages.Cargo.addCargo);
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