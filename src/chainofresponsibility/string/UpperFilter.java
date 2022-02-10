package chainofresponsibility.string;



import lombok.extern.java.Log;

import java.util.Locale;
import java.util.logging.Level;

@Log
public class UpperFilter implements FilterInterface{
    @Override
    public String doFilter(String msg) {
        String s = msg.toUpperCase(Locale.ROOT);
        log.log(Level.INFO,"UpperFilter toUpperCas ==>[{0}]",s);
        return s;
    }
}
