package org.miaad.radarDetection.entities;

import lombok.Data;

@Data
public class Vehicule {
    private Long id;
    private String numeroMatricule;
    private String marque;
    private Double puissanceFiscale;
    private String modele;

}

