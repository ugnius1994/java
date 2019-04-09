package DB.Api.impl;


import DB.Api.BaseService;
import DB.dao.Dao;
import DB.entities.InvLine;
import DB.entities.Invoice;
import DB.entities.Product;
import Requst.AddInvoice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;









@Path("/invoice")
public class InvoiceServiceImp extends BaseService {

    @Override
    protected  Class<Invoice> getEntityClass(){return Invoice.class;}





    @GET
    @Path("{id}/f")
    public Response getFull(@PathParam("id")int id){
        Dao<Invoice> dao =createDao();
        Invoice entity=dao.read(id,Invoice.GRAPH_LINE);
        if (entity==null)return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(entity).build();
    }

    @POST
    @Path("/{id}")
    public Response addInvoiceLine(@PathParam("id")int id, AddInvoice addInvoice){
        Dao<Invoice> dao =createDao();
        Invoice invoice =dao.read(id);
        if (invoice==null)return Response.status(Response.Status.NOT_FOUND).build();


        Dao<Product> productDao=new Dao<>(Product.class);
        Product product =productDao.read(addInvoice.getId());
        if (product==null)return Response.status(Response.Status.NOT_FOUND).build();



        InvLine invLine =new InvLine();
        invLine .setInvoice(invoice);
        invLine.setQuantity(addInvoice.getQty());
        invLine.setProduct(product);
        invLine.setPrice(product.getPrice());

        invoice.getInvLines().add(invLine);
        invoice=dao.update(invoice);
        return Response.ok(invoice).build();
    }

}
