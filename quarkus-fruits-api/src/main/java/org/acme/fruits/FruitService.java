package org.acme.fruits;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/fruits")
@RegisterRestClient(configKey = "quarkus-fruits-data")
public interface FruitService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Fruit> listAll();

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Fruit findById(@PathParam("id") Long id);

}
