package com.example.examinationservice.exception;

public class ExaminationNotFoundException extends RuntimeException {
    public ExaminationNotFoundException(String message) {
        super(message);
    }
}