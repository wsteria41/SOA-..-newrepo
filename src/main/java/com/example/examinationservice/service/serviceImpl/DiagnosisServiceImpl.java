package com.example.examinationservice.service.serviceImpl;

import com.example.examinationservice.dto.DiagnosisDto;
import com.example.examinationservice.entity.Examination;
import com.example.examinationservice.helper.ExaminationHelper;
import com.example.examinationservice.repository.ExaminationRepository;
import com.example.examinationservice.service.DiagnosisService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DiagnosisServiceImpl implements DiagnosisService {
    private final ExaminationRepository examinationRepository;

    @Override
    public void addDiagnosis(DiagnosisDto dto) {
        try {
            Examination exam = examinationRepository.findById(dto.getExaminationId())
                    .orElseThrow(() -> new RuntimeException("Эмчилгээний мэдээлэл олдсонгүй"));
            ExaminationHelper.updateDiagnosis(exam, dto.getDiagnosis());
            examinationRepository.save(exam);
        } catch (RuntimeException e) {
            throw new RuntimeException("Онош тавихад алдаа гарлаа: " + e.getMessage(), e);
        }
    }
}
