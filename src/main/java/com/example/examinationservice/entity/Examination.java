package com.example.examinationservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "examinations")
public class Examination {
    @Id
    private String id;

    @Indexed
    @Field("user_id")
    private String userId;

    private String diagnosis;
    private String survey;

    @Field("treatment_instruction")
    private String treatmentInstruction;

    private String prescription;
    private String report;

    @Field("body_temperature")
    private Double bodyTemperature;

    @Field("heart_rate")
    private Integer heartRate;

    @Field("respiratory_rate")
    private Integer respiratoryRate;

    @Field("blood_pressure")
    private String bloodPressure;

    @Field("vital_signs_measured_at")
    private LocalDateTime vitalSignsMeasuredAt;

    @Field("created_at")
    private LocalDateTime createdAt;

    @Field("updated_at")
    private LocalDateTime updatedAt;
}