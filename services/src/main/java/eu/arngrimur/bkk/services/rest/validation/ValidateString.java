package eu.arngrimur.bkk.services.rest.validation;

import java.lang.annotation.*;

/**
 * Validates that a string has length between minLen and maxLen inclusive , i.e., minLen <= string.lenght() <= maxLen.
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateString {
    /**
     * Minimum length of a string
     */
    int minLen() default 1;

    /**
     * Maximum length of a string
     */
    int maxLen() default Integer.MAX_VALUE;

    /**
     * Regular expression that string must follow
     */
    String regex() default ".+";
}
