package lt.bta.java2.servlets.api.pirmiejiservletai;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

@WebServlet("/ServletFundamental")
public class ServletFundamental extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8"); // lietuviškos raidės
        PrintWriter out = response.getWriter();
        out.println("<h1>ServletFundamental</h1>");
        out.println("<a href=\"index.jsp\">index.jsp</a>");
        fundamental(request,response);
    }

    // metodas skirtas tik laikyti įvairiems kodo pavyzdžiams
    public static void fundamental(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("<h1>čia ServletFundamental klasės fundamental metodas</h1>");
        out.println("<h4>šis metodas turėtų pasileisti su 1 sec. uždelsimu</h4>");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp"); // peršoka į nurodytą puslapį automatiškai
        }
    }
}