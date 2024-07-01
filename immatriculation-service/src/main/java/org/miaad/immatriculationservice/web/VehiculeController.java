package org.miaad.immatriculationservice.web;

import org.miaad.immatriculationservice.entities.Proprietaire;
import org.miaad.immatriculationservice.entities.Vehicule;
import org.miaad.immatriculationservice.repository.VehiculeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/miaad/vec")
public class VehiculeController {
    private VehiculeRepository vehiculeRepository;

    public VehiculeController(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    @GetMapping("/vehicules")
    public List<Vehicule> getVehicule(){
        return vehiculeRepository.findAll();
    }

    @GetMapping("/vehicules/{id}")
//    @PreAuthorize("hasAuthority('USER')")
    public Vehicule getVehiculeById(@PathVariable Long id){
        return vehiculeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Vehicule %s not found !", id)));
    }

    @PostMapping("/vehicules")
    public Vehicule saveVehicule(@RequestBody Vehicule vehicule){
        return vehiculeRepository.save(vehicule);
    }

    @PutMapping ("/vehicules/{id}")
    public Vehicule updateVehicule(@PathVariable Long id, @RequestBody Vehicule vehicule){
        Vehicule v = vehiculeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Vehicule %s not found !", id)));

        if(vehicule.getModele() != null) v.setModele(vehicule.getModele());
        if(vehicule.getMarque() != null) v.setMarque(vehicule.getMarque());
        if(vehicule.getPuissanceFiscale() != null) v.setPuissanceFiscale(vehicule.getPuissanceFiscale());
        if(vehicule.getNumeroMatricule() != null) v.setNumeroMatricule(vehicule.getNumeroMatricule());
        if(vehicule.getProprietaire() != null) v.setProprietaire(vehicule.getProprietaire());

        return vehiculeRepository.save(v);
    }

    @DeleteMapping("/vehicules/{id}")
    public void deleteVehicule(@PathVariable Long id){
        vehiculeRepository.deleteById(id);
    }

    @GetMapping("/pageVehicule")
    public Page<Vehicule> getPageVehicule(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return vehiculeRepository.findAll(pageable);
    }

    @GetMapping("/vehicules/count")
    public Long getVehiculesCount() {
        return vehiculeRepository.count();
    }

    @GetMapping("/vehiculeByNM/{nm}")
    public Vehicule getVehiculeByNumeroMatricule(@PathVariable String nm){
        return vehiculeRepository.findVehiculeByNumeroMatricule(nm);
    }

    @GetMapping("/vehiculeByMarque/{mrq}")
    public List<Vehicule> getVehiculesByMarque(@PathVariable String mrq){
        return vehiculeRepository.findVehiculeByMarque(mrq);
    }

    @GetMapping("/vehiculeByMd/{md}")
    public List<Vehicule>  getVehiculesByModele(@PathVariable String md){
        return vehiculeRepository.findVehiculeByModele(md);
    }

}
