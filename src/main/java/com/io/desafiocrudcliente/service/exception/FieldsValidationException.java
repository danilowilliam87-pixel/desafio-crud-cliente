package com.io.desafiocrudcliente.service.exception;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class FieldsValidationException extends ResponseError{

    private final List<FieldMessageError>messageErrorList = new ArrayList<>();

    public FieldsValidationException(Instant instant, String message, Integer statucCode, String path) {
            super(instant, message, statucCode, path);
    }

    public void addError(String fieldName, String message) {
        messageErrorList.add(new FieldMessageError(fieldName, message));
    }

    public List<FieldMessageError> getMessageErrorList() {
        return messageErrorList;
    }
}
