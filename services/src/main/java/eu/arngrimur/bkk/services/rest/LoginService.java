package eu.arngrimur.bkk.services.rest;

import eu.arngrimur.bkk.services.rest.parameters.LoginParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/bkk")
public class LoginService {
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(final LoginParam loginParam){
        return Response.ok().build();
    }
}
