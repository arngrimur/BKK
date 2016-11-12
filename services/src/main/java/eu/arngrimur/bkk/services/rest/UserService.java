package eu.arngrimur.bkk.services.rest;

import eu.arngrimur.bkk.services.rest.parameters.UserParameters;
import eu.arngrimur.bkk.services.rest.validation.InputValidationException;
import eu.arngrimur.bkk.services.rest.validation.InputValidator;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class UserService {


    private InputValidator inputValidator;

    @Inject
    public void setInputValidator(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    @POST
    @Path("/createUser")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(final UserParameters userParameters) {
        try {
            inputValidator.validate(userParameters);
            return Response.ok().build();
        } catch (InputValidationException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getErrors()).build();
        }
    }
}
