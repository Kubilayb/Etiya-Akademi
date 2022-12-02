package com.etiya.ecommerscedemopair5.business.concretes;

import com.etiya.ecommerscedemopair5.business.abstracts.CargoService;
import com.etiya.ecommerscedemopair5.entities.concretes.Cargo;
import com.etiya.ecommerscedemopair5.entities.concretes.Product;
import com.etiya.ecommerscedemopair5.repository.abstracts.CargoRepository;
import com.etiya.ecommerscedemopair5.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor

public class CargoManager implements CargoService {

    private CargoRepository cargoRepository;
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

    @Override
    public Cargo getByName(String name) {
        return cargoRepository.findByName(name);
    }
}
