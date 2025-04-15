package com.example.examinationservice.service.serviceImpl;

import com.example.examinationservice.builder.UserBuilder;
import com.example.examinationservice.dto.UserDto;
import com.example.examinationservice.repository.UserRepository;
import com.example.examinationservice.service.UserSearchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserSearchServiceImpl implements UserSearchService {
    private final UserRepository userRepository;

    @Override
    public UserDto findByNationalId(String nationalId) {
        try {
            return userRepository.findByNationalId(nationalId)
                    .map(UserBuilder::toDto)
                    .orElseThrow(() -> new RuntimeException("Хэрэглэгч олдсонгүй"));
        } catch (RuntimeException e) {
            throw new RuntimeException("Хэрэглэгч хайх үед алдаа гарлаа: " + e.getMessage(), e);
        }
    }
}
