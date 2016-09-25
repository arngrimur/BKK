package eu.arngrimur.bkk.rest;

import eu.arngrimur.bkk.rest.parameters.LoginParam;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/bkk")
public class Operations {
    @Produces("application/json")
    public Response login(final LoginParam loginParam){
        return Response.ok().build();
    }

}
