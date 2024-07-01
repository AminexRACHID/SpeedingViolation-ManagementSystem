package org.miaad.infractionservice.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @AllArgsConstructor @NoArgsConstructor
public class Vehicule {
    private Long id;
    private String numeroMatricule;
    private String marque;
    private Double puissanceFiscale;
    private String modele;
    private Proprietaire proprietaire;
}