package com.etiya.ecommerscedemopair5.repository.abstracts;


import com.etiya.ecommerscedemopair5.entities.concretes.Product;
import com.etiya.ecommerscedemopair5.entities.concretes.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SizeRepository extends JpaRepository<Size,Integer> {


    List<Size> findAllSizesByStockGreaterThanOrderByStockDesc(int stock);

    @Query("Select s from Size as s WHERE name=:name")
    Size findByName(String name);
}
