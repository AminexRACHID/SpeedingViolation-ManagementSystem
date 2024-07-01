package org.miaad.radarservice;

import org.miaad.radarservice.repository.RadarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
@EnableFeignClients
public class RadarServiceApplication {
    Random random = new Random();
    public static void main(String[] args) {
        SpringApplication.run(RadarServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(RadarRepository radarRepository) {
        return args -> {
            Stream.of("radar1", "radar2", "radar3", "radar4").forEach(i -> {
                org.miaad.radarservice.entites.Radar radar = org.miaad.radarservice.entites.Radar.builder()
                        .name(i)
                        .maxSpeed(180)
                        .latitude(random.nextDouble(10))
                        .longitude(random.nextDouble(10))
                        .build();
                radarRepository.save(radar);
            });
        };
    }

}
