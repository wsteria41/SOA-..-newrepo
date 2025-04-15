package com.example.examinationservice.service;

import com.example.examinationservice.dto.DiagnosisDto;
import com.example.examinationservice.entity.Examination;

public interface DiagnosisService {
    Examination addDiagnosis(DiagnosisDto dto);
    void validateDiagnosisDto(DiagnosisDto dto);
}
