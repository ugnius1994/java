package java.lt.bta.Java2.servlets.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.dao.Dao;
import java.entities.Invoice;
import java.helpers.EntityManagerHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/a/invoice")
public class InvoiceServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

//        {
//            Gson gson=new Gson();

//            PrintWriter printWriter = resp.getWriter(); //<- sita gaunam prinwriter is Tomcat
        //Seriazible <- how will binary data will be converted to String data, Serializable = will we will
        // be able to convert object to Read from Stream or not, both ways.
        //200 - all good, 300 - good, but redirected, 400- kliento klaida(blogos uzklausos)
        // , 500- serverio klaidos(blogas slaptazodis ir pan)

//            Dao<Invoice> invoiceDao = new Dao<>();
//
//            String id = req.getParameter("id"); //request <- http://blabla?id=1 <- is cia paima reikiama id
//
//            Invoice invoice = invoiceDao.read(Invoice.class, Integer.valueOf(id));
//
//            if (id == null) {
//                Response response = new Response("Nenurodytas id", 100, "belekas");
//            } else {
//            Response data=new Response(invoice);
//            gson.toJson(data,resp.getWriter());
//            }


//        }
//        if (id==null){
////            printWriter.println("nenurodytas id");
////            printWriter.println("{\"error\": \"nenurodytas id\"}");
//            Response response= new Response("Nenurodytas id",100);
//            gson.toJson(response,resp.getWriter());
//            return;
//        }

        {
            PrintWriter printWriter = resp.getWriter(); //<- Writer kūrimu uzsiima tomacat
            String id = req.getParameter("id"); //request <- http://blabla?id=1 <- is cia paima reikiama id

            ObjectMapper mapper = new ObjectMapper(); //<- JSON
            mapper.registerModule(new JavaTimeModule());
            mapper.registerModule(new Hibernate5Module()); //
            mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS,false); //<- normaliai dirba su Date fromatu without extra unusefull info such as century etc...

            Dao<Invoice> invoiceDao = new Dao<>(EntityManagerHelper.getEntityManager());
            Invoice invoice = invoiceDao.read(Invoice.class, Integer.valueOf(id));
            List<Invoice> invoiceList=invoiceDao.list(Invoice.class,2,0);
            invoiceList.forEach(x->printWriter.println(x));

//            if (invoice == null) {
//                printWriter.println("Invoice su tokiu id " + id + " nėra");
//                Response response = new Response("Nurodytas id neegzistuoja");
//                mapper.writeValue(resp.getWriter(), response); //writer <- same as output stream, tekstinis
//            } else {
//                mapper.writeValue(resp.getWriter(), new Response(invoice));
////                printWriter.println("Data: " + invoice.getDate() + ", id: " + invoice.getId() + ".");
//            }
        }
    }
}

