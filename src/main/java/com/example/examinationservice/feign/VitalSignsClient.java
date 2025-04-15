package com.example.examinationservice.feign;

import com.example.examinationservice.dto.VitalSignsDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

@Component
public class VitalSignsClient {
    private final RestTemplate restTemplate;

    public VitalSignsClient(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public VitalSignsDto getVitalSigns(Long userId) {
        return restTemplate.getForObject(
                "http://vitalsigns-service/api/v1/vitalsigns/" + userId,
                VitalSignsDto.class
        );
    }
}
