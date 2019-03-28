package java.Api;


import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.ws.rs.ApplicationPath;
import java.Api.impl.InvoiceService;
import java.Api.impl.ProductService;


@ApplicationPath("/api")
public class App extends ResourceConfig {

    public App() {
        register(ObjectMapperContextResolver.class);
        register(InvoiceService.class);
        register(ProductService.class);
        property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true); //jeigu grazinsim 401 403 kodus, tai nematysim standartinio tomacat psl
    }

    //extends Application
//    @Override
//    public Set<Class<?>> getClasses(){
//        Set<Class<?>> resources = new HashSet<>();
//        resources.add(ObjectMapperContextResolver.class);
//        resources.add(InvoiceServiceImpl.class);
//
//        return resources;
//    }
}
