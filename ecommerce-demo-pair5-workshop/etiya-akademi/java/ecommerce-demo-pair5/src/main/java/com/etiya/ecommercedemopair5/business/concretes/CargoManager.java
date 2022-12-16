package com.etiya.ecommercedemopair5.business.concretes;

import com.etiya.ecommercedemopair5.business.abstracts.CargoService;
import com.etiya.ecommercedemopair5.business.constants.Messages;
import com.etiya.ecommercedemopair5.business.dtos.request.cargo.AddCargoRequest;

import com.etiya.ecommercedemopair5.business.dtos.response.cargo.AddCargoResponse;
import com.etiya.ecommercedemopair5.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemopair5.core.util.results.DataResult;
import com.etiya.ecommercedemopair5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair5.entities.concretes.Cargo;
import com.etiya.ecommercedemopair5.entities.concretes.Product;
import com.etiya.ecommercedemopair5.repository.abstracts.CargoRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor

public class CargoManager implements CargoService {

    private CargoRepository cargoRepository;

    private ModelMapperService modelMapperService;
    private MessageSource messageSource;


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

    @Override
    public Page<Cargo> findAllWithPagination(Pageable pageable) {
        return cargoRepository.findAll(pageable);
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

        cargoCanNotExistWithSameName(addCargoRequest.getName());

        // MAPPING => AUTO MAPPER
        Cargo cargo =
                modelMapperService.forRequest().map(addCargoRequest,Cargo.class);
        AddCargoResponse addCargoResponse =
                modelMapperService.getMapper().map(cargoRepository.save(cargo),AddCargoResponse.class);
        return new SuccessDataResult<AddCargoResponse>(addCargoResponse,Messages.Cargo.addCargo);
    }

    private void cargoCanNotExistWithSameName(String name) {
        boolean isExists = cargoRepository.existsCargoByName(name);
        if (isExists) // Veritabanımda bu isimde bir cargo mevcut!!
            throw new BusinessException(messageSource.getMessage
                    (Messages.Cargo.CargoExistsWithSameName,null, LocaleContextHolder.getLocale()));

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