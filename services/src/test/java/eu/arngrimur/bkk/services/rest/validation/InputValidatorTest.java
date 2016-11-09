package eu.arngrimur.bkk.services.rest.validation;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;

import static org.junit.Assert.*;

/**
 * Created by arngrimur on 11/5/16.
 */
public class InputValidatorTest {

    private InputValidator inputValidator;

    @Before
    public void setup() throws Exception {
        inputValidator = new InputValidator();
    }

    @Test
    public void okRexExpValidation() {
        try {
            inputValidator.validate(new InputValidation() {
                @ValidateString(regex = "[0-9]+")
                private String number = "123";
            });
        } catch (InputValidationException e) {
            fail("No exception shall be thrown!");
        }
    }

    @Test
    public void fooIsNotANumber() {
        try {
            inputValidator.validate(new InputValidation() {
                @ValidateString(regex = "[0-9]+")
                private String number = "foo";
            });
            fail("Exception shall be thrown!");
        } catch (InputValidationException e) {
            assertEquals(1, e.getErrors().size());
            assertEquals("foo does not satisfy regexp '[0-9]+'", e.getErrors().iterator().next());
        }
    }

    @Test
    public void canNotBeNull() {
        try {
            inputValidator.validate(new InputValidation() {
                @ValidateString()
                private String number = null;
            });
            fail("Exception shall be thrown!");
        } catch (InputValidationException e) {
            assertEquals(1, e.getErrors().size());
            assertEquals("number can not be null", e.getErrors().iterator().next());
        }
    }

    @Test
    public void mustExceedDefaultMinLen() {
        try {
            inputValidator.validate(new InputValidation() {
                @ValidateString
                private String number = "";
            });
            fail("Exception shall be thrown!");
        } catch (InputValidationException e) {
            assertEquals(2, e.getErrors().size());
            List<String> sorted = sortErrors(e);

            assertEquals(" does not satisfy regexp '.+'", sorted.get(0));
            assertEquals(" must have at least 1 characters", sorted.get(1));
        }
    }

    private List<String> sortErrors(InputValidationException e) {
        List<String> sorted = new ArrayList<>();
        sorted.addAll(e.getErrors());
        Collections.sort(sorted);
        return sorted;
    }


    @Test
    public void mustExceedCustomMinLen() {
        try {
            inputValidator.validate(new InputValidation() {
                @ValidateString(minLen = 2)
                private String number = "1";
            });
            fail("Exception shall be thrown!");
        } catch (InputValidationException e) {
            assertEquals(1, e.getErrors().size());
            assertEquals("1 must have at least 2 characters", e.getErrors().iterator().next());
        }
    }

    @Test
    public void canNotExceedCustomMaxLen() {
        try {
            inputValidator.validate(new InputValidation() {
                @ValidateString(maxLen = 2)
                private String number = "123";
            });
            fail("Exception shall be thrown!");
        } catch (InputValidationException e) {
            assertEquals(1, e.getErrors().size());
            assertEquals("123 can not be longer than 2 characters", e.getErrors().iterator().next());
        }
    }

}