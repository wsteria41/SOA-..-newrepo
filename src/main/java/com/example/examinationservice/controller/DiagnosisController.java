package com.example.examinationservice.controller;

import com.example.examinationservice.dto.DiagnosisDto;
import com.example.examinationservice.service.DiagnosisService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

// ------------- ОНОШ ТАВИХ -------------

@RestController
@AllArgsConstructor
@RequestMapping("/api/diagnosis")
public class DiagnosisController {

    private final DiagnosisService diagnosisService;

    @PostMapping("/add")
    public ResponseEntity<String> addDiagnosis(@RequestBody DiagnosisDto dto) {
        diagnosisService.addDiagnosis(dto);
        return ResponseEntity.ok("Онош амжилттай нэмэгдлээ.");
    }
}
