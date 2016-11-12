package eu.arngrimur.bkk.services.rest.parameters;

import org.junit.Before;
import org.junit.Test;

public class UserParametersTest {

    private UserParameters userParameters;


    @Before
    public void setUp() throws Exception {
        userParameters = new UserParameters();
        userParameters.setUsername("user");
        userParameters.setPassword("aS1#as1!");
        userParameters.setFirstName("firstname");
        userParameters.setLastName("lastname");
        userParameters.setCity("city");
        userParameters.setPostbox("41458");
        userParameters.setStreet("street");
    }

    @Test
    public void validUser() throws Exception {

    }
}