package com.example.emtaud.persistence_or_repository.impl;

import com.example.emtaud.model.Manufacturer;
import com.example.emtaud.persistence_or_repository.ManufacturerRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;


//ovoj Bean  kje se kreira samo dokolku aktiveniot profil e in-memory
//i vo toj sluchaj
//sekade kade shto se koristi ManufacturerRepository interfejsot (kako vo servisite)
//implementacijata koja kje ja prepoznae kje bide ovaa
//namesto defaultnata od Jpa
@Repository
@Profile("in-memory")
public class ManufacturerRepositoryInMemoryImpl implements ManufacturerRepository {

    private HashMap<Long, Manufacturer> manufacturers;
    private AtomicLong counter;

    public ManufacturerRepositoryInMemoryImpl() {
        this.manufacturers = new HashMap<>();
        this.counter = new AtomicLong(0);
//        Manufacturer m1 = new Manufacturer(1L, "m1");
//        Manufacturer m2 = new Manufacturer(2L, "m2");
//        this.manufacturers.put(m1.getId(), m1);
//        this.manufacturers.put(m2.getId(), m2);
//        you can also use @PostConstruct for this,
//        it is invoked after Constructor
    }

    @Override
    public List<Manufacturer> findAll() {
        return new ArrayList<>(this.manufacturers.values());
    }

    @Override
    public List<Manufacturer> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Manufacturer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Manufacturer> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public <S extends Manufacturer> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Manufacturer> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Manufacturer> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Manufacturer getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Manufacturer> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Manufacturer> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Manufacturer> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Manufacturer> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Manufacturer> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Manufacturer> boolean exists(Example<S> example) {
        return false;
    }

//    @Override
//    public List<Manufacturer> findAllByName(String name) {
//        return this.manufacturers.values()
//                .stream()
//                .filter(item -> item.getName().contains(name))
//                .collect(Collectors.toList());
//    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return Optional.ofNullable(this.manufacturers.get(id));
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        if (manufacturer.getId() == null) {
            manufacturer.setId(this.counter.getAndIncrement());
        }
        this.manufacturers.put(manufacturer.getId(), manufacturer);
        return manufacturer;
    }

    @Override
    public void deleteById(Long id) {
        this.manufacturers.remove(id);
    }

    @Override
    public void delete(Manufacturer manufacturer) {

    }

    @Override
    public void deleteAll(Iterable<? extends Manufacturer> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
