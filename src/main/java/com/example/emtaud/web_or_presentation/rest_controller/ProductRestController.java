package com.example.emtaud.web_or_presentation.rest_controller;

import com.example.emtaud.model.Product;
import com.example.emtaud.service_or_business.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> findAll() {
        return this.productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return this.productService.findById(id);
    }

    @GetMapping("/by-manufacturer/{manufacturerId}")
    public List<Product> findAllByManufacturerId(@PathVariable Long manufacturerId) {
        return this.productService.findAllByManufacturerId(manufacturerId);
    }

    @GetMapping("/by-price")
    public List<Product> findAllSortedByPrice(
            @RequestParam (required = false, defaultValue = "true") Boolean asc) {
        return this.productService.findAllSortedByPrice(asc);
    }


    @PostMapping
    public Product save(@Valid Product product, @RequestParam(required = false) MultipartFile image) throws IOException {
        return this.productService.saveProduct(product, image);
    }


    @PutMapping("/{id}")
    public Product update(@PathVariable Long id,
                          @Valid Product product,
                          @RequestParam(required = false) MultipartFile image) throws IOException {
        return this.productService.updateProduct(id, product, image);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.productService.deleteById(id);
    }

}
