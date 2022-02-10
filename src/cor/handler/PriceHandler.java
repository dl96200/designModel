package cor.handler;

public abstract class PriceHandler {
    //直接后继，用于传递请求
    protected PriceHandler successor;

    public static PriceHandler createPriceHandler() {
        PriceHandler sales = new Sales();
        PriceHandler manager = new Manager();
        PriceHandler director = new Director();
        PriceHandler vicePresident = new VicePresident();
        PriceHandler ceo = new CEO();
        sales.setSuccessor(manager);
        manager.setSuccessor(director);
        director.setSuccessor(vicePresident);
        vicePresident.setSuccessor(ceo);
        return sales;
    }

    public PriceHandler getSuccessor() {
        return successor;
    }

    public void setSuccessor(PriceHandler successor) {
        this.successor = successor;
    }
    /**
     * 处理则扣申请
     */
    public abstract void processDiscount(float discount);
}
