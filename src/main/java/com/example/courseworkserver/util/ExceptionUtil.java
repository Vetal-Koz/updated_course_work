package com.example.courseworkserver.util;

import lombok.Getter;

@Getter
public enum ExceptionUtil {
    ENTITY_NOT_FOUND("Entity doesn't exist");

    private String message;
    private ExceptionUtil(String message) {
        this.message = message;
    }
}
