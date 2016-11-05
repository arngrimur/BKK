package eu.arngrimur.bkk.userdomain.rest;

import eu.arngrimur.bkk.userdomain.rest.parameters.LoginParam;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.jetty.JettyTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerException;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;


@Ignore("Do later. Does not work now")
public class OperationsIntegrationTest extends JerseyTest {


    @Override
    protected Application configure() {
        return new ResourceConfig(Operations.class);
    }

    @Override
    protected TestContainerFactory getTestContainerFactory() throws TestContainerException {
        return new JettyTestContainerFactory();
    }

    @Test
    public void loginSuccess() throws Exception {
        LoginParam param = new LoginParam();
        param.setUsername("apa");
        param.setPassword("foo");

        Response response = target("/bkk/login").request().post(Entity.json(param), Response.class);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void ordersPathParamTest() {
        String response = target("login/453").request().get(String.class);
        Assert.assertTrue("orderId: 453".equals(response));
    }
}
