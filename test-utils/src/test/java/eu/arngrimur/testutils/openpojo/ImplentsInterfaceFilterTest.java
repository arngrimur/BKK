package eu.arngrimur.testutils.openpojo;

import org.junit.Test;

public class ImplentsInterfaceFilterTest {

    @Test
    public void valid() throws Exception {
        new ImplentsInterfaceFilter<SampleInterface>(Valid.class);

    }

    private interface SampleInterface{}

    private class Valid implements SampleInterface {}
}