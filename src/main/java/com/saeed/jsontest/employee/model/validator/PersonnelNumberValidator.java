package com.saeed.jsontest.employee.model.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PersonnelNumberValidator implements ConstraintValidator<PersonnelNumber, String> {

    @Override
    public void initialize(PersonnelNumber personnelNumber) {
    }

    @Override
    public boolean isValid(String personnelNumber, ConstraintValidatorContext ctx) {
        //A stupid validation
        return personnelNumber != null && personnelNumber.contains("-");
    }

}
