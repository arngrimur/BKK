package eu.arngrimur.bkk.services.rest.validation;

import org.junit.Before;
import org.junit.Test;

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
    public void numberIsValidatedOk() {
        try {
            inputValidator.validate(new NumberTest("123"));
        } catch (InputValidationException e) {
            fail("No exception shall be thrown!");
        }
    }

    @Test
    public void notANumber() {
        try {
            inputValidator.validate(new NumberTest("foo"));
            fail("Exception shall be thrown!");
        } catch (InputValidationException e) {
            assertEquals("aNumber must be a number.", e.getErrors().iterator().next());
        }
    }


    private class NumberTest implements InputValidation {
        private String aNumber;


        public NumberTest(String aNumber) {
            this.aNumber = aNumber;
        }

        @ValidateNumber
        public void setaNumber(String aNumber){
            this.aNumber = aNumber;
        }
    }
}