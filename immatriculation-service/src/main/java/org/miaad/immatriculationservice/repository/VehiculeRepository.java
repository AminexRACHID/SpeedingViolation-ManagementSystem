package org.miaad.immatriculationservice.repository;

import org.miaad.immatriculationservice.entities.Proprietaire;
import org.miaad.immatriculationservice.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
    //List<Vehicule> findVehiculeById(Long id);
    Vehicule findVehiculeByNumeroMatricule(String numeroMatricule);
    List<Vehicule> findVehiculeByMarque(String marque);
    List<Vehicule> findVehiculeByModele(String modele);

    List<Vehicule> findVehiculeByProprietaire(Proprietaire proprietaire);
}