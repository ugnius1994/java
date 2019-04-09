package lt.bta.java2.servlets.api.pirmiejiservletai;

import lt.bta.java2.Main;
import lt.bta.java2.jpa.entities.Client;
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

@WebServlet(name = "Servlet1First", urlPatterns = {"/pirmas", "/antras2/*"})
public class Servlet1First extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String txt = Main.gautiDBtoString();
        out.println("<h1>Servlet1First</h1>");
        out.println("<a href=\"index.jsp\">index.jsp</a>");

        if (txt != null) {

            out.println("<p>txt.lenght daugiau už 0</p>");
            out.println(txt);
        } else {

            out.println("<p>STOP KLAIDA</p>");
        }

        { // atspausdinti Client + Invoices + Products
            Dao<Client> clientDao = new Dao<>(Client.class);
            Client client = clientDao.read(1, Client.CLIENTS_INVOICES_ONLY); // grafo pavadinimas
            out.println("<h5>" + client.toStringClientInvoices() + "</h5>");
        }

        { // atspausdinti Invoices + Products
            Dao<Invoice> invoiceDao = new Dao<>(Invoice.class);
            Invoice invoice = invoiceDao.read(1, "invoices_line"); // grafo pavadinimas
            out.println("<h5>" + invoice + "</h5>");
        }

        { // atspausdinti Client.city
            Dao<Invoice> invoiceDao = new Dao<>(Invoice.class);
            Invoice invoice = invoiceDao.read(1, "invoices_line"); // grafo pavadinimas
            out.println("<h5>" + invoice.getClient().getCity() + "</h5>");
        }
    }
}
