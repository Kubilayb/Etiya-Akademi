package com.etiya.ecommerscedemopair5.business.abstracts;

import com.etiya.ecommerscedemopair5.entities.concretes.Cargo;
import com.etiya.ecommerscedemopair5.entities.concretes.Product;

import java.util.List;

public interface CargoService {

        List<Cargo> getAll();
        Cargo getById(int id);
        List<Cargo> getAllByPriceValueGreaterThan(int price);
        Cargo getByName(String name);
    }

