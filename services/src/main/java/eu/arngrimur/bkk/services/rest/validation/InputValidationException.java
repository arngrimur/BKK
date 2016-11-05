package eu.arngrimur.bkk.services.rest.validation;

import java.util.Collections;
import java.util.Set;

public class InputValidationException extends Exception {
    private Set<String> errors;

    public InputValidationException(Set<String> errors) {
        this.errors = Collections.unmodifiableSet(errors);
    }

    public Set<String> getErrors() {
        return errors;
    }
}
