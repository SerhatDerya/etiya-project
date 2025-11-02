package com.etiya.common.validations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NationalIdValidator.class)
@Documented
public @interface NationalId {
    String message() default "National Id must be 11 number and last digit must be even";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
