package lt.bta.java2.servlets.api.storeservletai;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private String error;
    private int errorCode;
    private Object data;

    public Response(Object data) {
        this.data = data;
    }

    public Response(String error, int err) {
        this.error = error;
        this.errorCode = err;
    }

    public String getError() {
        return error;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public Object getData() {
        return data;
    }
}
