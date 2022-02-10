package chainofresponsibility.string;

import lombok.Data;

@Data
public class MsgProcessor {
    private String msg;
    private FilterChain fc;

    public String process(){
        return fc.doFilter(msg);
    }

    public static void main(String[] args) {
        MsgProcessor mp  = new MsgProcessor();
        mp.setMsg("asdad asdd  我啊");

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
