package com.backend.enums;

import lombok.Getter;

@Getter
public enum Priority {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    private final int value;

    Priority(int value) {
        this.value = value;
    }
}
