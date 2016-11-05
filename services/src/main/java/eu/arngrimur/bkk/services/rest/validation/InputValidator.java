package eu.arngrimur.bkk.services.rest.validation;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import javax.inject.Named;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

@Named
public class InputValidator {

    private Set<String> errors = new HashSet<>();

    public void validate(InputValidation object) throws InputValidationException {
        String methodName = null;
        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method : methods) {
            methodName = method.getName();
            Field field = FieldUtils.getField(object.getClass(), methodName.substring(3, methodName.length()), true);
            parseNumber(object, method, field);
        }
        if (!errors.isEmpty()) {
            throw new InputValidationException(errors);
        }
    }

    private void parseNumber(InputValidation object, Method method, Field field) {
        try {
            ValidateNumber validateNumber = method.getAnnotation(ValidateNumber.class);
            if (validateNumber != null) {
                String fieldValue = (String) field.get(object);
                if (StringUtils.isBlank(fieldValue)) {
                    errors.add(fieldValue + " can not empty.");
                    return;
                }
                if (!StringUtils.isNumeric(fieldValue)) {
                    errors.add(field.getName() + " must be a number.");
                }
            }
        } catch (IllegalAccessException e) {
            errors.add(field.getName() + " does not exist.");
        }
    }
}

