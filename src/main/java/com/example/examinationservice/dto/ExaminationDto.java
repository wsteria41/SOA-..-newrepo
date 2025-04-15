package com.example.examinationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExaminationDto {
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

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VitalSignsDto {
        private Double bodyTemperature;
        private Integer heartRate;
        private Integer respiratoryRate;
        private String bloodPressure;
    }
}