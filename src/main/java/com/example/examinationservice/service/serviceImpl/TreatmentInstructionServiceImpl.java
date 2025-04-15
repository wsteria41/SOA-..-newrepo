package com.example.examinationservice.service.serviceImpl;

import com.example.examinationservice.dto.TreatmentInstructionDto;
import com.example.examinationservice.entity.Examination;
import com.example.examinationservice.exception.ExaminationNotFoundException;
import com.example.examinationservice.exception.InvalidDataException;
import com.example.examinationservice.helper.ExaminationHelper;
import com.example.examinationservice.repository.ExaminationRepository;
import com.example.examinationservice.service.TreatmentInstructionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class TreatmentInstructionServiceImpl implements TreatmentInstructionService {

    private final ExaminationRepository examinationRepository;

    @Override
    @Transactional
    public Examination addInstruction(TreatmentInstructionDto dto) {
        validateTreatmentInstructionDto(dto);
        
        Examination exam = examinationRepository.findById(dto.getExaminationId())
                .orElseThrow(() -> new ExaminationNotFoundException(
                    "Үзлэгийн мэдээлэл олдсонгүй. ID: " + dto.getExaminationId()));
        
        ExaminationHelper.updateInstruction(exam, dto.getInstruction());
        exam.setUpdatedAt(LocalDateTime.now());
        
        Examination updatedExam = examinationRepository.save(exam);
        log.info("Эмчилгээний заавар амжилттай нэмэгдлээ. Үзлэгийн ID: {}", dto.getExaminationId());
        return updatedExam;
    }

    public void validateTreatmentInstructionDto(TreatmentInstructionDto dto) {
        if (dto.getExaminationId() == null || dto.getExaminationId().isEmpty()) {
            throw new InvalidDataException("Үзлэгийн ID заавал шаардлагатай");
        }
        if (!StringUtils.hasText(dto.getInstruction())) {
            throw new InvalidDataException("Эмчилгээний заавар хоосон байна");
        }
    }
}