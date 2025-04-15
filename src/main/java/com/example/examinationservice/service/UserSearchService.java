package com.example.examinationservice.service;

import com.example.examinationservice.dto.UserDto;

public interface UserSearchService {
    UserDto findByNationalId(String nationalId);
}
