package cor.handler;

public class VicePresident extends PriceHandler{

    @Override
    public void processDiscount(float discount) {
        if(discount<0.50){
            System.out.format("%s批准了折扣，%.2f%n",this.getClass().getName(),discount);
        } else {
            this.successor.processDiscount(discount);
        }
    }
}
