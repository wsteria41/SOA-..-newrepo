package com.example.examinationservice.service.serviceImpl;

import com.example.examinationservice.dto.TreatmentInstructionDto;
import com.example.examinationservice.entity.Examination;
import com.example.examinationservice.helper.ExaminationHelper;
import com.example.examinationservice.repository.ExaminationRepository;
import com.example.examinationservice.service.TreatmentInstructionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TreatmentInstructionServiceImpl implements TreatmentInstructionService {
    private final ExaminationRepository examinationRepository;

    @Override
    public void addInstruction(TreatmentInstructionDto dto) {
        try {
            Examination exam = examinationRepository.findById(dto.getExaminationId())
                    .orElseThrow(() -> new RuntimeException("Эмчилгээний мэдээлэл олдсонгүй"));
            ExaminationHelper.updateInstruction(exam, dto.getInstruction());
            examinationRepository.save(exam);
        } catch (RuntimeException e) {
            throw new RuntimeException("Эмчилгээний заавар нэмэхэд алдаа гарлаа: " + e.getMessage(), e);
        }
    }
}
