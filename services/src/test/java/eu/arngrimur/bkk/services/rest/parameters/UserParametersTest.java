package eu.arngrimur.bkk.services.rest.parameters;

import org.junit.Before;

import static org.junit.Assert.*;

public class UserParametersTest {

    private UserParameters userParameters;


    @Before
    public void setUp() throws Exception {
        userParameters = new UserParameters();
        userParameters.setUsername("user");
        userParameters.setPassword("aS1#as1!");
    }
}