package org.example.taskify.lib.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import org.example.taskify.lib.annotation.DateOrder;
import org.springframework.beans.BeanWrapperImpl;

public class DateOrderValidator implements ConstraintValidator<DateOrder, Object> {
    private String firstDateField;
    private String secondDateField;

    @Override
    public void initialize(DateOrder constraintAnnotation) {
        this.firstDateField = constraintAnnotation.firstDateField();
        this.secondDateField = constraintAnnotation.secondDateField();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        LocalDate firstDate = (LocalDate) new BeanWrapperImpl(value)
                .getPropertyValue(firstDateField);
        LocalDate secondDate = (LocalDate) new BeanWrapperImpl(value)
                .getPropertyValue(secondDateField);

        if (firstDate == null || secondDate == null) {
            return true;
        }

        return firstDate.isBefore(secondDate);
    }
}
