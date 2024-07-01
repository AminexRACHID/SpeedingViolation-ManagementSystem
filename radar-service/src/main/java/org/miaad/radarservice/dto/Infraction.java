package org.miaad.radarservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class Infraction {
    private Date date;
    private Long radarId;
    private String vehiculeMatricule;
    private double vehiculeSpeed;
    private double radarMaxSpeed;
    private double infractionAmount;
}
