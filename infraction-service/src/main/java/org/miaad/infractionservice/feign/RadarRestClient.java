package org.miaad.infractionservice.feign;

import org.miaad.infractionservice.dto.Radar;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "radar-service")
public interface RadarRestClient {
    @GetMapping("/radar/radars/{id}")
    Radar getRadarById(@PathVariable Long id);
}
