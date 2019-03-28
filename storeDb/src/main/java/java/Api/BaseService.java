package java.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BaseService<T> {

    @POST
    Response add(T e);

    @DELETE
    @Path("/{id}")
    Response delete(@PathParam("id") int id);

    @GET
    @Path("/{id}")
    Response get(@PathParam("id") int id);

    @PUT
    @Path("/{id}")
    Response update(@PathParam("id") int id, T e);

    @GET
    @Path("/list")
    Response getPage(@QueryParam("size") @DefaultValue("5") int size, @QueryParam("skip") @DefaultValue("0") int skip);

}