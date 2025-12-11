package com.backend.enums;

import lombok.Getter;

@Getter
public enum Status {
    PENDING("Pending"),
    FINISHED("Finished");

    private final String value;

    Status(String value) {
        this.value = value;
    }
}
