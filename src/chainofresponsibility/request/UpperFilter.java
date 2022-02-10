package chainofresponsibility.request;



import lombok.extern.java.Log;

import java.util.Locale;
import java.util.logging.Level;

@Log
public class UpperFilter implements FilterInterface {
    @Override
    public void doFilter(Request req, Response resp, FilterChain fc) {
        this.doRequestFilter(req);
        fc.doFilter(req,resp,fc);
        this.doResponseFilter(resp);
    }

    @Override
    public void doRequestFilter(Request req) {
        String s = req.getRequestMsg().replace(" ","");
        log.log(Level.INFO,"UpperFilter toUpperCas request==>[{0}]",s);
        req.setRequestMsg(s);
    }

    @Override
    public void doResponseFilter(Response resp) {
        String s = resp.getResponseMsg().replace(" ","");
        log.log(Level.INFO,"UpperFilter toUpperCase response ==>[{0}]",s);
        resp.setResponseMsg(s);
    }

}
