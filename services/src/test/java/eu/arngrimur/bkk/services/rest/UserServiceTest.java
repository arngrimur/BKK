package eu.arngrimur.bkk.services.rest;

import eu.arngrimur.bkk.services.rest.parameters.UserParameters;
import eu.arngrimur.bkk.services.rest.validation.InputValidationException;
import eu.arngrimur.bkk.services.rest.validation.InputValidator;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class UserServiceTest {

    private UserService userService;
    private UserParameters user;
    private InputValidator inputValidator;

    @Before
    public void setUp() throws Exception {
        userService = new UserService();
        inputValidator = mock(InputValidator.class);
        userService.setInputValidator(inputValidator);
        user = generateUser();
    }

    private UserParameters generateUser() {
        UserParameters userParameters = new UserParameters();
        userParameters = new UserParameters();
        userParameters.setUsername("user");
        userParameters.setPassword("aS1#as1!");
        userParameters.setFirstName("firstname");
        userParameters.setLastName("lastname");
        userParameters.setCity("city");
        userParameters.setPostbox("41458");
        userParameters.setStreet("street");

        return userParameters;
    }
    @Test
    public void userIsCreatedSuccessfully()  {
        Response response = userService.createUser(user);
        assertEquals(Response.ok().build().getStatus(), response.getStatus());
    }


    @Test
    public void invalidUserData() throws Exception{
        UserParameters invalidUser = generateUser();
        user.setUsername("1");
        HashSet<String> error = new HashSet<>();
        error.add("Invalid user name, too short");
        doThrow(new InputValidationException(error)).when(inputValidator).validate(invalidUser);
        Response response = userService.createUser(invalidUser);
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
        Set<String> errors = (Set<String>) response.getEntity();
        assertEquals(1, errors.size());
        assertEquals("Invalid user name, too short", errors.iterator().next());
    }
}