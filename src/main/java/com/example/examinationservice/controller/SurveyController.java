package com.example.examinationservice.controller;

import com.example.examinationservice.dto.SurveyDto;
import com.example.examinationservice.service.SurveyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// ------------- АСУУМЖ БӨГЛӨХ -------------

@RestController
@AllArgsConstructor
@RequestMapping("/api/survey")
public class SurveyController {
    private final SurveyService surveyService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitSurvey(@RequestBody SurveyDto dto) {
        surveyService.submitSurvey(dto);
        return ResponseEntity.ok("Асуумж амжилттай бөглөгдлөө.");
    }
}
