package de.hsrm.mi.web.projekt.validators;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GutesPasswortValidator.class)
public @interface GutesPasswort {
    String message() default "{gutespasswort.fehler}";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default{};
}
