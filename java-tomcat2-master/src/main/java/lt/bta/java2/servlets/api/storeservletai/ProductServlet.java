package lt.bta.java2.servlets.api.storeservletai;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lt.bta.java2.jpa.entities.Invoice;
import lt.bta.java2.jpa.entities.Product;
import lt.bta.java2.jpa.services.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/storeservletai/ProductServlet")
public class ProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        PrintWriter out = response.getWriter();
//        out.println("<h1>InvoicesServlet</h1><br>");

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        // ObjectMapper verčia faila į json
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.registerModule(new Hibernate5Module());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        String id = request.getParameter("id");

        Dao<Product> productDao = new Dao<>(Product.class);
        Product product = productDao.read(1,  "invoices_line");
        if (product == null) {

            Response error = new Response("Invoice su tokiu ID " + id + " nėra", 100);
            // error verčia į
            mapper.writeValue(response.getWriter(), error);
            return;
        } else {

            // writeValue verčia new Response(invoice) į json ir gražina response per .getWriter
            mapper.writeValue(response.getWriter(), new Response(product));
            return;
        }

    }
}
