package chainofresponsibility.string;



import lombok.extern.java.Log;

import java.util.logging.Level;

@Log
public class ReplaceA2BFilter implements FilterInterface{
    @Override
    public String doFilter(String msg) {
        String s = msg.replace("A","B");
        log.log(Level.INFO,"UpperFilter replaceA2B ==>[{0}]",s);
        return s;
    }
}
