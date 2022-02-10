package cor;

import cor.handler.PriceHandler;
import cor.handler.Sales;

public class Customer {
    private PriceHandler priceHandler;

    public void setPriceHandler(PriceHandler priceHandler) {
        this.priceHandler = priceHandler;
    }

    public void requestDiscount(float discount){
        priceHandler.processDiscount(discount);
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setPriceHandler(PriceHandler.createPriceHandler());
        customer.requestDiscount((float) Math.random());
    }
}
