package eu.arngrimur.testutils.openpojo;

import com.openpojo.reflection.PojoField;
import com.openpojo.reflection.PojoMethod;
import com.openpojo.reflection.impl.PojoClassImpl;
import eu.arngrimur.utils.validation.ValidateString;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ValidationRegexMustBeValidTest {

    private ValidationRegexMustBeValid validationRegexMustBeValid;

    @Before
    public void setUp() throws Exception {
        validationRegexMustBeValid = new ValidationRegexMustBeValid();
    }

    @Test
    public void invalidRegex() throws Exception {
        try {
            validationRegexMustBeValid.evaluate(new PojoClassImpl(InvalidRegex.class, new ArrayList<PojoField>(), new ArrayList<PojoMethod>()));
            fail("AssertionError should be thrown");
        } catch (AssertionError e){
            assertEquals("[eu.arngrimur.testutils.openpojo.ValidationRegexMustBeValidTest$InvalidRegex.foo] Invalid pattern [[1-2]", e.getMessage());
        }
    }


    @Test
    public void validRegex() throws Exception {
        try {
            validationRegexMustBeValid.evaluate(new PojoClassImpl(ValidRegex.class, new ArrayList<PojoField>(), new ArrayList<PojoMethod>()));
        } catch (AssertionError e){
            fail("AssertionError should be thrown");
        }
    }

    private class InvalidRegex{
        @ValidateString(regex = "[1-2")
        String foo = "w";
    }

    private class ValidRegex{
        @ValidateString(regex = "[a-z]")
        String foo = "w";
    }
}