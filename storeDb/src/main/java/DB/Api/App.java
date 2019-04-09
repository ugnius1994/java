package DB.Api;


import DB.Api.impl.InvoiceServiceImp;
import DB.Api.impl.ProductServiceImp;
import DB.entities.UserService;
import DB.token.AuthenticationFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.ws.rs.ApplicationPath;


@ApplicationPath("/api")
public class App extends ResourceConfig {

    public App() {
        register(ObjectMapperContextResolver.class);
        register(InvoiceServiceImp.class);
        register(ProductServiceImp.class);
        register(UserService.class);
        register(AuthenticationFilter.class);
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
