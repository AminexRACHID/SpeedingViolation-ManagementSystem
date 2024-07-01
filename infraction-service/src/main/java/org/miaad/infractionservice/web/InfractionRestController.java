package org.miaad.infractionservice.web;

import org.miaad.infractionservice.dto.InfoDTO;
import org.miaad.infractionservice.dto.Radar;
import org.miaad.infractionservice.dto.Vehicule;
import org.miaad.infractionservice.entities.Infraction;
import org.miaad.infractionservice.feign.RadarRestClient;
import org.miaad.infractionservice.feign.VehiculeRestClient;
import org.miaad.infractionservice.repository.InfractionRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RestResource
@RequestMapping("/miaad/inf")
public class InfractionRestController {
    private VehiculeRestClient vehiculeRestClient;
    private RadarRestClient radarRestClient;
    private InfractionRepository infractionRepository;

    public InfractionRestController(VehiculeRestClient vehiculeRestClient, RadarRestClient radarRestClient, InfractionRepository infractionRepository) {
        this.vehiculeRestClient = vehiculeRestClient;
        this.radarRestClient = radarRestClient;
        this.infractionRepository = infractionRepository;
    }

    @RequestMapping("/infractions")
        List<Infraction> getAllInfractions() {
        return infractionRepository.findAll();
    }
    @PostMapping("/saveInfraction")
    public Infraction saveInfraction(@RequestBody InfoDTO info){
        Vehicule v = vehiculeRestClient.getVehiculeByNumeroMatricule(info.getRn());
        Radar r = radarRestClient.getRadarById(info.getRadarId());
        r.setId(info.getRadarId());
        Infraction infraction = Infraction.builder()
                .vehicule(v)
                .radar(r)
                .vehiculeSpeed(info.getVehiculeSpeed())
                .vehiculeMatricule(info.getRn())
                .radarId(info.getRadarId())
                .infractionAmount(new Random().nextInt(1000))
                .date(new Date())
                .radarMaxSpeed(r.getMaxSpeed())
                .build();

        infractionRepository.save(infraction);
        return infraction;
    }

    @GetMapping(path = "/fullInfractions")
    public List<Infraction> getFullInfractions(){
        List<Infraction> infractions = infractionRepository.findAll();
        infractions.forEach(infraction -> {
            Vehicule vehicule = vehiculeRestClient.getVehiculeByNumeroMatricule(infraction.getVehiculeMatricule());
            infraction.setVehicule(vehicule);

            Radar radar = radarRestClient.getRadarById(infraction.getRadarId());
            radar.setId(infraction.getRadarId());
            infraction.setRadar(radar);

        });
        return infractions;
    }

    @GetMapping("/count")
    public Long getInfractionsCount() {
        return infractionRepository.count();
    }

    @GetMapping(path = "/save/{id}")
    public Infraction getInfraction(@PathVariable(name = "id") Long id){
        Infraction infraction = infractionRepository.findById(id).get();
        Vehicule v = vehiculeRestClient.getVehiculeByNumeroMatricule(infraction.getVehiculeMatricule());
        Radar r = radarRestClient.getRadarById(infraction.getRadarId());

        r.setId(infraction.getRadarId());
        infraction.setRadar(r);
        infraction.setVehicule(v);


        return infraction;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteInfraction(@PathVariable Long id) {
        infractionRepository.deleteById(id);
    }

}
