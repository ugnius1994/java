package java.lt.bta.Java2.servlets.api;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.dao.Dao;
import java.entities.Product;
import java.helpers.EntityManagerHelper;
import java.io.IOException;

@WebServlet("/a/product")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        Dao<Product> productDao=new Dao<>(EntityManagerHelper.getEntityManager());
        //TODO if id =1, kviesti read, jei yra ir skip ir size, kviesti list

    }
}
