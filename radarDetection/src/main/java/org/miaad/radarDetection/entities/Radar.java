package org.miaad.radarDetection.entities;

import lombok.Data;

@Data
public class Radar {
    private Long id;
    private String name;
    private int maxSpeed;
    private double longitude;
    private double latitude;
}