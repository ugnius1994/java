package lt.bta.java2.servlets.api.bandomasistriusis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "0 pagrindinis", urlPatterns = "/ServletBt0Pagrindinis")
public class ServletBt0Pagrindinis extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // 1
        out.println("<a href=\"ServletBtPirmas\">ServletBtPirmas - nieko</a><br>");
        out.println("<a href=\"ServletBtPirmas?id=55\">ServletBtPirmas - id=55 kelti kvadratu String id = request.getParameter(\"id\")</a><br>");
        // 2
        out.println("<a href=\"ServletBtAntras\">ServletBtAntras doPost metode atspausdina tekstą</a><br>");
        out.println("<a href=\"ServletBtAntras?id=1\">ServletBtAntras - id=1</a><br>");
        // 3
        out.println("<h5>Parodyti Invoice pagal id</h5>");
        out.println("<h5><a href=\"ServletBtTrecias?id=1\">ServletBtTrecias, id=1, parodyti Invoice pagal id</a></h5>");
        out.println("<h5><a href=\"ServletBtTrecias?id=2\">ServletBtTrecias, id=2, parodyti Invoice pagal id</a></h5>");
        out.println("<h5><a href=\"ServletBtTrecias?id=3\">ServletBtTrecias, id=3, parodyti Invoice pagal id</a></h5>");
        // 4
        out.println("<h5><a href=\"ServletBtKetvirtas\">ServletBtKetvirtas, parodyti Invoice nuo 2 iki 3</a></h5>");
        // 5
        out.println("<h5><a href=\"ServletBt5ObjectMapper\">ServletBt5ObjectMapper, ObjectMapper turi grąžinti json objektą();</a></h5>");
        // 6
        out.println("<h5><a href=\"ServletBtSestas?id1=1&id2=2\">ServletBtSestas, ?id1=1 & id2=2</a></h5>");
        // 7
        out.println("<h5><a href=\"ServletBtSeptintas?id1=1&id2=2\">ServletBtSeptintas, Servlet Request Info Example</a></h5>");
    }
}
