package decorator.eg;

public class RedBeanDecorator extends Decorator{
    public RedBeanDecorator(Drink drink) {
        super(drink);
    }

    @Override
    public double price() {
        return super.price()+3.2;
    }

    @Override
    public String desc() {
        return super.desc()+"+红豆";
    }
}
