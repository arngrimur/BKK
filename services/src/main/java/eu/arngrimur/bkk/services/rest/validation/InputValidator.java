package eu.arngrimur.bkk.services.rest.validation;

import javax.inject.Named;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

@Named
public class InputValidator {

    private Set<String> errors = new HashSet<>();

    public void validate(InputValidation object) throws InputValidationException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            validate(object, field);
        }
        if (!errors.isEmpty()) {
            throw new InputValidationException(errors);
        }
    }

    private void validate(InputValidation object, Field field) {
        try {
            ValidateString validateString = field.getAnnotation(ValidateString.class);
            if (validateString != null) {
                field.setAccessible(true);
                String fieldValue = (String) field.get(object);
                if (null == fieldValue) {
                    errors.add(field.getName() + " can not be null");
                    return;
                }
                if (fieldValue.length() < validateString.minLen()) {
                    errors.add(fieldValue + " must have at least " + validateString.minLen() + " characters");
                }
                if (fieldValue.length() > validateString.maxLen()) {
                    errors.add(fieldValue + " can not be longer than " + validateString.maxLen() + " characters");
                }

                if (!fieldValue.matches(validateString.regex())) {
                    errors.add(fieldValue + " does not satisfy regexp '" + validateString.regex() + "'");
                }
            }
        } catch (IllegalAccessException e) {
            errors.add(field.getName() + " does not exist.");
        }
    }
}

