package org.miaad.infractionservice.feign;

import org.miaad.infractionservice.dto.Vehicule;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "immatriculation-service")
public interface VehiculeRestClient {
    @GetMapping("/miaad/vec/vehiculeByNM/{nm}")
    Vehicule getVehiculeByNumeroMatricule(@PathVariable String nm);
}
