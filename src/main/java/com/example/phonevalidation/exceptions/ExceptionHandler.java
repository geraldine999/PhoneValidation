package com.example.phonevalidation.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@ControllerAdvice
@RestController
public class ExceptionHandler extends ResponseEntityExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exceptionHandler(Exception e, WebRequest webRequest){
        ExceptionResponse response = new ExceptionResponse(e.getMessage(), webRequest.getDescription(false),HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String myErrorMessage = null;
        List<ObjectError> exceptionMessages = ex.getBindingResult().getAllErrors();
        for (ObjectError error : exceptionMessages) {
            if (Objects.requireNonNull(error.getDefaultMessage()).regionMatches(0, "!:", 0, 2)) {
                myErrorMessage = error.getDefaultMessage();
                break;
            }
        }
        if(myErrorMessage == null){
            myErrorMessage = exceptionMessages.get(0).getDefaultMessage();
        }

            ExceptionResponse response = new ExceptionResponse(myErrorMessage, request.getDescription(false), HttpStatus.BAD_REQUEST, LocalDateTime.now());
            return new ResponseEntity<>(response, response.getStatus());
        }

}




