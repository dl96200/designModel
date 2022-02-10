package chainofresponsibility.string;

import lombok.extern.java.Log;

import java.util.logging.Level;
@Log
public class TrimFilter implements FilterInterface {
    @Override
    public String doFilter(String msg) {
        String s = msg.replace(" ","");
        log.log(Level.INFO,"TrimFilter trim ==>[{0}]",s);
        return s;
    }
}
