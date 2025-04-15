package com.example.examinationservice.service.serviceImpl;

import com.example.examinationservice.dto.ExaminationDto;
import com.example.examinationservice.entity.Examination;
import com.example.examinationservice.repository.ExaminationRepository;
import com.example.examinationservice.service.ExaminationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExaminationServiceImpl implements ExaminationService {

    private final ExaminationRepository examinationRepository;

    @Override
    public void createExamination(ExaminationDto dto) {
        try {
            Examination examination = new Examination();
            examination.setUserId(dto.getUserId());
            examination.setDiagnosis(dto.getDiagnosis());
            examination.setSurvey(dto.getSurvey());
            examination.setTreatmentInstruction(dto.getTreatmentInstruction());
            examination.setPrescription(dto.getPrescription());
            examination.setReport(dto.getReport());
            examination.setBodyTemperature(dto.getBodyTemperature());
            examination.setHeartRate(dto.getHeartRate());
            examination.setRespiratoryRate(dto.getRespiratoryRate());
            examination.setBloodPressure(dto.getBloodPressure());

            examinationRepository.save(examination);
        } catch (Exception e) {
            throw new RuntimeException("Үзлэг нэмэхэд алдаа гарлаа: " + e.getMessage());
        }
    }
}
