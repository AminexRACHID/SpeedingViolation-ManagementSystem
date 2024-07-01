package org.miaad.radarservice.repository;

import org.miaad.radarservice.dto.InfoDTO;
import org.miaad.radarservice.dto.Infraction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "infraction-service")
public interface InfractionRestClient {
    @PostMapping("/miaad/inf/saveInfraction")
    Infraction saveInfraction(@RequestBody InfoDTO info);
}
