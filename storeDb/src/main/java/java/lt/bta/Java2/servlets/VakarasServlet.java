package java.lt.bta.Java2.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "VakarasServlet", urlPatterns = {"/vakaras/*"})// /* <- reiskia kad url patern gali buti betkas po /vakaras
 public class VakarasServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private int count;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter= response.getWriter();
        printWriter.println("labas "+ ++count);
    }

    //kuria objekta servletai
}
