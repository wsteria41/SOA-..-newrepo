package com.example.examinationservice.service;

import com.example.examinationservice.dto.ExaminationDto;
import com.example.examinationservice.entity.Examination;

import java.util.List;

public interface ExaminationService {
    Examination createExamination(ExaminationDto dto);
    Examination getExaminationById(String id);
    List<Examination> getExaminationsByUserId(String userId);
    Examination updateExamination(String id, ExaminationDto dto);
    void deleteExamination(String id);
    List<Examination> getAllExaminations();
}