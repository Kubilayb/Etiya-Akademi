package com.etiya.ecommerscedemopair5.repository.abstracts;

import com.etiya.ecommerscedemopair5.business.dtos.CategoryDTO;
import com.etiya.ecommerscedemopair5.business.dtos.ProductDTO;
import com.etiya.ecommerscedemopair5.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    //özel queryler yazacağız  KATMANLI MİMARİ

    //List<Category> findByNameEquals(String name);

    boolean existsCategoryByName(String name);

    @Query("Select new com.etiya.ecommerscedemopair5.business.dtos.CategoryDTO" +
            "(ca.id,ca.name,ca.type)" +
            " from Category ca WHERE ca.id=:id")
    List<CategoryDTO> findByCategoryExample(int id);


    /*
    @Query("select new com.etiya.ecommercedemo4.business.dtos.response.address.GetAddressDto" +
            "(a.id,u.name,s.name,d.name,t.name,c.name,co.name)" +
            " from Address a inner join a.street s inner join s.district d inner join d.town t inner join" +
            " t.city c inner join c.country co inner join a.user u where a.id =:id")
    GetAddressDto getAddressDto(int id);
     */







   /* @Query("Select new com.etiya.ecommerscedemopair5.business.dtos.ProductDTO(p.id,p.name)" +
            " from Product p WHERE p.id=:id")
    List<CategoryDTO> findByExample();
*/
}
