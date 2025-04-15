package com.example.examinationservice.service.serviceImpl;

import com.example.examinationservice.dto.SurveyDto;
import com.example.examinationservice.entity.Examination;
import com.example.examinationservice.helper.ExaminationHelper;
import com.example.examinationservice.repository.ExaminationRepository;
import com.example.examinationservice.service.SurveyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SurveyServiceImpl implements SurveyService {
    private final ExaminationRepository examinationRepository;

    @Override
    public void submitSurvey(SurveyDto dto) {
        try {
            Examination exam = examinationRepository.findById(dto.getExaminationId())
                    .orElseThrow(() -> new RuntimeException("Эмчилгээний мэдээлэл олдсонгүй"));
            ExaminationHelper.updateSurvey(exam, dto.getSurveyData());
            examinationRepository.save(exam);
        } catch (RuntimeException e) {
            throw new RuntimeException("Судалгаа илгээх үед алдаа гарлаа: " + e.getMessage(), e);
        }
    }
}
