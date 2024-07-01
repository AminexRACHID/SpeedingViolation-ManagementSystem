package org.miaad.radarservice.web;

import org.miaad.radarservice.dto.InfoDTO;
import org.miaad.radarservice.entites.Radar;
import org.miaad.radarservice.repository.InfractionRestClient;
import org.miaad.radarservice.repository.RadarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component @RestResource @RestController
@RequestMapping("/radar")
public class RadarRestController {
    private RadarRepository radarRepository;
    private InfractionRestClient infractionRestClient;

    public RadarRestController(RadarRepository radarRepository,
                               InfractionRestClient infractionRestClient) {
        this.radarRepository = radarRepository;
        this.infractionRestClient = infractionRestClient;
    }


    @GetMapping("/radars")
    public List<Radar> getRadars(){
        return radarRepository.findAll();
    }


    @GetMapping("/radars/{id}")
    public Radar getRadarById(@PathVariable Long id){
        return radarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Radar %s not found !", id)));
    }
    @PostMapping("/newInfraction")
    public void newInfraction(@RequestBody InfoDTO info){
        infractionRestClient.saveInfraction(info);
    }

    @PutMapping("/radars/{id}")
    public Radar updateRadar(@PathVariable Long id, @RequestBody Radar radar){
        Radar r = radarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("radar %s not found !", id)));

        r.setName(radar.getName());
        r.setMaxSpeed(radar.getMaxSpeed());
        r.setLatitude(radar.getLatitude());
        r.setLongitude(radar.getLongitude());

        return radarRepository.save(r);
    }

    @PostMapping("/radars")
    public Radar saveRadar(@RequestBody Radar radar) {
        return radarRepository.save(radar);
    }

    @DeleteMapping("/deleteRadar/{id}")
    public void deleteRadar(@PathVariable Long id) {
        radarRepository.deleteById(id);
    }
}
