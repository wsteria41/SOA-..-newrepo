package com.example.examinationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TreatmentInstructionDto {
    private String examinationId;
    private String instruction;
}
