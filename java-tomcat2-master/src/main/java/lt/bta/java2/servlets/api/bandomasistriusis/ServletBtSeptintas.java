package lt.bta.java2.servlets.api.bandomasistriusis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lt.bta.java2.jpa.entities.Invoice;
import lt.bta.java2.jpa.services.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

@WebServlet(name = "7 request info pvz iš interneto", urlPatterns = "/ServletBtSeptintas")
public class ServletBtSeptintas extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {

        PrintWriter pr = response.getWriter();

        pr.println("=== Paths ===\n");
        pr.println("Request URL : " + request.getRequestURL());
        pr.println("Request URI : " + request.getRequestURI());
        pr.println("Servlet path : " + request.getServletPath());

        pr.println("\n=== Headers ===\n");
        Enumeration<String> e = request.getHeaderNames();
        while(e.hasMoreElements()){
            String param = (String) e.nextElement();
            pr.println(param + " : " + request.getHeader(param));
        }

        pr.println("\n=== Parameters ===\n");
        Map<String, String[]> paramsMap = request.getParameterMap();
        for (String key : paramsMap.keySet()) {
            pr.println(key + " : " + request.getParameter(key));
        }

        pr.println("\n=== Session ===\n");
        // returns 0:0:0:0:0:0:0:1 if executed skip localhost
        pr.println("Client IP address : " + request.getRemoteAddr());
        pr.println("Session ID : " + request.getRequestedSessionId());
        // Cookie objects the client sent with this request
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                pr.print(cookie.getName() + ";");
            }
        }
    }
}
