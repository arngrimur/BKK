package eu.arngrimur.bkk.services.rest.validation;

import java.lang.annotation.*;

/**
 * Validates that a string has length and is not
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateString {
    int minLen() default 1;

    int maxLen() default Integer.MAX_VALUE;

    boolean canBeNull() default false;
}
