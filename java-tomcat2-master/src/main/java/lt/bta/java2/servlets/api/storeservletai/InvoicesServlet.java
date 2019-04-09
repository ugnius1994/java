package lt.bta.java2.servlets.api.storeservletai;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lt.bta.java2.jpa.entities.Client;
import lt.bta.java2.jpa.entities.Invoice;
import lt.bta.java2.jpa.services.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

// GET = read
// POST = create
// PUT = update
// DELETE = delete
// tik naršyklėje ima duomenis
// priklausomai nuo užklausos tipo kviečima doGet arba doPost metodas
// jeigu response yra GET tipo užklausa, kvies doGet
// jeigu response yra POST tipo užklausa, kvies doPost
@WebServlet("/api/storeservletai/InvoicesServlet")
public class InvoicesServlet extends HttpServlet {

    int count = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
//        out.println("<h1>InvoicesServlet</h1><br>");
//        out.println("<a href=\"index.jsp\">index.jsp</a>");
//        out.println("skaitliukas count=" + ++count);

        // gauname ne tiesiogiai json, o greičiausiai html arba text
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");

        // ObjectMapper verčia faila į json
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.registerModule(new Hibernate5Module());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);


        Dao<Invoice> invoiceDao = new Dao<>(Invoice.class);
        Invoice invoice = invoiceDao.read(Integer.parseInt(id),  "invoices_line");
        if (invoice == null) {

            Response error = new Response("Invoice su tokiu ID " + id + " nėra", 100);
            mapper.writeValue(response.getWriter(), error);
            return;
        } else {

            // writeValue verčia new Response(invoice) į json ir gražina response per .getWriter
            mapper.writeValue(response.getWriter(), new Response(invoice));
            return;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

