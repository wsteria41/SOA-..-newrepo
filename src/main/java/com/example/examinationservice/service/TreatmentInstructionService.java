package com.example.examinationservice.service;

import com.example.examinationservice.dto.TreatmentInstructionDto;
import com.example.examinationservice.entity.Examination;

public interface TreatmentInstructionService {
    Examination addInstruction(TreatmentInstructionDto dto);
    void validateTreatmentInstructionDto(TreatmentInstructionDto dto);
}
