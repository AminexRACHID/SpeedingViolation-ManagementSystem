package org.miaad.infractionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class InfoDTO {
    private Long radarId;
    private String rn;
    private double vehiculeSpeed;
}