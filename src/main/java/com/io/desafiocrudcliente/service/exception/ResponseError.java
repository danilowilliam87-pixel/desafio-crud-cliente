package com.io.desafiocrudcliente.service.exception;

import java.time.Instant;

public class ResponseError {

    private Instant instant;
    private String message;
    private Integer statucCode;
    private String path;

    public ResponseError(Instant instant, String message, Integer statucCode, String path) {
        this.instant = instant;
        this.message = message;
        this.statucCode = statucCode;
        this.path = path;
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

    public Integer getStatucCode() {
        return statucCode;
    }

    public void setStatucCode(Integer statucCode) {
        this.statucCode = statucCode;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
