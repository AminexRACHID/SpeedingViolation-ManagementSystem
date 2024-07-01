package org.miaad.immatriculationservice;

import org.miaad.immatriculationservice.entities.Proprietaire;
import org.miaad.immatriculationservice.entities.Vehicule;
import org.miaad.immatriculationservice.repository.ProprietaireRepository;
import org.miaad.immatriculationservice.repository.VehiculeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ImmatriculationServiceApplication {
	Random random = new Random();
	public static void main(String[] args) {

		SpringApplication.run(ImmatriculationServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(VehiculeRepository vehiculeRepository, ProprietaireRepository proprietaireRepository) {
		return args -> {
			Stream.of("Amine RACHID", "Adnane TOUZOUZ", "Younes ZIYADI").forEach(o -> {

				String em = o.replaceAll(" ",".");
				Proprietaire owner = Proprietaire.builder()
						.nom(o)
						.email(em+ "@gmail.com")
						.dateNaissance(new Date())
						.build();
				proprietaireRepository.save(owner);
			});

			proprietaireRepository.findAll().forEach(owner -> {
				for (int i = 0; i < 3; i++) {
					Vehicule vehicule = Vehicule.builder()
							.numeroMatricule(UUID.randomUUID().toString())
							.puissanceFiscale(Double.valueOf(random.nextInt(1000)))
							.marque("marque" + random.nextInt(23))
							.modele("modele" + random.nextInt(23))
							.proprietaire(owner)
							.build();
					vehiculeRepository.save(vehicule);
				}
			});

		};
	}

}
