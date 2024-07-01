package org.miaad.immatriculationservice.repository;

import org.miaad.immatriculationservice.entities.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource
public interface ProprietaireRepository extends JpaRepository<Proprietaire, Long> {
    //List<Proprietaire> findProprietaireById(Long id);
    //List<Proprietaire> findProprietaireByDateNaissance(LocalDate dateNaissance);
    Proprietaire findProprietaireByNom(String nom);
    Proprietaire findProprietaireByEmail(String email);

}