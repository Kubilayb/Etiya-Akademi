package com.etiya.ecommerscedemopair5.repository.abstracts;

import com.etiya.ecommerscedemopair5.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    //özel queryler yazacağız  KATMANLI MİMARİ

    //List<Category> findByNameEquals(String name);

    boolean existsCategoryByName(String name);

}
