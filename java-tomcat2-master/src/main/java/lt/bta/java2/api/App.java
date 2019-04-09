package lt.bta.java2.api;

import lt.bta.java2.api.filters.AuthenticationFilter;
import lt.bta.java2.api.services.CartService;
import lt.bta.java2.api.services.InvoiceService;
import lt.bta.java2.api.services.ProductService;
import lt.bta.java2.api.services.UserService;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.ws.rs.ApplicationPath;

// RESTful applikacija sukuria obeektus paga reqest užklasas ir sukuria atitinkamus objektus
// pvz jeigu ateina ligin tai kuriamas UserService ojjaktas ir kreipiamasi į jos atitinkamą metodą
@ApplicationPath("/api")
public class App extends ResourceConfig {

    public App() {
        register(ObjectMapperContextResolver.class);
        register(InvoiceService.class);
        register(ProductService.class);
        register(UserService.class);
        register(AuthenticationFilter.class);
        register(CartService.class);
        property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);
    }
}
