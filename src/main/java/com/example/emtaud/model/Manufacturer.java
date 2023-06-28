package com.example.emtaud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "manufacturers")
public class Manufacturer {

    @Id //oznachuva deka ova pole e primaren kluch na ovoj entitet vo tabelata
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, message = "Name must be longer than 3 characters")
    private String name;
    private String address;

    @JsonIgnore
    @OneToMany(
            mappedBy = "manufacturer"
//            orphanRemoval = true   -> this will remove all related entities, if we remove given manufacturer it will remove also all products
    )
    List<Product> products;

    public Manufacturer() {}

    public Manufacturer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
