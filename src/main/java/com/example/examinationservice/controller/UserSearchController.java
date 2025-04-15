package com.example.examinationservice.controller;

import com.example.examinationservice.dto.UserDto;
import com.example.examinationservice.service.UserSearchService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// ------------- ХЭРЭГЛЭГЧ ХАЙХ -------------

@RestController
@AllArgsConstructor
@RequestMapping("/api/find-user")
public class UserSearchController {
    private final UserSearchService userSearchService;

    @GetMapping("/{nationalId}")
    public ResponseEntity<UserDto> findUser(@PathVariable String nationalId) {
        return ResponseEntity.ok(userSearchService.findByNationalId(nationalId));
    }
}
