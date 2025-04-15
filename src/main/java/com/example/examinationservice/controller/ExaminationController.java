package com.example.examinationservice.controller;

import com.example.examinationservice.dto.ExaminationDto;
import com.example.examinationservice.service.ExaminationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/examination")
public class ExaminationController {

    private final ExaminationService examinationService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody ExaminationDto dto) {
        examinationService.createExamination(dto);
        return ResponseEntity.ok("Үзлэг амжилттай бүртгэгдлээ.");
    }
}
