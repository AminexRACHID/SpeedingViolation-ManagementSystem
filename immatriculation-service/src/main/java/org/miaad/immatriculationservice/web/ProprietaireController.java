package org.miaad.immatriculationservice.web;

import org.miaad.immatriculationservice.entities.Proprietaire;
import org.miaad.immatriculationservice.repository.ProprietaireRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/miaad/pro")
public class ProprietaireController {
    private ProprietaireRepository proprietaireRepository;

    public ProprietaireController(ProprietaireRepository proprietaireRepository) {
        this.proprietaireRepository = proprietaireRepository;
    }

    @RequestMapping("/proprietaires")
    List<Proprietaire> getAllProprietaires() {
        return proprietaireRepository.findAll();
    }

    @GetMapping("/proprietaires/{id}")
    public Proprietaire getPropreitaireById(@PathVariable Long id) {
        return proprietaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("proprietaire %s not found !", id)));
    }

    @PostMapping("/proprietaires")
    public Proprietaire saveProprietaire(@RequestBody Proprietaire proprietaire) {
        return proprietaireRepository.save(proprietaire);
    }

    @PutMapping("/proprietaires/{id}")
    public Proprietaire updateProprietaire(@PathVariable Long id, @RequestBody Proprietaire proprietaire) {
        Proprietaire o = proprietaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("proprietaire %s not found !", id)));

        if (proprietaire.getNom() != null) o.setNom(proprietaire.getNom());
        if (proprietaire.getEmail() != null) o.setEmail(proprietaire.getEmail());
        if (proprietaire.getDateNaissance() != null) o.setDateNaissance(proprietaire.getDateNaissance());
        if (proprietaire.getVehicules() != null) o.setVehicules(proprietaire.getVehicules());

        return proprietaireRepository.save(o);
    }

    @DeleteMapping("/proprietaires/{id}")
    public void deleteProprietaire(@PathVariable Long id) {
        proprietaireRepository.deleteById(id);
    }

    @GetMapping("/proprietairesByNom/{nom}")
    public Proprietaire getPropreitairesByNom(@PathVariable String nom){
        return proprietaireRepository.findProprietaireByNom(nom);
    }

    @GetMapping("/proprietairesByEmail/{em}")
    public Proprietaire getPropreitairesByEmail(@PathVariable String em){
        return proprietaireRepository.findProprietaireByEmail(em);
    }
}