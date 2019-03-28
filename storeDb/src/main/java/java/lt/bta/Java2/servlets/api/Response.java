package java.lt.bta.Java2.servlets.api;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) //<-reikalinga kad nerodytu "null" reiksmiu
public class Response {
    public String error;
    public int errorCode;
    public Object data;

    public Response(String error, int errorCode, Object data) {
        this.error = error;
        this.errorCode = errorCode;
        this.data = data;
    }

    public Response(Object data) {
        this.data = data;
    }
}
