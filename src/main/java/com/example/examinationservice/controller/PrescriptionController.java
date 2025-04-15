package com.example.examinationservice.controller;

import com.example.examinationservice.dto.PrescriptionDto;
import com.example.examinationservice.service.PrescriptionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// ------------- ЭМИЙН ЖОР БИЧИХ -------------

@RestController
@AllArgsConstructor
@RequestMapping("/api/prescription")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @PostMapping("/add")
    public ResponseEntity<String> addPrescription(@RequestBody PrescriptionDto dto) {
        prescriptionService.addPrescription(dto);
        return ResponseEntity.ok("Жор амжилттай нэмэгдлээ.");
    }
}

