package com.security.hellosecurity.exception.domain.dto;

public class DuplicatedMember extends ExceptionFactory {
    private static final String MESSAGE = "중복된 아이디입니다.";

    public DuplicatedMember() {
        super(MESSAGE);
    }

    public DuplicatedMember(String fieldName, String message) {
        super(MESSAGE);
        addValidation(fieldName, message);
    }

    @Override
    public int getStatusCode() {
        return 409;
    }
}
