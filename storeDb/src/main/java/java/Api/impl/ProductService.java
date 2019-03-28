package java.Api.impl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.entities.Product;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ProductService {
    @POST
    Response add(Product e);

    @DELETE
    @Path("/{id}")
    Response delete(@PathParam("id") int id);

    @GET
    @Path("/{id}")
    Response get(@PathParam("id") int id);

    @PUT
    @Path("/{id}")
    Response update(@PathParam("id") int id, Product e);

    @GET
    @Path("/list")
    Response list(@QueryParam("size") @DefaultValue("10") int size, @QueryParam("skip") @DefaultValue("0") int skip);
}

