package com.example.examinationservice.controller;

import com.example.examinationservice.dto.UserDto;
import com.example.examinationservice.service.UserRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// ------------- ХЭРЭГЛЭГЧ БҮРТГЭХ -------------

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserRegistrationController {
    private final UserRegistrationService userRegistrationService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto dto) {
        return ResponseEntity.ok(userRegistrationService.register(dto));
    }
}
