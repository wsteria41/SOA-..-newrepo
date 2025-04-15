package com.example.examinationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private String id;
    private String name;
    private String nationalId;
    private LocalDate birthDate;

    public UserDto() {

    }
}
