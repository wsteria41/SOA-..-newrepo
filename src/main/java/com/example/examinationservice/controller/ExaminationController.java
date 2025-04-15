package com.example.examinationservice.controller;

import com.example.examinationservice.dto.ExaminationDto;
import com.example.examinationservice.entity.Examination;
import com.example.examinationservice.service.ExaminationService;
import lombok.RequiredArgsConstructor;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<Examination> getExaminationById(@PathVariable String id) {
        return ResponseEntity.ok(examinationService.getExaminationById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Examination>> getExaminationsByUser(@PathVariable String userId) {
        return ResponseEntity.ok(examinationService.getExaminationsByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Examination> updateExamination(
            @PathVariable String id,
            @RequestBody ExaminationDto dto) {
        return ResponseEntity.ok(examinationService.updateExamination(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExamination(@PathVariable String id) {
        examinationService.deleteExamination(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Examination>> getAllExaminations() {
        return ResponseEntity.ok(examinationService.getAllExaminations());
    }
}
