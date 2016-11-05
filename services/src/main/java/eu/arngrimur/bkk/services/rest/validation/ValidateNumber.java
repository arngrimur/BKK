package eu.arngrimur.bkk.services.rest.validation;

import java.lang.annotation.*;

/**
 * Validates that a string is a number.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ValidateNumber {

}
