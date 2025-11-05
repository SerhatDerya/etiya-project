package com.etiya.common.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StatusValidator.class)
@Documented
public @interface Status {

    String message() default "Invalid billing account status";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
