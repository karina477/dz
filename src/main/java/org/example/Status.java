package org.example;

import java.util.Arrays;

public enum Status {
    PASSED, FAILED, SKIPPED;

    public static boolean isValid(String value) {
        if (value == null) {
            return false;
        }
        return Arrays.stream(values())
                .anyMatch(status -> status.name().equalsIgnoreCase(value.trim()));
    }
}
