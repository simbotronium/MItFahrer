package de.hsrm.mi.web.projekt.validators;

import java.util.regex.Pattern;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GutesPasswortValidator implements ConstraintValidator<GutesPasswort, String>{
    protected String passwort;
    @Override
    public void initialize(GutesPasswort annotationGutesPasswort) {
        // this.passwort = annotationGutesPasswort.value();
    }

    @Override
    public boolean isValid(String input, ConstraintValidatorContext context) {
        return hasSiebzehn(input) || has17(input) || input == null || input.isEmpty();
    }
    public boolean hasSiebzehn(String value){
        return Pattern.compile("siebzehn", Pattern.CASE_INSENSITIVE)
                        .matcher(value)
                        .find();
    }
    public boolean has17(String value){
        return Pattern.compile("17")
                        .matcher(value)
                        .find();
    }
}
