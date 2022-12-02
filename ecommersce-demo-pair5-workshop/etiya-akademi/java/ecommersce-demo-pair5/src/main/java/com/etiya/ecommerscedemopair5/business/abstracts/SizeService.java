package com.etiya.ecommerscedemopair5.business.abstracts;

import com.etiya.ecommerscedemopair5.entities.concretes.Product;
import com.etiya.ecommerscedemopair5.entities.concretes.Size;

import java.util.List;

public interface SizeService {

    List<Size> getAllByStockGreaterThan(int stock);

    List<Size> getAll();

    Size getById(int id);

    Size getByName(String name);
}
