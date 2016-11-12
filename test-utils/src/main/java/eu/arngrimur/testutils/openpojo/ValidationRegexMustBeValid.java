package eu.arngrimur.testutils.openpojo;

import com.openpojo.reflection.PojoClass;
import com.openpojo.validation.affirm.Affirm;
import com.openpojo.validation.rule.Rule;
import eu.arngrimur.utils.validation.ValidateString;

import java.lang.reflect.Field;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class ValidationRegexMustBeValid implements Rule {
    @Override
    public void evaluate(PojoClass pojoClass) {
        Field[] fields = pojoClass.getClazz().getDeclaredFields();
        for (Field field : fields) {
                ValidateString annotation = field.getAnnotation(ValidateString.class);
                if (annotation != null) {
            try {
                    Pattern.compile(annotation.regex());
                } catch(PatternSyntaxException e){
                    Affirm.fail(String.format("[%s.%s] Invalid pattern [%s]", pojoClass.getName(), field.getName(), annotation.regex()));
                }
            }
        }
    }
}
