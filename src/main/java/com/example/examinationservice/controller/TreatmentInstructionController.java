package com.example.examinationservice.controller;

import com.example.examinationservice.dto.TreatmentInstructionDto;
import com.example.examinationservice.service.TreatmentInstructionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// ------------- ЭМЧИЛГЭЭНИЫ ЗААВАР БИЧИХ -------------

@RestController
@AllArgsConstructor
@RequestMapping("/api/instruction")
public class TreatmentInstructionController {
    private final TreatmentInstructionService treatmentInstructionService;

    @PostMapping("/add")
    public ResponseEntity<String> addInstruction(@RequestBody TreatmentInstructionDto dto) {
        treatmentInstructionService.addInstruction(dto);
        return ResponseEntity.ok("Эмчилгээний заавар амжилттай нэмэгдлээ.");
    }

}
