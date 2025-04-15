package com.example.examinationservice.service.serviceImpl;

import com.example.examinationservice.dto.DiagnosisDto;
import com.example.examinationservice.entity.Examination;
import com.example.examinationservice.exception.ExaminationNotFoundException;
import com.example.examinationservice.exception.InvalidDataException;
import com.example.examinationservice.helper.ExaminationHelper;
import com.example.examinationservice.repository.ExaminationRepository;
import com.example.examinationservice.service.DiagnosisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class DiagnosisServiceImpl implements DiagnosisService {

    private final ExaminationRepository examinationRepository;

    @Override
    @Transactional
    public Examination addDiagnosis(DiagnosisDto dto) {
        validateDiagnosisDto(dto);
        
        Examination exam = examinationRepository.findById(dto.getExaminationId())
                .orElseThrow(() -> new ExaminationNotFoundException(
                    "Үзлэгийн мэдээлэл олдсонгүй. ID: " + dto.getExaminationId()));
        
        ExaminationHelper.updateDiagnosis(exam, dto.getDiagnosis());
        exam.setUpdatedAt(LocalDateTime.now());
        
        Examination updatedExam = examinationRepository.save(exam);
        log.info("Онош амжилттай нэмэгдлээ. Үзлэгийн ID: {}", dto.getExaminationId());
        return updatedExam;
    }

    @Override
    public void validateDiagnosisDto(DiagnosisDto dto) {
        if (dto.getExaminationId() == null || dto.getExaminationId().isEmpty()) {
            throw new InvalidDataException("Үзлэгийн ID заавал шаардлагатай");
        }
        if (!StringUtils.hasText(dto.getDiagnosis())) {
            throw new InvalidDataException("Онош хоосон байна");
        }
    }
}