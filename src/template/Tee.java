package template;

public class Tee extends RefreshBeverage{

    @Override
    protected void brew() {
        System.out.println("使用80度热水冲泡绿茶");
    }

    @Override
    protected void addCondiments() {

    }

    @Override
    public boolean isCustomerWantsCondiments() {
        return false;
    }
}
