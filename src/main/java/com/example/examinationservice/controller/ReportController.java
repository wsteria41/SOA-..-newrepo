package com.example.examinationservice.controller;

import com.example.examinationservice.dto.ReportDto;
import com.example.examinationservice.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// ------------- ТАЙЛАН ГАРГАХ -------------

@RestController
@AllArgsConstructor
@RequestMapping("/api/report")
public class ReportController {
    private final ReportService reportService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateReport(@RequestBody ReportDto dto) {
        reportService.generateReport(dto);
        return ResponseEntity.ok("Тайлан амжилттай гаргалаа.");
    }
}
