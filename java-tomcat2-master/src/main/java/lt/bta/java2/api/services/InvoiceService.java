package lt.bta.java2.api.services;

import lt.bta.java2.api.filters.AccessRoles;
import lt.bta.java2.api.filters.Role;
import lt.bta.java2.api.requests.AddInvoiceLineRequest;
import lt.bta.java2.jpa.entities.InvLine;
import lt.bta.java2.jpa.entities.Invoice;
import lt.bta.java2.jpa.entities.Product;
import lt.bta.java2.jpa.services.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/invoice")
public class InvoiceService extends BaseService<Invoice> {

    // reikalaujama autorizacijos
    @Context
    private HttpServletRequest servletRequest;

    @Override
    protected Class<Invoice> getEntityClass() {
        return Invoice.class;
    }

    // reikalaujama autorizacijos
    @Override
//    @AccessRoles({Role.USER, Role.ADMIN}) // reikalaujama autorizacijos
    public Response list(int size, int skip) {
        HttpSession session = servletRequest.getSession();
        if (session.getAttribute("user") != null) {
            return super.list(size, skip);
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
//        return super.list(size, skip);
    }

    @GET
    @Path("/{id}/f")
    public Response getFull(@PathParam("id") int id) {

        Dao<Invoice> dao = createDao();
        Invoice entity = dao.read(id, Invoice.GRAPH_LINES);
        if (entity == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(entity).build();
    }

    // kaip dėti prekes į Invioce su foreignKey
    // http turi siųsti produkto id + json obj AddInvoiceLineRequest, kuriame yra produkto id ir qty
    @POST
    @Path("/{id}")
    public Response addInvoiseLine(@PathParam("id") int id, AddInvoiceLineRequest addInvoiceLineRequest) {

        Dao<Invoice> dao = createDao();
        Invoice invoice = dao.read(id);
        if (invoice == null) return Response.status(Response.Status.NOT_FOUND).build();

        Dao<Product> productDao = new Dao<>(Product.class);
        Product product = productDao.read(addInvoiceLineRequest.getId());
        if (product == null) return Response.status(Response.Status.NOT_FOUND).build();

        InvLine invLine = new InvLine();
        invLine.setInvoice(invoice);
        invLine.setQty(addInvoiceLineRequest.getQty());
        invLine.setProduct(product);
        invLine.setPrice(product.getPrice());

        invoice.getLines().add(invLine);
        invoice = dao.update(invoice);

        return Response.ok(invoice).build();
    }
}

