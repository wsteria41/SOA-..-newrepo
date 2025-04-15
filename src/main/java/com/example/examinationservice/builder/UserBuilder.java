package com.example.examinationservice.builder;

import com.example.examinationservice.dto.UserDto;
import com.example.examinationservice.entity.User;

public class UserBuilder {
    public static User fromDto(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setNationalId(dto.getNationalId());
        user.setBirthDate(dto.getBirthDate());
        return user;
    }

    public static UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setName(user.getName());
        dto.setNationalId(user.getNationalId());
        dto.setBirthDate(user.getBirthDate());
        return dto;
    }
}
