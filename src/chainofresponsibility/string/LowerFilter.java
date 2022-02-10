package chainofresponsibility.string;



import lombok.extern.java.Log;

import java.util.Locale;
import java.util.logging.Level;

@Log
public class LowerFilter implements FilterInterface{
    @Override
    public String doFilter(String msg) {
        String s = msg.toLowerCase(Locale.ROOT);
        log.log(Level.INFO,"UpperFilter toLowerCase ==>[{0}]",s);
        return s;
    }
}
