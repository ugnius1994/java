package lt.bta.java2.servlets.api.bandomasistriusis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lt.bta.java2.jpa.entities.Invoice;
import lt.bta.java2.jpa.services.Dao;
import lt.bta.java2.servlets.api.storeservletai.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "5 ServletBt5ObjectMapper", urlPatterns = "/ServletBt5ObjectMapper")
public class ServletBt5ObjectMapper extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        // ObjectMapper verčia faila į json

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.registerModule(new Hibernate5Module());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        Dao<Invoice> invoiceDao = new Dao<>(Invoice.class);
        Invoice invoice = invoiceDao.read(Integer.parseInt(id), "invoices_line");
        if (invoice == null) {

            Response error = new Response("Invoice su tokiu ID " + id + " nėra", 100);
            // error verčia į
            mapper.writeValue(response.getWriter(), error);
            return;
        } else {

            // writeValue verčia new Response(invoice) į json ir gražina response per .getWriter
            mapper.writeValue(response.getWriter(), new Response(invoice));
        }
        out.println("penktas dar nebaigtas, reikia ištirti ");







    }
}
