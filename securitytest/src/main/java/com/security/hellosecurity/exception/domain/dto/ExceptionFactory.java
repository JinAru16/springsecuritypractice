package com.security.hellosecurity.exception.domain.dto;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class ExceptionFactory extends RuntimeException{
    public final Map<String, String> validation = new HashMap<>();

    public ExceptionFactory(String message) {
        super(message);
    }

    public ExceptionFactory(String message, Throwable cause){
        super(message, cause);
    }

    public abstract int getStatusCode();

    public void addValidation(String fieldName, String message) {
        validation.put(fieldName, message);
    }

}
