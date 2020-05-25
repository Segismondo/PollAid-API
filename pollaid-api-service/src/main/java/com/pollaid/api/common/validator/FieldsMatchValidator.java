package com.pollaid.api.common.validator;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldsMatchValidator implements ConstraintValidator<FieldsMatch, Object> {

    private String field;
    private String fieldMatch;

    @Override
    public void initialize(FieldsMatch fieldsMatch) {
        this.field = fieldsMatch.field();
        this.fieldMatch = fieldsMatch.fieldMatch();
    }

    @Override
    public boolean isValid(final Object value, ConstraintValidatorContext context) {

        Object field = new BeanWrapperImpl(value)
                .getPropertyValue(this.field);
        Object fieldMatch = new BeanWrapperImpl(value)
                .getPropertyValue(this.fieldMatch);

            return field.equals(fieldMatch);
    }
}
