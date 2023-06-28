package com.example.emtaud.service_or_business;

import com.example.emtaud.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<Product> findAll();
    List<Product> findAllByManufacturerId(Long manufacturerId);
    List<Product> findAllSortedByPrice(boolean asc);
    Product findById(Long id);
    Product saveProduct(String name, Float price, Integer quantity, Long manufacturerId);
    Product saveProduct(Product product, MultipartFile image) throws IOException;
    Product updateProduct(Long id, Product product, MultipartFile image) throws IOException;
    void deleteById(Long id);
}
