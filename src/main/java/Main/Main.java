package Main;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Product;

import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper=new ObjectMapper();
        try {
            Product product = mapper.readValue(new URL("http://makeup-api.herokuapp.com/api/v1/products.json"), Product.class);
            System.out.println(product.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
