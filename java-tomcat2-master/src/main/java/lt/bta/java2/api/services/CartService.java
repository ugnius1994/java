package lt.bta.java2.api.services;

import lt.bta.java2.api.filters.AccessRoles;
import lt.bta.java2.api.filters.Role;
import lt.bta.java2.jpa.entities.CartLine;
import lt.bta.java2.jpa.services.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/cart")
public class CartService extends BaseService<CartLine> {

    // reikalaujama autorizacijos
    @Context
    private HttpServletRequest servletRequest;

    @Override
    protected Class<CartLine> getEntityClass() {
        return CartLine.class;
    }

    @Override
    @AccessRoles({Role.USER, Role.ADMIN}) // reikalaujama autorizacijos
    public Response list(int size, int skip) {
//        HttpSession session = servletRequest.getSession();
//        if (session.getAttribute("user") != null) {
//            return super.list(size, skip);
//        }
//        return Response.status(Response.Status.UNAUTHORIZED).build();
        return super.list(size, skip);
    }

    // todo kaip gauti visus įrašus su prekėmus (json)
    @Override
    @AccessRoles({Role.USER, Role.ADMIN}) // reikalaujama autorizacijos
    public Response listAll() {

        Dao<CartLine> dao = createDao();
        return Response.ok().entity(dao.listAll()).build();
    }
}
