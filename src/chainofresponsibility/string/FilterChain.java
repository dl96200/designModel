package chainofresponsibility.string;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements FilterInterface{
    private List<FilterInterface> filterList = new ArrayList<>();
    public FilterChain addFilter(FilterInterface filter){
        filterList.add(filter);
        return this;
    }
    public FilterChain removeFilter(FilterInterface filter){
        filterList.remove(filter);
        return this;
    }
    @Override
    public String doFilter(String msg) {
        String msgS = msg;
        for (FilterInterface filter: filterList) {
            msgS = filter.doFilter(msgS);
        }
        return msgS;
    }
}
