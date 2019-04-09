package lt.bta.java2.servlets.api.bandomasistriusis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lt.bta.java2.jpa.entities.Invoice;
import lt.bta.java2.jpa.helpers.EntityManagerHelper;
import lt.bta.java2.jpa.services.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "6 id1 + id2", urlPatterns = "/ServletBtSestas")
public class ServletBtSestas extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id1 = request.getParameter("id1");
        String id2 = request.getParameter("id2");

        // ObjectMapper verčia faila į json
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.registerModule(new Hibernate5Module());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);


        Dao<Invoice> invoiceDao = new Dao<>(Invoice.class);
        Invoice invoice = invoiceDao.read(Integer.parseInt(id1), "invoices_line");

        out.println(invoice);
        out.println(id2);




    }
}
