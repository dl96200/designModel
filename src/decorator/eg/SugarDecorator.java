package decorator.eg;

public class SugarDecorator extends Decorator{
    public SugarDecorator(Drink drink) {
        super(drink);
    }

    @Override
    public double price() {
        return super.price()+2.1;
    }

    @Override
    public String desc() {
        return super.desc()+"+糖";
    }
}
