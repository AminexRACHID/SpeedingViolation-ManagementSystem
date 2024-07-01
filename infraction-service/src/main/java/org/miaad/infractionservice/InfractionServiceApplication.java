package org.miaad.infractionservice;

import org.miaad.infractionservice.entities.Infraction;
import org.miaad.infractionservice.repository.InfractionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
@EnableFeignClients
public class InfractionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfractionServiceApplication.class, args);
	}
    Random random = new Random();
/*
    @Bean
	CommandLineRunner start(InfractionRepository infractionRepository) {
        return args -> {
            Stream.of("inf1", "inf2", "inf3", "inf4").forEach(i -> {
                Infraction infraction = Infraction.builder()
                        .date(new Date())
                        .radarId(2L)
                        .radarMaxSpeed(180)
                        .vehiculeMatricule("4bfc95b2-a6af-4ffa-9008-ccc80a065953")
                        .infractionAmount(500)
                        .vehiculeSpeed(230)
                        .build();
                infractionRepository.save(infraction);
            });
        };
    }*/
}
