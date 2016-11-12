package eu.arngrimur.testutils.openpojo;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;

public class ImplentsInterfaceFilter <T> implements PojoClassFilter{

    private Class<? extends T> wanted;

    public ImplentsInterfaceFilter(Class<? extends T> wanted) {
        this.wanted = wanted;
    }

    @Override
    public boolean include(PojoClass pojoClass) {
        return pojoClass.extendz(wanted);

    }
}
