package com.etiya.common.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NationalIdValidator implements ConstraintValidator<NationalId, String> {

    @Override
    public boolean isValid(String natId, ConstraintValidatorContext context) {

        if (natId == null || natId.isBlank()) {
            return false;
        }
        if (!natId.matches("^[0-9]{11}$")) {
            return false;
        }
        char lastChar = natId.charAt(natId.length() - 1);
        int lastDigit = Character.getNumericValue(lastChar);
        return lastDigit % 2 == 0;

    }
}
