package com.io.desafiocrudcliente.service.exception;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.Instant;

@JsonPropertyOrder({"instant", "message", "statusCode", "path"})
public class ResponseError {

    private Instant instant;
    private String message;
    private Integer statusCode;
    private String path;

    public ResponseError(Instant instant, String message, Integer statucCode, String path) {
        this.instant = instant;
        this.message = message;
        this.statusCode = statucCode;
        this.path = path;
    }

    public ResponseError() {

    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
