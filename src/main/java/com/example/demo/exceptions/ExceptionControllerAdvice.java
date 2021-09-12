package com.example.demo.exceptions;

import com.example.demo.shared.model.CaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author bariskantar
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<CaseResponse> handleNotFound(
            RuntimeException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CaseResponse<>(ex.getMessage(),null));
    }

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<CaseResponse> handleBadRequest(
            RuntimeException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CaseResponse<>(ex.getMessage(),null));
    }

    @ExceptionHandler(value = {DuplicateException.class})
    public ResponseEntity<CaseResponse> handleDuplicate(
            RuntimeException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new CaseResponse<>(ex.getMessage(),null));
    }
}
