package org.miaad.radarservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class InfoDTO {
    private Long radarId;
    private String rn;
    private double vehiculeSpeed;


}
