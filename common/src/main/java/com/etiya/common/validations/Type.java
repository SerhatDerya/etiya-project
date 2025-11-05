package com.etiya.common.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TypeValidator.class)
@Documented
public @interface Type {

    String message() default "Invalid billing account type";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
