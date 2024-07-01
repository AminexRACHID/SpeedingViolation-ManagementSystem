package org.miaad.immatriculationservice.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.miaad.immatriculationservice.entities.Proprietaire;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor @Builder
public class VehiculeRequestDTO {
    private String numeroMatricule;
    private String marque;
    private String puissanceFiscale;
    private String modele;
    private Proprietaire proprietaire;
}
