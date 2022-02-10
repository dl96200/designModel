package template;

public class Client {
    public static void main(String[] args) {
        RefreshBeverage coffee = new Coffee();
        coffee.prepareBeverageTemplate();
        RefreshBeverage tee = new Tee();
        tee.prepareBeverageTemplate();
    }
}
