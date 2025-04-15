package com.example.examinationservice.service.serviceImpl;

import com.example.examinationservice.dto.PrescriptionDto;
import com.example.examinationservice.entity.Examination;
import com.example.examinationservice.helper.ExaminationHelper;
import com.example.examinationservice.repository.ExaminationRepository;
import com.example.examinationservice.service.PrescriptionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService {
    private final ExaminationRepository examinationRepository;

    @Override
    public void addPrescription(PrescriptionDto dto) {
        try {
            Examination exam = examinationRepository.findById(dto.getExaminationId())
                    .orElseThrow(() -> new RuntimeException("Эмчилгээний мэдээлэл олдсонгүй"));
            ExaminationHelper.updatePrescription(exam, dto.getPrescription());
            examinationRepository.save(exam);
        } catch (RuntimeException e) {
            throw new RuntimeException("Эмчилгээний заавар нэмэхэд алдаа гарлаа: " + e.getMessage(), e);
        }
    }
}




