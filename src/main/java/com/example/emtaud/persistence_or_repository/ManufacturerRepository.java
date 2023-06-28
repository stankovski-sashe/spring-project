package com.example.emtaud.persistence_or_repository;

import com.example.emtaud.model.Manufacturer;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


//ovoj Bean iako e interface, bidejkji nasleduva od JpaRepository,
// kje se kreira samo dokolku aktiveniot profil NE e in-memory (ova vazhi i nieden profil da ne e aktiven)
//i vo toj sluchaj
//sekade kade shto se koristi ManufacturerRepository interfejsot (kako vo servisite)
//implementacijata koja kje ja prepoznae kje bide ovaa (defaultnata od Jpa)
//namesto ManaufacturerRepositoryInMemoryImpl
@Repository
@Profile("!in-memory")
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
//    List<Manufacturer> findAll();
//    List<Manufacturer> findAllByName(String name);
//    Optional<Manufacturer> findById(Long id);
//    Manufacturer save(Manufacturer manufacturer);
//    void deleteById(Long id);

}
