package chainofresponsibility.request;

public class Main {

    public static void main(String[] args) {
        MsgProcessor mp  = new MsgProcessor();

        mp.setRequest(new Request("asdad asdd  我啊"));
        mp.setResponse(new Response("asdad qeqewQqe  我啊\""));

        FilterChain filterChainSub = new FilterChain();
        filterChainSub.addFilter(new ReplaceA2BFilter())
                .addFilter(new LowerFilter());

        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new UpperFilter())
                .addFilter(filterChainSub)
                .addFilter(new TrimFilter());


        mp.setFc(filterChain);
        mp.process();
    }
}
