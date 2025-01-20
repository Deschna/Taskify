package org.example.taskify.lib.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.example.taskify.lib.validator.DateOrderValidator;

@Constraint(validatedBy = DateOrderValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DateOrder {
    String message() default "The first date must be earlier than the second date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String firstDateField();

    String secondDateField();
}
