//package com.example.emtaud.persistence_or_repository.impl;
//
//import com.example.emtaud.model.Product;
//import com.example.emtaud.persistence_or_repository.ProductRepository;
//import org.springframework.stereotype.Repository;
//
//import javax.annotation.PostConstruct;
//import java.util.*;
//import java.util.stream.Collectors;
//
//@Repository
//public class ProductRepositoryImpl implements ProductRepository {
//
//    private HashMap<Long, Product> products;
//    private Long counter;
//
//
//
//    @PostConstruct
//    public void init() {
//        this.counter = 0L;
//        this.products = new HashMap<>();
//        Long id = this.generateKey();
//        this.products.put(id, new Product(id,"p1",123f,3, null));
//        id = this.generateKey();
//        this.products.put(id, new Product(id,"p2",124f,4, null));
//    }
//
//
//    @Override
//    public List<Product> findAll() {
//        return new ArrayList<>(this.products.values());
//    }
//
//    @Override
//    public List<Product> findAllSortedByPrice(boolean asc) {
//        Comparator<Product> priceComparator = Comparator.comparing(Product::getPrice);
//        if (!asc) {
//            priceComparator = priceComparator.reversed();
//        }
//        return this.products.values()
//                .stream()
//                .sorted(priceComparator)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Product> findAllByManufacturerId(Long manufacturerId) {
//        return this.products.values()
//                .stream()
//                .filter(item -> item.getManufacturer().getId().equals(manufacturerId))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public Optional<Product> findById(Long id) {
//        return Optional.ofNullable(this.products.get(id));
//    }
//
//    @Override
//    public Product save(Product product) {
//        if (product.getId() == null) {
//            product.setId(this.generateKey());
//        }
//        this.products.put(product.getId(), product);
//        return product;
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        this.products.remove(id);
//    }
//
//    private Long generateKey() {
//        return ++counter;
//    }
//}
