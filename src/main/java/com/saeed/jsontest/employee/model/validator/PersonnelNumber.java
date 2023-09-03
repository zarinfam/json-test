package com.saeed.jsontest.employee.model.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;


@Documented
@Constraint(validatedBy = PersonnelNumberValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonnelNumber {


    String message() default "{PersonnelNumber}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
