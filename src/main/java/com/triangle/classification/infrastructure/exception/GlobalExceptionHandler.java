package com.triangle.classification.infrastructure.exception;

import com.triangle.classification.usercase.exception.InvalidCredentialsException;
import com.triangle.classification.infrastructure.exception.entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        final Map<String, String> messages = ex.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
        ErrorResponse errorResponse = new ErrorResponse(messages, HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler({AuthenticationException.class, InvalidCredentialsException.class})
    public ResponseEntity<ErrorResponse> handleAuthenticationJwt() {
        final Map<String, String> messages = Map.of("message","user not authorized");
        ErrorResponse errorResponse = new ErrorResponse(messages, HttpStatus.FORBIDDEN.value(),
                HttpStatus.FORBIDDEN.getReasonPhrase());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


}
