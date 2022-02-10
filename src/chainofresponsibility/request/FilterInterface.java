package chainofresponsibility.request;

public interface FilterInterface {
    public void doFilter(Request req,Response resp, FilterChain fc);
    public void doRequestFilter(Request req);
    public void doResponseFilter(Response req);
}
