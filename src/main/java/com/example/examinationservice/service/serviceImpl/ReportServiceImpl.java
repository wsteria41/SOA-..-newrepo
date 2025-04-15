package com.example.examinationservice.service.serviceImpl;

import com.example.examinationservice.dto.ReportDto;
import com.example.examinationservice.entity.Examination;
import com.example.examinationservice.helper.ExaminationHelper;
import com.example.examinationservice.repository.ExaminationRepository;
import com.example.examinationservice.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ReportServiceImpl implements ReportService {
    private final ExaminationRepository examinationRepository;

    @Override
    public void generateReport(ReportDto dto) {
        try {
            Examination exam = examinationRepository.findById(dto.getExaminationId())
                    .orElseThrow(() -> new RuntimeException("Эмчилгээний мэдээлэл олдсонгүй"));
            ExaminationHelper.updateReport(exam, dto.getReport());
            examinationRepository.save(exam);
        } catch (RuntimeException e) {
            throw new RuntimeException("Тайлан гаргах үед алдаа гарлаа: " + e.getMessage(), e);
        }
    }
}
