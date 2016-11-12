package eu.arngrimur.bkk.services.rest.parameters;

import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import eu.arngrimur.bkk.services.rest.validation.InputValidation;
import eu.arngrimur.testutils.openpojo.ValidationRegexMustBeValid;
import eu.arngrimur.testutils.openpojo.ImplentsInterfaceFilter;
import org.junit.Test;

public class OpenPojoInputValidationTest {
    private static final String packageName = "eu.arngrimur.bkk.services.rest.parameters";


    @Test
    public void validateRegex() throws Exception {
        Validator validator = ValidatorBuilder.create().with(new ValidationRegexMustBeValid()).build();
        validator.validate(packageName, new ImplentsInterfaceFilter<InputValidation>(InputValidation.class));
    }
}
