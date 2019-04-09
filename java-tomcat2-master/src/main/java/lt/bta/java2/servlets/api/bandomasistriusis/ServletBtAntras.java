package lt.bta.java2.servlets.api.bandomasistriusis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "2 antras", urlPatterns = "/ServletBtAntras")
public class ServletBtAntras extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("<h5>čia doPost metodas</h5>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");

        if (id == null) {

            out.println("<h1>Jūsų id=:" + id + "</h1><br>");
        } else {

            doPost(request, response);
            out.println("<h1>Jūsų id=:" + id + " todėl vykdomas doPost metodas</h1><br>");
        }
    }
}
