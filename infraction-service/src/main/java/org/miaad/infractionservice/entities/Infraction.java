package org.miaad.infractionservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.miaad.infractionservice.dto.Radar;
import org.miaad.infractionservice.dto.Vehicule;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Infraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Long radarId;
    private String vehiculeMatricule;
    private double vehiculeSpeed;
    private double radarMaxSpeed;
    private double infractionAmount;
    @Transient
    private Vehicule vehicule;
    @Transient
    private Radar radar;
}
