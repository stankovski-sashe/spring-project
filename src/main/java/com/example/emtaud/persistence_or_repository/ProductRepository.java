package com.example.emtaud.persistence_or_repository;

import com.example.emtaud.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    List<Product> findAll();
//    List<Product> findAllSortedByPrice(boolean asc);
//    List<Product> findAllByManufacturerId(Long manufacturerId);
//    Optional<Product> findById(Long id);
//    Product save(Product product);
//    void deleteById(Long id);

//    @Query(value = "select * from products p order by p.price asc;", nativeQuery = true)
//    @Query("select p from Product p order by p.price asc")
    List<Product> findAllByOrderByPriceAsc();



    List<Product> findAllByOrderByPriceDesc();

//    @Query("select count(p) from Product p where p.price > :price")
    long countAllByPriceGreaterThan(@Param("price") Float price);

    List<Product> findAllByPriceGreaterThan(@Param("price") Float price);


//    @Query(value = "select * from products join manufacturers m where m.id = :id ;", nativeQuery = true)
//    @Query("select p from Product p where p.manufacturer.id = :id")
    List<Product> findAllByManufacturerId(@Param("id") Long id);
    List<Product> findAllByNameLikeAndManufacturerIdOrderByPriceDesc(String name, Long manufacturerId);
}
