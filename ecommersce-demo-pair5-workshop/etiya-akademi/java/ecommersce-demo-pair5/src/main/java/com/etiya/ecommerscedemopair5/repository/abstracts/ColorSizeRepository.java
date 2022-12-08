package com.etiya.ecommerscedemopair5.repository.abstracts;

import com.etiya.ecommerscedemopair5.entities.concretes.ColorSizeRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorSizeRepository extends JpaRepository<ColorSizeRelation,Integer> {
}
