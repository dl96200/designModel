package chainofresponsibility.request;



import lombok.extern.java.Log;

import java.util.logging.Level;

@Log
public class ReplaceA2BFilter implements FilterInterface {
    @Override
    public void doFilter(Request req, Response resp, FilterChain fc) {
        this.doRequestFilter(req);
        fc.doFilter(req,resp,fc);
        this.doResponseFilter(resp);
    }

    @Override
    public void doRequestFilter(Request req) {
        String s = req.getRequestMsg().replace("A","B");
        log.log(Level.INFO,"ReplaceA2BFilter replaceA2B req==>[{0}]",s);
        req.setRequestMsg(s);
    }

    @Override
    public void doResponseFilter(Response resp) {
        String s = resp.getResponseMsg().replace("A","B");
        log.log(Level.INFO,"ReplaceA2BFilter replaceA2B resp==>[{0}]",s);
        resp.setResponseMsg(s);
    }
}
