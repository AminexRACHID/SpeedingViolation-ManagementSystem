package org.miaad.immatriculationservice.web.graphQL;


import org.miaad.immatriculationservice.entities.Vehicule;
import org.miaad.immatriculationservice.repository.VehiculeRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VehiculeGraphQLController {
    private VehiculeRepository vehiculeRepository;

    public VehiculeGraphQLController(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    @QueryMapping
    public List<Vehicule> getVehicules(){
        return vehiculeRepository.findAll();
    }

    @QueryMapping
    public Vehicule getVehiculeById(@Argument Long id){
        return vehiculeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Vehicule %s not found ! ", id)));
    }

    @MutationMapping
    public Vehicule addVehicule(@Argument Vehicule vehicle){
        return vehiculeRepository.save(vehicle);
    }

    @MutationMapping
    public Boolean deleteVehicule(@Argument Long id){
        vehiculeRepository.deleteById(id);
        return true;
    }

}
