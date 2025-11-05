package com.etiya.common.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class StatusValidator implements ConstraintValidator<Status, String> {

    private static final Set<String> VALID_STATUSES = Set.of("ACTIVE", "SUSPENDED", "CLOSED");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.trim().isEmpty()) {
            return false;
        }
        return VALID_STATUSES.contains(value.toUpperCase());
    }
}
