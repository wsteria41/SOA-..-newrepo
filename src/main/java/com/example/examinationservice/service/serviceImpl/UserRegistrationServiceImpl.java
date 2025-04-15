package com.example.examinationservice.service.serviceImpl;

import com.example.examinationservice.builder.UserBuilder;
import com.example.examinationservice.dto.UserDto;
import com.example.examinationservice.entity.User;
import com.example.examinationservice.repository.UserRepository;
import com.example.examinationservice.service.UserRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
    private final UserRepository userRepository;

    @Override
    public String register(UserDto dto) {
        try {
            User user = UserBuilder.fromDto(dto);
            return userRepository.save(user).getId();
        } catch (RuntimeException e) {
            throw new RuntimeException("Хэрэглэгч бүртгэхэд алдаа гарлаа: " + e.getMessage(), e);
        }
    }
}
