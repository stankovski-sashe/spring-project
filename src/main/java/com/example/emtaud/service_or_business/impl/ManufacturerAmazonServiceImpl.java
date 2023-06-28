package com.example.emtaud.service_or_business.impl;

import com.example.emtaud.model.Manufacturer;
import com.example.emtaud.service_or_business.ManufacturerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

//ovoj Bean kje se kreira samo dokolku aktiven profil e amazon i vo toj sluchaj
//sekade kade shto se koristi ManufacturerService interfejsot (kako vo kontrolerite)
//implementacijata koja kje ja prepoznae kje bide ovaa namesto ManufacturerServiceImpl
//momentalno ne pravi nishto, samo za primer za profili go napraviv
@Service
@Profile("amazon")
public class ManufacturerAmazonServiceImpl implements ManufacturerService {
    @Override
    public List<Manufacturer> findAll() {
        return null;
    }

    @Override
    public List<Manufacturer> findAllByName(String name) {
        return null;
    }

    @Override
    public Manufacturer findById(Long id) {
        return null;
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        return null;
    }

    @Override
    public Manufacturer update(Long id, Manufacturer manufacturer) {
        return null;
    }

    @Override
    public Manufacturer updateName(Long id, String name) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
