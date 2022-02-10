package chainofresponsibility.request;

import lombok.Data;

@Data
public class MsgProcessor {
    private Request request;
    private Response response;
    private FilterChain fc;

    public void process(){

        fc.doFilter(request,response,fc);
    }

}
