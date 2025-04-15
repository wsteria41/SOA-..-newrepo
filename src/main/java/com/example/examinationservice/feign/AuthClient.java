package com.example.examinationservice.feign;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthClient {
    private final RestTemplate restTemplate;

    public AuthClient(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public boolean isAuthorized(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Boolean> response = restTemplate.exchange(
                "http://auth-service/api/v1/auth/check",
                HttpMethod.GET,
                entity,
                Boolean.class
        );
        return response.getBody();
    }
}
