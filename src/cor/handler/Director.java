package cor.handler;

public class Director extends PriceHandler{

    @Override
    public void processDiscount(float discount) {
        if(discount<0.40){
            System.out.format("%s批准了折扣，%.2f%n",this.getClass().getName(),discount);
        } else {
            this.successor.processDiscount(discount);
        }
    }
}
