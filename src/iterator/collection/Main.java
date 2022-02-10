package iterator.collection;

import lombok.extern.java.Log;

import java.util.Collections;
import java.util.logging.Level;

@Log
public class Main {
    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<Integer>();
        for(int i=0;i<100;i++) {
           c.add(i);
        }
        Iterator i = c.iterator();
        while(i.hasNext()) {
            Integer e = (Integer) i.next();
            log.log(Level.INFO," element value==>{0}",e);
        }
    }
}
