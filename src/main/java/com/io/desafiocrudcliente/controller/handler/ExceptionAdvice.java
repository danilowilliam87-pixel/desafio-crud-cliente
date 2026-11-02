package com.io.desafiocrudcliente.controller.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

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

}
