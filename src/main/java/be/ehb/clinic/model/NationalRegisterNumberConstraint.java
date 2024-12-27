package be.ehb.clinic.model;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NationalRegisterNumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NationalRegisterNumberConstraint {

    String message() default "Invalid National Register Number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}

