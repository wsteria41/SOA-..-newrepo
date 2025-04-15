package com.example.examinationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "examinations")
public class Examination {
    @Id
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

