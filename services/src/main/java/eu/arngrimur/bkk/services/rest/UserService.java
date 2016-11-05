package eu.arngrimur.bkk.services.rest;

import eu.arngrimur.bkk.services.rest.parameters.LoginParam;
import eu.arngrimur.bkk.services.rest.parameters.UserParameters;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class UserService {
    @POST
    @Path("/createUser")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(final UserParameters userParameters){
        return Response.ok().build();
    }
}
