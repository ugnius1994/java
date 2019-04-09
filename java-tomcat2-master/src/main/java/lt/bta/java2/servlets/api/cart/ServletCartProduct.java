package lt.bta.java2.servlets.api.cart;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lt.bta.java2.jpa.entities.CartLine;
import lt.bta.java2.jpa.services.Dao;
import lt.bta.java2.servlets.api.storeservletai.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// GET = read
// POST = create
// PUT = update
// DELETE = delete
// tik naršyklėje ima duomenis
// priklausomai nuo užklausos tipo kviečima doGet arba doPost metodas
// jeigu response yra GET tipo užklausa, kvies doGet
// jeigu response yra POST tipo užklausa, kvies doPost
@WebServlet("/api/json-cart-product")
public class ServletCartProduct extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");

        // ObjectMapper verčia faila į json
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.registerModule(new Hibernate5Module());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
// TODO Cart Graph
//        Dao<CartLine> cartLineDao = new Dao<>(CartLine.class);
//        CartLine cartLine = cartLineDao.read(Integer.parseInt(id), CartLine.CART_PRODUCT_LINE);
//
//        if (cartLine == null) {
//
//            Response error = new Response("Cart su tokiu ID " + id + " nėra", 100);
//            mapper.writeValue(response.getWriter(), error);
//            return;
//        }
//
//        mapper.writeValue(response.getWriter(), new Response(cartLine));
    }
}

