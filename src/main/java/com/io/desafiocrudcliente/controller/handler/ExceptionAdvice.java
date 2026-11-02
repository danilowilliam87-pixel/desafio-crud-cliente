package com.io.desafiocrudcliente.controller.handler;

import com.io.desafiocrudcliente.service.exception.FieldsValidationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.io.desafiocrudcliente.service.exception.ResourceNotFoundException;
import com.io.desafiocrudcliente.service.exception.ResponseError;

import java.time.Instant;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseError> resourceNotFound(ResourceNotFoundException ex, HttpServletRequest httpServlet) {

        ResponseError responseError = new ResponseError(Instant.now(),
                ex.getMessage(),
                404,
                httpServlet.getRequestURI());

        return ResponseEntity.status(404).body(responseError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseError> handleException(MethodArgumentNotValidException ex, HttpServletRequest httpServlet) {

        FieldsValidationException responseError = new FieldsValidationException(Instant.now(),
                ex.getMessage(),
                500,
                httpServlet.getRequestURI());

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            responseError.addError(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.status(422).body(responseError);
    }
}
