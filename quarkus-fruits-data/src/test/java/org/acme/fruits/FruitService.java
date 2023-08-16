package org.acme.fruits;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

public interface FruitService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Fruit> listAll();

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Fruit findById(Long id);
}
