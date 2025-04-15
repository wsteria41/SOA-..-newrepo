package com.example.examinationservice.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Нийтлэг RuntimeException хүлээж авах
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity<>("Алдаа: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // ResponseStatusException хүлээж авах (сайжруулсан хариу)
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> handleResponseStatusException(ResponseStatusException ex) {
        return new ResponseEntity<>(ex.getMessage(), ex.getStatusCode());
    }

    // Тусгай Exception хүлээж авах боломжтой
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>("Тухайн алдаа: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
