package chainofresponsibility.request;


import java.util.ArrayList;
import java.util.List;
public class FilterChain implements FilterInterface {
    private List<FilterInterface> filterList = new ArrayList<>();
    private int index;
    public FilterChain addFilter(FilterInterface filter){
        filterList.add(filter);
        return this;
    }
    public FilterChain removeFilter(FilterInterface filter){
        filterList.remove(filter);
        return this;
    }

    public FilterInterface getFilter(int index) {
        return this.filterList.get(index);
    }
    @Override
    public void doFilter(Request req, Response resp, FilterChain fc) {
        if(index >= this.filterList.size()) {
            return ;
        }
        FilterInterface filter = fc.getFilter(index);
        index++;
        if(filter instanceof FilterChain) {
            ((FilterChain) filter).doFilter(req,resp,(FilterChain) filter);
        } else {
            filter.doFilter(req,resp,fc);
        }
    }
    public void doFilter(Request req, Response resp, FilterChain parent,FilterChain local) {
        local.doFilter(req,resp,local);
        parent.doFilter(req,resp,parent);
    }


    @Override
    public void doRequestFilter(Request req) {

    }

    @Override
    public void doResponseFilter(Response req) {

    }
}
