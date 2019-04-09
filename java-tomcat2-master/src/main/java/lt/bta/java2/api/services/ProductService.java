package lt.bta.java2.api.services;

import lt.bta.java2.api.filters.AccessRoles;
import lt.bta.java2.api.filters.Role;
import lt.bta.java2.jpa.entities.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/product")
public class ProductService extends BaseService<Product> {

    // reikalaujama autorizacijos
    @Context
    private HttpServletRequest servletRequest;

    @Override
    protected Class<Product> getEntityClass() {
        return Product.class;
    }

    // reikalaujama autorizacijos
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
}
