package com.example.examinationservice.service.serviceImpl;

import com.example.examinationservice.dto.ExaminationDto;
import com.example.examinationservice.entity.Examination;
import com.example.examinationservice.exception.ExaminationNotFoundException;
import com.example.examinationservice.exception.InvalidDataException;
import com.example.examinationservice.repository.ExaminationRepository;
import com.example.examinationservice.service.ExaminationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExaminationServiceImpl implements ExaminationService {

    private final ExaminationRepository examinationRepository;

    @Override
    @Transactional
    public Examination createExamination(ExaminationDto dto) {
        validateExaminationDto(dto);
        
        Examination examination = Examination.builder()
            .userId(dto.getUserId())
            .diagnosis(dto.getDiagnosis())
            .survey(dto.getSurvey())
            .treatmentInstruction(dto.getTreatmentInstruction())
            .prescription(dto.getPrescription())
            .report(dto.getReport())
            .bodyTemperature(dto.getBodyTemperature())
            .heartRate(dto.getHeartRate())
            .respiratoryRate(dto.getRespiratoryRate())
            .bloodPressure(dto.getBloodPressure())
            .vitalSignsMeasuredAt(LocalDateTime.now())
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();

        Examination savedExam = examinationRepository.save(examination);
        log.info("Created examination with ID: {}", savedExam.getId());
        return savedExam;
    }

    @Override
    public Examination getExaminationById(String id) {
        return examinationRepository.findById(id)
            .orElseThrow(() -> new ExaminationNotFoundException(
                "Үзлэгийн мэдээлэл олдсонгүй. ID: " + id));
    }

    @Override
    public List<Examination> getExaminationsByUserId(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            throw new InvalidDataException("Хэрэглэгчийн ID хоосон байна");
        }
        List<Examination> exams = examinationRepository.findByUserId(userId);
        if (exams.isEmpty()) {
            throw new ExaminationNotFoundException(
                "Хэрэглэгчийн үзлэгийн мэдээлэл олдсонгүй. ID: " + userId);
        }
        return exams;
    }

    @Override
    @Transactional
    public Examination updateExamination(String id, ExaminationDto dto) {
        Examination existing = examinationRepository.findById(id)
            .orElseThrow(() -> new ExaminationNotFoundException(
                "Үзлэгийн мэдээлэл олдсонгүй. ID: " + id));

        if (dto.getDiagnosis() != null) existing.setDiagnosis(dto.getDiagnosis());
        if (dto.getSurvey() != null) existing.setSurvey(dto.getSurvey());
        if (dto.getTreatmentInstruction() != null) 
            existing.setTreatmentInstruction(dto.getTreatmentInstruction());
        if (dto.getPrescription() != null) existing.setPrescription(dto.getPrescription());
        if (dto.getReport() != null) existing.setReport(dto.getReport());
        if (dto.getBodyTemperature() != null) 
            existing.setBodyTemperature(dto.getBodyTemperature());
        if (dto.getHeartRate() != null) existing.setHeartRate(dto.getHeartRate());
        if (dto.getRespiratoryRate() != null) 
            existing.setRespiratoryRate(dto.getRespiratoryRate());
        if (dto.getBloodPressure() != null) 
            existing.setBloodPressure(dto.getBloodPressure());
        
        existing.setUpdatedAt(LocalDateTime.now());
        
        return examinationRepository.save(existing);
    }

    @Override
    @Transactional
    public void deleteExamination(String id) {
        if (!examinationRepository.existsById(id)) {
            throw new ExaminationNotFoundException(
                "Устгах үзлэгийн мэдээлэл олдсонгүй. ID: " + id);
        }
        examinationRepository.deleteById(id);
        log.info("Deleted examination with ID: {}", id);
    }

    @Override
    public List<Examination> getAllExaminations() {
        return examinationRepository.findAll();
    }

    private void validateExaminationDto(ExaminationDto dto) {
        if (dto.getUserId() == null || dto.getUserId().trim().isEmpty()) {
            throw new InvalidDataException("Хэрэглэгчийн ID заавал шаардлагатай");
        }
        
        if (dto.getBodyTemperature() != null && 
            (dto.getBodyTemperature() < 25 || dto.getBodyTemperature() > 45)) {
            throw new InvalidDataException("Биеийн хэвийн хэмжээ буруу (25-45 хэм)");
        }
        
        if (dto.getHeartRate() != null && 
            (dto.getHeartRate() < 30 || dto.getHeartRate() > 200)) {
            throw new InvalidDataException("Зүрхний цохилтын хэвийн хэмжээ буруу (30-200)");
        }
        
        if (dto.getRespiratoryRate() != null && 
            (dto.getRespiratoryRate() < 5 || dto.getRespiratoryRate() > 60)) {
            throw new InvalidDataException("Амьсгалын хэвийн хэмжээ буруу (5-60)");
        }
    }
}