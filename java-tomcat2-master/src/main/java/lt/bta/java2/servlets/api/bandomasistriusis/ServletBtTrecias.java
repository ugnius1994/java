package lt.bta.java2.servlets.api.bandomasistriusis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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

@WebServlet(name = "3 gauti klienta pagal id", urlPatterns = "/ServletBtTrecias")
public class ServletBtTrecias extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        ObjectMapper mapper = new ObjectMapper(); // ObjectMapper verčia faila į json
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        Dao<Invoice> invoiceDao = new Dao<>(Invoice.class);
        Invoice invoice = invoiceDao.read(Integer.parseInt(id),  "invoices_line");
        out.println("<h1>Jūsų invoice id=:" + id + "</h1><br>");
        out.println("<h4>Jūsų invoice=:" + invoice + "</h4><br>");


    }
}
