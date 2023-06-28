package com.example.emtaud.service_or_business.impl;

import com.example.emtaud.model.Manufacturer;
import com.example.emtaud.model.exception.ManufacturerNotFoundException;
import com.example.emtaud.persistence_or_repository.ManufacturerRepository;
import com.example.emtaud.service_or_business.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;


//ovoj Bean kje se kreira samo dokolku aktiveniot profil NE e amazon (ova vazhi i nieden profil da ne e aktiven)
//i vo toj sluchaj
//sekade kade shto se koristi ManufacturerService interfejsot (kako vo kontrolerite)
//implementacijata koja kje ja prepoznae kje bide ovaa namesto ManufacturerAmazonServiceImpl
@Service
@Profile("!amazon")
public class ManufacturerServiceImpl implements ManufacturerService {


    private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return this.manufacturerRepository.findAll();
    }

    @Override
    public List<Manufacturer> findAllByName(String name) {
//        return this.manufacturerRepository.findAllByName(name);
        return null;
    }

    @Override
    public Manufacturer findById(Long id) {
        return this.manufacturerRepository.findById(id)
                .orElseThrow(() -> new ManufacturerNotFoundException(id));
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        return this.manufacturerRepository.save(manufacturer);
    }

    @Override
    public Manufacturer update(Long id, Manufacturer manufacturer) {
        Manufacturer m = this.findById(id);
        m.setName(manufacturer.getName());
        m.setAddress(manufacturer.getAddress());
        return this.manufacturerRepository.save(m);
    }

    @Override
    public Manufacturer updateName(Long id, String name) {
        Manufacturer m = this.findById(id);
        m.setName(name);
        return this.manufacturerRepository.save(m);
    }

    @Override
    public void deleteById(Long id) {
//        this is correct, you should check if manufacturer has products
//        only manufacturer without products could be deleted
//        Manufacturer manufacturer = this.findById(id);
//        if (manufacturer.getProducts().size() > 0) {
//            //throw exception
//        }

//        this is if you want to delete the relationship, but it will fail because manufacturer
//        is  annotated @NotNull in products
//        manufacturer.getProducts()
//                .forEach(product -> product.setManufacturer(null));

        this.manufacturerRepository.deleteById(id);
    }
}
