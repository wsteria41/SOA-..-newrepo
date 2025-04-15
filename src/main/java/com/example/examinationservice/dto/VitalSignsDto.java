package com.example.examinationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class VitalSignsDto {
    private String userId;
    private Double bodyTemperature;
    private Integer heartRate;
    private Integer respiratoryRate;
    private String bloodPressure;
    private LocalDateTime measuredAt;
}
