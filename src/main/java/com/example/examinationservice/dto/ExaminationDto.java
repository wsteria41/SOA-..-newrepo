package com.example.examinationservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExaminationDto {
    private String id;
    private String userId;
    private String diagnosis;
    private String survey;
    private String treatmentInstruction;
    private String prescription;
    private String report;

    private Double bodyTemperature;
    private Integer heartRate;
    private Integer respiratoryRate;
    private String bloodPressure;
    private LocalDateTime vitalSignsMeasuredAt;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
