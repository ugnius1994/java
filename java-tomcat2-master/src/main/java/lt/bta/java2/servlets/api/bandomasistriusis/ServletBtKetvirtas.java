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
import java.util.List;

@WebServlet(name = "4 gauti visus klientus paga id", urlPatterns = "/ServletBtKetvirtas")
public class ServletBtKetvirtas extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");

        Dao<Invoice> invoiceDao = new Dao<>(Invoice.class);
        List<Invoice> invoices = invoiceDao.list( 2, 1);
        out.println("<h4>Jūsų invoice=:" + invoices.toString() + "</h4><br>");


    }
}
