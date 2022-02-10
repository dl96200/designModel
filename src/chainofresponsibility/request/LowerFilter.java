package chainofresponsibility.request;



import lombok.extern.java.Log;

import java.util.Locale;
import java.util.logging.Level;

@Log
public class LowerFilter implements FilterInterface {
    @Override
    public void doFilter(Request req, Response resp, FilterChain fc) {
        this.doRequestFilter(req);
        fc.doFilter(req,resp,fc);
        this.doResponseFilter(resp);
    }

    @Override
    public void doRequestFilter(Request req) {
        String s = req.getRequestMsg().toLowerCase(Locale.ROOT);
        log.log(Level.INFO,"LowerFilter toLowerCase req==>[{0}]",s);
        req.setRequestMsg(s);
    }

    @Override
    public void doResponseFilter(Response resp) {
        String s = resp.getResponseMsg().toLowerCase(Locale.ROOT);
        log.log(Level.INFO,"LowerFilter toLowerCase resp==>[{0}]",s);
        resp.setResponseMsg(s);
    }
}
